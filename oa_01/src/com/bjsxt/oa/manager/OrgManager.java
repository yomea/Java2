package com.bjsxt.oa.manager;

import java.util.List;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Orgnization;

public interface OrgManager {
	
	/**
	 * 添加机构信息
	 * @param org
	 * @param parentId
	 */
	public void addOrg(Orgnization org,int parentId);
	
	public void delOrg(int orgId);
	
	public void updateOrg(Orgnization org,int parentId);
	
	public Orgnization findOrg(int orgId);
	
	/**
	 * 查找机构列表
	 * 如果parentId为0，则查找顶级机构列表
	 * .....
	 * @param parentId
	 * @return
	 */
	public PagerModel findOrgs(int parentId,int offset,int pagesize);
}
