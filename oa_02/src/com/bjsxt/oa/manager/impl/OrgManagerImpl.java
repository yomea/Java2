package com.bjsxt.oa.manager.impl;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.manager.OrgManager;
import com.bjsxt.oa.manager.SystemException;
import com.bjsxt.oa.model.Orgnization;

public class OrgManagerImpl extends AbstractManager implements OrgManager {

	public void addOrg(Orgnization org, int parentId) {
		if(parentId != 0){
			org.setParent(
					(Orgnization)getHibernateTemplate()
					.load(Orgnization.class, parentId)
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
		
		Orgnization org = (Orgnization)getHibernateTemplate().load(Orgnization.class, orgId);
		
		//���ж��Ƿ�����ӻ�������������ӻ�����������ɾ��
		if(org.getChildren().size() > 0){
			throw new SystemException("�����ӻ�����������ɾ��","exception.org.del",org.getId());
		}
		
		getHibernateTemplate().delete(
			org
		);
	}

	public Orgnization findOrg(int orgId) {

		return (Orgnization)getHibernateTemplate().load(Orgnization.class, orgId);
	}

	public PagerModel findOrgs(int parentId) {
		
		//���parentId��0������Ҷ��������б�
		if(parentId == 0){
			return searchPaginated("from Orgnization o where o.parent is null");
		}
		return searchPaginated("from Orgnization o where o.parent.id = ?", parentId);
	} 

	public void updateOrg(Orgnization org, int parentId) {
		if(parentId != 0){
			org.setParent(
					(Orgnization)getHibernateTemplate()
					.load(Orgnization.class, parentId)
				);
		}
		
		getHibernateTemplate().update(org);
	}

}
