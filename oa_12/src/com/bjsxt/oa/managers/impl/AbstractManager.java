package com.bjsxt.oa.managers.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.SystemContext;
import com.bjsxt.oa.managers.SystemException;

public class AbstractManager extends HibernateDaoSupport {
	
	public PagerModel searchPaginated(String hql){
		return searchPaginated(hql,null,SystemContext.getOffset(),SystemContext.getPagesize());
	}
	
	public PagerModel searchPaginated(String hql,Object param){
		return searchPaginated(hql,new Object[]{param},SystemContext.getOffset(),SystemContext.getPagesize());
	}
	
	public PagerModel searchPaginated(String hql,Object[] params){
		return searchPaginated(hql,params,SystemContext.getOffset(),SystemContext.getPagesize());
	}
	
	public PagerModel searchPaginated(String hql,int offset,int pagesize){
		return searchPaginated(hql,null,offset,pagesize);
	}
	 
	public PagerModel searchPaginated(String hql,Object obj,int offset,int pagesize){
		return searchPaginated(hql,new Object[]{obj},offset,pagesize);
	}
	
	/**
	 * ����HQL�����з�ҳ��ѯ
	 * @param hql HQL���
	 * @param params HQL�����Ķ������ֵ
	 * @param offset �ӵڼ�����¼��ʼ��ѯ
	 * @param pagesize ÿҳ��ʾ������
	 * @return
	 */
	public PagerModel searchPaginated(String hql,Object[] params,int offset,int pagesize){
		
		//��ȡ��¼����
		String countHql = getCountQuery(hql);
		Query query = getSession().createQuery(countHql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		int total = ((Long)query.uniqueResult()).intValue();
		
		//��ȡ��ǰҳ�Ľ����
		query = getSession().createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		
		query.setFirstResult(offset);
		query.setMaxResults(pagesize);
		List<?> datas = query.list();
		
		PagerModel pm = new PagerModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		return pm;
	}
	
	/**
	 * ����HQL��䣬��ò����ܼ�¼����HQL���
	 * �磺
	 * select ... from Orgnization o where o.parent is null
	 * ����ת�������Եõ���
	 * select count(*) from Orgnization o where o.parent is null
	 * @param hql
	 * @return
	 */
	private String getCountQuery(String hql){
		int index = hql.indexOf("from");
		if(index != -1){
			return "select count(*) " + hql.substring(index);
		}
		
		throw new SystemException("��Ч��HQL��ѯ��䣡");
	}
}
