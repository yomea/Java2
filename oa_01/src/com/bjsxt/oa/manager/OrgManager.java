package com.bjsxt.oa.manager;

import java.util.List;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Orgnization;

public interface OrgManager {
	
	/**
	 * ��ӻ�����Ϣ
	 * @param org
	 * @param parentId
	 */
	public void addOrg(Orgnization org,int parentId);
	
	public void delOrg(int orgId);
	
	public void updateOrg(Orgnization org,int parentId);
	
	public Orgnization findOrg(int orgId);
	
	/**
	 * ���һ����б�
	 * ���parentIdΪ0������Ҷ��������б�
	 * .....
	 * @param parentId
	 * @return
	 */
	public PagerModel findOrgs(int parentId,int offset,int pagesize);
}
