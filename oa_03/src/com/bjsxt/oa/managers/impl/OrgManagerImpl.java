package com.bjsxt.oa.managers.impl;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.managers.OrgManager;
import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.model.Organization;

public class OrgManagerImpl extends AbstractManager implements OrgManager {

	public void addOrg(Organization org, int parentId) {
		if(parentId != 0){
			org.setParent(
					(Organization)getHibernateTemplate()
					.load(Organization.class, parentId)
				);
		}
		
		getHibernateTemplate().save(org);
		
		org.setSn(
			org.getParent() == null ? 
					(""+org.getId()) : 
						(org.getParent().getSn()+"_"+org.getId())
		);
		
		getHibernateTemplate().update(org);
		
	}

	public void delOrg(int orgId) {
		
		Organization org = (Organization)getHibernateTemplate().load(Organization.class, orgId);
		
		//先判断是否存在子机构，如果存在子机构，则不允许删除
		if(org.getChildren().size() > 0){
			throw new SystemException("存在子机构，不允许删除","exception.org.del",org.getId());
		}
		
		getHibernateTemplate().delete(
			org
		);
	}

	public Organization findOrg(int orgId) {

		return (Organization)getHibernateTemplate().load(Organization.class, orgId);
	}

	public PagerModel findOrgs(int parentId) {
		
		//如果parentId＝0，则查找顶级机构列表
		if(parentId == 0){
			return searchPaginated("from Organization o where o.parent is null");
		}
		return searchPaginated("from Organization o where o.parent.id = ?", parentId);
	} 

	public void updateOrg(Organization org, int parentId) {
		if(parentId != 0){
			org.setParent(
					(Organization)getHibernateTemplate()
					.load(Organization.class, parentId)
				);
		}
		
		getHibernateTemplate().update(org);
	}

}
