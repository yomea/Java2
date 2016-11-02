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
		Assert.assertEquals(true, t);//�����Ⱦͱ�ʾʧ�ܣ�
		Assert.fail("error");
		userService.save(user);
	}
}
