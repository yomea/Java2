package youth.hong.service;

import youth.hong.entity.Role;
import youth.hong.pager.Pager;

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
	public Pager<Role> searchRoles();
}
