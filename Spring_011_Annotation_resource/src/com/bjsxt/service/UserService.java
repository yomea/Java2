package com.bjsxt.service;
import javax.annotation.Resource;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;



public class UserService {
	private UserDAO userDAO;
	private String name;
	
	public void init() {
		System.out.println("init");
	}
	
	public void destroy() {
		System.out.println("destory");
	}
	//�����޲ι�����
	public UserService() {}

	public UserService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
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
	
	@Resource(name="u2")
	public void setUserDAO(UserDAO userDAO) {
		System.out.println("�ұ�������!");
		this.userDAO = userDAO;
	}
}
