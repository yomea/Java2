package com.bjsxt.service;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;



public class UserService implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware, BeanClassLoaderAware{
	private UserDAO userDAO;
	private UserDAO userDAO2;
	private String name;
	private ApplicationContext applicationContext;
	
	public void init() {
		System.out.println("init");
	}
	
	public void destroy() {
		System.out.println("destory");
	}

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

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		/*System.out.println(arg0.getBean("userDAO"));*/
		this.applicationContext = arg0;
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println(arg0);
	}

	@Override
	public void setBeanClassLoader(ClassLoader arg0) {
		System.out.println(arg0.getClass().getName());
	}
	
	public void resource() {
		Resource resource = applicationContext.getResource("com/bjsxt/service/test.txt");
		//Resource resource = applicationContext.getResource("classpath:com/bjsxt/service/test.txt");
		//Resource resource = applicationContext.getResource("file:" + System.getProperty("user.dir") + "/src/com/bjsxt/service/test.txt");
		//Resource resource = applicationContext.getResource("url:http:www.baidu.com");
		System.out.println(resource.getFilename());
		try {
			System.out.println(resource.contentLength());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
