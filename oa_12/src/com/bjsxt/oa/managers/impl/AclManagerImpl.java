package com.bjsxt.oa.managers.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bjsxt.oa.managers.AclManager;
import com.bjsxt.oa.model.ACL;
import com.bjsxt.oa.model.Permission;

public class AclManagerImpl extends AbstractManager implements AclManager {

	//授权过程
	public void addOrUpdatePermission(String principalType, int principalSn,
			int resourceSn, int permission, boolean yes) {
		
		//根据主体标识和资源标识查找ACL实例
		ACL acl = findACL(principalType, principalSn, resourceSn);
		
		//如果存在ACL实例，则更新其授权
		if(acl != null){
			acl.setPermission(permission, yes);
			getHibernateTemplate().update(acl);
			return;
		}
		
		//不存在ACL实例，则创建ACL实例
		acl = new ACL();
		acl.setPrincipalType(principalType);
		acl.setPrincipalSn(principalSn);
		acl.setResourceSn(resourceSn);
		acl.setPermission(permission, yes);
		getHibernateTemplate().save(acl);
	}

	//设置用户某个资源授权的继承特性
	public void addOrUpdateUserExtends(int userId, int resourceSn, boolean yes) {
		
		//根据主体标识和资源标识查找ACL实例
		ACL acl = findACL(ACL.TYPE_USER, userId, resourceSn); 
		
		//如果存在ACL实例，则更新其授权
		if(acl != null){
			acl.setExtends(yes);
			getHibernateTemplate().update(acl);
			return;
		}
		
		//不存在ACL实例，则创建ACL实例
		acl = new ACL();
		acl.setPrincipalType(ACL.TYPE_USER);
		acl.setPrincipalSn(userId);
		acl.setResourceSn(resourceSn);
		acl.setExtends(yes);
		getHibernateTemplate().save(acl);
	}

	//删除授权
	public void delPermission(String principalType, int principalSn,
			int resourceSn) {
		getHibernateTemplate().delete(findACL(principalType, principalSn, resourceSn));
	}

	//即时认证
	public boolean hasPermission(int userId, int resourceSn, int permission) {
		
		//查找直接授予用户的授权
		ACL acl = findACL(ACL.TYPE_USER, userId, resourceSn);
		
		if(acl != null){
			int yesOrNo = acl.getPermission(permission);
			
			//如果是确定的授权
			if(yesOrNo != ACL.ACL_NEUTRAL){
				return yesOrNo == ACL.ACL_YES ? true : false;
			}
		}
		
		//继续查找用户的角色授权
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " +
				"where u.id = ? order by ur.orderNo";
		List<?> aclIds = getHibernateTemplate().find(hql, userId);
		
		//依照角色优先级依次查找其授权
		for (Iterator<?> iter = aclIds.iterator(); iter.hasNext();) {
			Integer rid = (Integer) iter.next();
			acl = findACL(ACL.TYPE_ROLE, rid, resourceSn);
			
			//一旦发现授权，即可返回结果
			if(acl != null){
				return acl.getPermission(permission) == ACL.ACL_YES ? true : false;
			}
		}
		
		return false;
	}

	public boolean hasPermissionByResourceSn(int userId, String resourceSn, int permission) {
		
		String hql = "select m.id from Module m where m.sn = ? ";
		
		return hasPermission(
				userId,
				(Integer)getSession().createQuery(hql).setParameter(0, resourceSn).uniqueResult(),
				permission);
	}

	//搜索某个用户拥有读取权限的模块列表（用于登录，形成导航菜单的时候）
	public List<?> searchModules(int userId) {
		
		//定义临时变量
		Map<Integer, ACL> temp = new HashMap<Integer, ACL>();
		
		//按优先级从低到高查找用户拥有的角色,优先级高的覆盖优先级低的授权
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " +
					"where u.id = ? order by ur.orderNo desc";
		List<?> aclIds = getHibernateTemplate().find(hql, userId);
		
		//依次循环角色
		for (Iterator<?> iter = aclIds.iterator(); iter.hasNext();) {
			Integer rid = (Integer) iter.next();
			
			//根据角色获得角色拥有的授权列表
			List<?> acls = findRoleACLs(rid);
			
			//把授权放入临时变量
			for (Iterator<?> iterator = acls.iterator(); iterator.hasNext();) {
				ACL acl = (ACL) iterator.next();
				temp.put(acl.getResourceSn(), acl);
			}
		}
		
		//查找直接授予用户的授权列表
		List<?> acls = findUserACLs(userId);
		for (Iterator<?> iter = acls.iterator(); iter.hasNext();) {
			ACL acl = (ACL) iter.next();
			temp.put(acl.getResourceSn(), acl);
		}
		
		//现在已获得用户拥有的所有授权（包括直接授予用户自身以及其包含的角色的授权）
		List delResources = new ArrayList();
		Set entries = temp.entrySet();
		for (Iterator iter = entries.iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			ACL acl = (ACL)entry.getValue();
			
			//如果没有读取权限，则需要在临时变量中删除这个授权
			if(acl.getPermission(Permission.READ) == ACL.ACL_NO){
				delResources.add(entry.getKey());
			}
		}
		//在临时变量中删除这些需要删除的授权
		for (Iterator iter = delResources.iterator(); iter.hasNext();) {
			Object key = (Object) iter.next();
			temp.remove(key);
		}
		
		//如果授权列表是空的，则返回0长度的集合
		if(temp.isEmpty()){
			return new ArrayList();
		}
		
		//现在已获得用户拥有读取权限的授权
		String searchModules = "select m from Module m where m.id in (:ids)";
		return getSession().createQuery(searchModules)
				.setParameterList("ids", temp.keySet())
				.list();
	}
	
	public List searchAclRecord(String principalType, int principalSn) {

		String sql = "select resourceSn,aclState&1,aclState&2," +
				"aclState&4,aclState&8,aclTriState " +
				"from T_ACL where principalType = '"+principalType + 
				"' and principalSn = "+principalSn;
		
		return getSession().createSQLQuery(sql).list();
	}

	//根据主体类型、主体标识和资源标识查找ACL实例
	private ACL findACL(String principalType, int principalSn,
			int resourceSn){
		return (ACL)getSession().createQuery(
				"select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalSn = ? and acl.resourceSn = ?")
				.setParameter(0, principalType)
				.setParameter(1, principalSn)
				.setParameter(2, resourceSn)
				.uniqueResult();
	}
	
	//根据角色查找角色的授权列表，返回列表的元素是：ACL实例
	private List findRoleACLs(int roleId){
		String hql = "select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalSn = ? ";
		return getHibernateTemplate().find(hql,new Object[]{ACL.TYPE_ROLE,roleId}); 
	}
	
	//根据用户查找直接授予用户的授权列表（注意：如果直接授予用户的授权是继承的话，则不应该包含在这个列表中），返回的列表元素是：ACL实例
	private List findUserACLs(int userId){
		String hql = "select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalSn = ? and acl.aclTriState = 0";		
		return getHibernateTemplate().find(hql, new Object[]{ACL.TYPE_USER,userId});
	}

}
