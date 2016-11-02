package com.bjsxt.oa.managers;

import java.util.List;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Organization;

public interface OrgManager {
	
	/**
	 * ��ӻ�����Ϣ
	 * @param org
	 * @param parentId
	 */
	public void addOrg(Organization org,int parentId);
	
	public void delOrg(int orgId);
	
	public void updateOrg(Organization org,int parentId);
	
	public Organization findOrg(int orgId);
	
	/**
	 * ���һ����б�
	 * ���parentIdΪ0������Ҷ��������б�
	 * .....
	 * @param parentId
	 * @return
	 */
	public PagerModel findOrgs(int parentId);
}
