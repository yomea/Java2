package com.bjsxt.service;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;



public class UserService {
	private UserDAO userDAO;  
	private int id;
	private String name;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println(id);
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println(name);
		this.name = name;
	}
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
	//setter方式注入
	public void setUserDAO(UserDAO userDAO) {
		System.out.println("我被调用了!");
		this.userDAO = userDAO;
	}
}
