package youth.hong.service.impl;

import java.util.List;

import youth.hong.entity.Role;
import youth.hong.entity.User;
import youth.hong.service.UserManager;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(User user, int personId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user, int personId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> searchUserRoles(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrUpdateUserRole(int userId, int roleId, int orderNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUserRole(int userId, int roleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
