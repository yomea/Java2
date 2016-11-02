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

	//��Ȩ����
	public void addOrUpdatePermission(String principalType, int principalSn,
			int resourceSn, int permission, boolean yes) {
		
		//���������ʶ����Դ��ʶ����ACLʵ��
		ACL acl = findACL(principalType, principalSn, resourceSn);
		
		//�������ACLʵ�������������Ȩ
		if(acl != null){
			acl.setPermission(permission, yes);
			getHibernateTemplate().update(acl);
			return;
		}
		
		//������ACLʵ�����򴴽�ACLʵ��
		acl = new ACL();
		acl.setPrincipalType(principalType);
		acl.setPrincipalSn(principalSn);
		acl.setResourceSn(resourceSn);
		acl.setPermission(permission, yes);
		getHibernateTemplate().save(acl);
	}

	//�����û�ĳ����Դ��Ȩ�ļ̳�����
	public void addOrUpdateUserExtends(int userId, int resourceSn, boolean yes) {
		
		//���������ʶ����Դ��ʶ����ACLʵ��
		ACL acl = findACL(ACL.TYPE_USER, userId, resourceSn); 
		
		//�������ACLʵ�������������Ȩ
		if(acl != null){
			acl.setExtends(yes);
			getHibernateTemplate().update(acl);
			return;
		}
		
		//������ACLʵ�����򴴽�ACLʵ��
		acl = new ACL();
		acl.setPrincipalType(ACL.TYPE_USER);
		acl.setPrincipalSn(userId);
		acl.setResourceSn(resourceSn);
		acl.setExtends(yes);
		getHibernateTemplate().save(acl);
	}

	//ɾ����Ȩ
	public void delPermission(String principalType, int principalSn,
			int resourceSn) {
		getHibernateTemplate().delete(findACL(principalType, principalSn, resourceSn));
	}

	//��ʱ��֤
	public boolean hasPermission(int userId, int resourceSn, int permission) {
		
		//����ֱ�������û�����Ȩ
		ACL acl = findACL(ACL.TYPE_USER, userId, resourceSn);
		
		if(acl != null){
			int yesOrNo = acl.getPermission(permission);
			
			//�����ȷ������Ȩ
			if(yesOrNo != ACL.ACL_NEUTRAL){
				return yesOrNo == ACL.ACL_YES ? true : false;
			}
		}
		
		//���������û��Ľ�ɫ��Ȩ
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " +
				"where u.id = ? order by ur.orderNo";
		List<?> aclIds = getHibernateTemplate().find(hql, userId);
		
		//���ս�ɫ���ȼ����β�������Ȩ
		for (Iterator<?> iter = aclIds.iterator(); iter.hasNext();) {
			Integer rid = (Integer) iter.next();
			acl = findACL(ACL.TYPE_ROLE, rid, resourceSn);
			
			//һ��������Ȩ�����ɷ��ؽ��
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

	//����ĳ���û�ӵ�ж�ȡȨ�޵�ģ���б����ڵ�¼���γɵ����˵���ʱ��
	public List<?> searchModules(int userId) {
		
		//������ʱ����
		Map<Integer, ACL> temp = new HashMap<Integer, ACL>();
		
		//�����ȼ��ӵ͵��߲����û�ӵ�еĽ�ɫ,���ȼ��ߵĸ������ȼ��͵���Ȩ
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " +
					"where u.id = ? order by ur.orderNo desc";
		List<?> aclIds = getHibernateTemplate().find(hql, userId);
		
		//����ѭ����ɫ
		for (Iterator<?> iter = aclIds.iterator(); iter.hasNext();) {
			Integer rid = (Integer) iter.next();
			
			//���ݽ�ɫ��ý�ɫӵ�е���Ȩ�б�
			List<?> acls = findRoleACLs(rid);
			
			//����Ȩ������ʱ����
			for (Iterator<?> iterator = acls.iterator(); iterator.hasNext();) {
				ACL acl = (ACL) iterator.next();
				temp.put(acl.getResourceSn(), acl);
			}
		}
		
		//����ֱ�������û�����Ȩ�б�
		List<?> acls = findUserACLs(userId);
		for (Iterator<?> iter = acls.iterator(); iter.hasNext();) {
			ACL acl = (ACL) iter.next();
			temp.put(acl.getResourceSn(), acl);
		}
		
		//�����ѻ���û�ӵ�е�������Ȩ������ֱ�������û������Լ�������Ľ�ɫ����Ȩ��
		List delResources = new ArrayList();
		Set entries = temp.entrySet();
		for (Iterator iter = entries.iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			ACL acl = (ACL)entry.getValue();
			
			//���û�ж�ȡȨ�ޣ�����Ҫ����ʱ������ɾ�������Ȩ
			if(acl.getPermission(Permission.READ) == ACL.ACL_NO){
				delResources.add(entry.getKey());
			}
		}
		//����ʱ������ɾ����Щ��Ҫɾ������Ȩ
		for (Iterator iter = delResources.iterator(); iter.hasNext();) {
			Object key = (Object) iter.next();
			temp.remove(key);
		}
		
		//�����Ȩ�б��ǿյģ��򷵻�0���ȵļ���
		if(temp.isEmpty()){
			return new ArrayList();
		}
		
		//�����ѻ���û�ӵ�ж�ȡȨ�޵���Ȩ
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

	//�����������͡������ʶ����Դ��ʶ����ACLʵ��
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
	
	//���ݽ�ɫ���ҽ�ɫ����Ȩ�б������б��Ԫ���ǣ�ACLʵ��
	private List findRoleACLs(int roleId){
		String hql = "select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalSn = ? ";
		return getHibernateTemplate().find(hql,new Object[]{ACL.TYPE_ROLE,roleId}); 
	}
	
	//�����û�����ֱ�������û�����Ȩ�б�ע�⣺���ֱ�������û�����Ȩ�Ǽ̳еĻ�����Ӧ�ð���������б��У������ص��б�Ԫ���ǣ�ACLʵ��
	private List findUserACLs(int userId){
		String hql = "select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalSn = ? and acl.aclTriState = 0";		
		return getHibernateTemplate().find(hql, new Object[]{ACL.TYPE_USER,userId});
	}

}
