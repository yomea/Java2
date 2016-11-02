package com.bjsxt.dao.impl;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Repository("u")
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

	//@Resource
	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		System.out.println("user saved!");
	}

}
