package youth.hong;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class Test {
	@Resource(name="userService")
	UserServiceDao userService;
	
	//private ClassPathXmlApplicationContext applicationContext;
	@org.junit.Test
	public void test() {
		//applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		//UserServiceDao userService = (UserServiceDao)applicationContext.getBean("userService");
		User user = new User();
		user.setPassword("nn");
		user.setUsername("mm");
		boolean t = userService.isExists(user);
		Assert.assertEquals(false, t);//如果不相等就表示失败！
		//Assert.fail("error");
		userService.save(user);
	}
}
