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
		
		//���ж��Ƿ�����ӻ�������������ӻ�����������ɾ��
		if(org.getChildren().size() > 0){
			throw new SystemException("�����ӻ�����������ɾ��","exception.org.del",org.getId());
		}
		
		getHibernateTemplate().delete(
			org
		);
	}

	public Organization findOrg(int orgId) {

		return (Organization)getHibernateTemplate().load(Organization.class, orgId);
	}

	public PagerModel findOrgs(int parentId) {
		
		//���parentId��0������Ҷ��������б�
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
