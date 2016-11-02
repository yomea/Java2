package com.bjsxt.dao.impl;

import com.bjsxt.dao.SuperDao;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

//hibernateTemplate也可以使用xml的bean标签
//public class UserDAOImpl extends HibernateTemplate implements UserDAO {
public class UserDAOImpl extends SuperDao implements UserDAO {
	//private DataSource dataSource;
	
	//private SessionFactory sessionFactory;
	
	
	/*public DataSource getDataSource() {
		return dataSource;
	}


	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/



	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/


	public void save(User user) {
		System.out.println(this.getHibernateTemplate());
		this.getHibernateTemplate().saveOrUpdate(user);//service的add方法应有transaction,因为hibernateTemplate的事务是read-only的，所以在外边应当定义transaction并且他的propagation是required。
		System.out.println(this.getHibernateTemplate());
		//User u =this.getHibernateTemplate().load(User.class, 1);
		//u.setName("hello Kitty!");
		//System.out.println(u.getName() + " is saved!");
		//session.close();
	}

}
