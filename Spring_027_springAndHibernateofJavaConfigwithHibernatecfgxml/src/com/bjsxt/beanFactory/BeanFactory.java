package com.bjsxt.beanFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.service.UserService;

@Configuration
public class BeanFactory {
	@Bean(name="userDAO")
	public UserDAO userDAO() {
		return new UserDAOImpl();
	}
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		 LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();  
	        localSessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
	        System.out.println(localSessionFactoryBean.getObject());
	        return localSessionFactoryBean;  
	          
	}
	
}
