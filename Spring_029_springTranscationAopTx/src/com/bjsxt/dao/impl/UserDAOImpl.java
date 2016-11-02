package com.bjsxt.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Component("u")
public class UserDAOImpl implements UserDAO {
	//private DataSource dataSource;
	
	private SessionFactory sessionFactory;
	
	
	/*public DataSource getDataSource() {
		return dataSource;
	}


	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		System.out.println("user saved!");
		//session.close();
	}

}
