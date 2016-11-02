package com.bjsxt.service;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bjsxt.beanFactory.BeanFactory;
import com.bjsxt.model.User;


public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactory.class);
		
		UserService service = (UserService)applicationContext.getBean(UserService.class);
		
		UserService service2 = (UserService)applicationContext.getBean(UserService.class);
		
		SessionFactory sessionFactory = applicationContext.getBean("sessionFactory", SessionFactory.class);
		System.out.println(sessionFactory.getClass());
		System.out.println(service == service2);
		
		User u = new User();
		u.setName("zhangsan");
		System.out.println(service.getClass());
		service.add(u);
		
		applicationContext.destroy();
	}

}
