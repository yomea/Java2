package youth.hong.service;

import youth.hong.entity.Role;
import youth.hong.pager.Pager;

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
	public Pager<Role> searchRoles();
}
