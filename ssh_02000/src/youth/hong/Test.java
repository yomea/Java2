package youth.hong;

import org.junit.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	private ClassPathXmlApplicationContext applicationContext;
	@org.junit.Test
	public void test() {
		applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserServiceDao userService = (UserServiceDao)applicationContext.getBean("userService");
		User user = new User();
		user.setPassword("a");
		user.setUsername("s");
		boolean t = userService.isExists(user);
		Assert.assertEquals(true, t);//与期望相等，表示成功
		Assert.fail("error");//输出错误信息
		userService.save(user);
	}
}
