package com.bjsxt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
	//定义无参构造器
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
	
	@Autowired
	public void setUserDAO(@Qualifier("userDAO1") UserDAO userDAO) {
		System.out.println("我被调用了!");
		this.userDAO = userDAO;
	}
}
