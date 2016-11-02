package com.bjsxt.service;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;



public class UserService {
	private UserDAO userDAO;
	private UserDAO userDAO2;
	private String name;
	
	

	public UserService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	public UserDAO getUserDAO2() {
		return userDAO2;
	}
	public void setUserDAO2(UserDAO userDAO2) {
		this.userDAO2 = userDAO2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void add(User user) {
		userDAO.save(user);
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	//setter方式注入
	public void setUserDAO(UserDAO userDAO) {
		System.out.println("我被调用了!");
		this.userDAO = userDAO;
	}
}
