package com.bjsxt.oa.managers;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Role;

public interface RoleManager {
	
	/**
	 * 添加角色
	 * @param role
	 */
	public void addRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId
	 */
	public void delRole(int roleId);
	
	public void updateRole(Role role);
	
	public Role findRole(int roleId);

	/**
	 * 分页查询角色的信息
	 * @return
	 */
	public PagerModel searchRoles();
}
