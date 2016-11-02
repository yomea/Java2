package com.bjsxt.service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.model.User;


public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		
		UserService service = (UserService)applicationContext.getBean("userService");
		
		UserService service2 = (UserService)applicationContext.getBean("userService");
		
		System.out.println(service == service2);
		
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.add(u);
	}

}
