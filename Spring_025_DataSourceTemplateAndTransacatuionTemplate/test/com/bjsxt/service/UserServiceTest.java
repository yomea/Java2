package com.bjsxt.service;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.model.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:beans.xml")定义这个后，这个类需要放在classpath下
public class UserServiceTest {
	/*@Autowired
	private UserService userService;*/

	@Test
	public void testAdd() throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	
		
		UserService service = (UserService)applicationContext.getBean("userService");
	
	UserService service2 = (UserService)applicationContext.getBean("userService");
		
	System.out.println(service == service2);
		
		User u = new User();
		u.setName("zhangsan");
		System.out.println(service.getClass());
		service.add(u);
	
		applicationContext.destroy();
	}

}
