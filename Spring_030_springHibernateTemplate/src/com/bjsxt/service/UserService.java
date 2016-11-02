package com.bjsxt.service;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Component
public class UserService {
	private UserDAO userDAO;
	private String name;
	//private TransactionTemplate transactionTemplate;
	
	
	
	/*public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
*/
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
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(User user) {
		/*transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				
				userDAO.save(user);
				
			}
		});*/
		userDAO.save(user);
		//throw new RuntimeException();
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Inject
	public void setUserDAO(@Named("u") UserDAO userDAO) {
		System.out.println("我被调用了!");
		this.userDAO = userDAO;
	}
}
