package com.bjsxt.oa.manager.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.manager.OrgManager;
import com.bjsxt.oa.manager.SystemException;
import com.bjsxt.oa.model.Orgnization;

public class OrgManagerImpl extends HibernateDaoSupport implements OrgManager {
 
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

	public PagerModel findOrgs(int parentId,int offset,int pagesize) {
		
		String selectCountHql = "select count(*) from Orgnization o where o.parent is null";
		
		if(parentId != 0){
			selectCountHql = "select count(*) from Orgnization o where o.parent.id = "+parentId;
		}

		//����ܼ�¼��
		int total = ((Long)getSession().createQuery(selectCountHql).uniqueResult()).intValue();
		
		String selectHql = "select o from Orgnization o where o.parent is null";
		if(parentId != 0){
			selectHql = "select o from Orgnization o where o.parent.id = "+parentId;
		}
		
		//ȡ�õ�ǰҳ������
		List datas = getSession().createQuery(selectHql)
							.setFirstResult(offset)
							.setMaxResults(pagesize)
							.list();
		
		PagerModel pm = new PagerModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		
		return pm;
		
//		//���parentId��0������Ҷ��������б�
//		if(parentId == 0){
//			return getHibernateTemplate().find("from Orgnization o where o.parent is null");
//		}
//		return getHibernateTemplate().find("from Orgnization o where o.parent.id = ?", parentId);
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
