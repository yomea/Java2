package com.bjsxt.oa.managers;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Role;

public interface RoleManager {
	
	/**
	 * ��ӽ�ɫ
	 * @param role
	 */
	public void addRole(Role role);
	
	/**
	 * ɾ����ɫ
	 * @param roleId
	 */
	public void delRole(int roleId);
	
	public void updateRole(Role role);
	
	public Role findRole(int roleId);

	/**
	 * ��ҳ��ѯ��ɫ����Ϣ
	 * @return
	 */
	public PagerModel searchRoles();
}
