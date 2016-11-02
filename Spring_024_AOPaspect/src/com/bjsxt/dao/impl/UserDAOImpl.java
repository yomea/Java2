package com.bjsxt.dao.impl;

import org.springframework.stereotype.Repository;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Repository("u")
public class UserDAOImpl implements UserDAO {

	public void save(User user) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		System.out.println("user saved!");
	}

}
