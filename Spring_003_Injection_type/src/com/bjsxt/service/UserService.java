package com.bjsxt.service;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;



public class UserService {
	private UserDAO userDAO;  

	public UserService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	public void add(User user) {
		userDAO.save(user);
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	//setter��ʽע��
	public void setUserDAO(UserDAO userDAO) {
		System.out.println("�ұ�������!");
		this.userDAO = userDAO;
	}
}
