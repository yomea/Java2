package youth.hong.service.impl;

import org.junit.Test;

import youth.hong.entity.User;
import youth.hong.message.Message;
import youth.hong.service.IUserService;

public class UserImplTest {
	@Test
	
	public void getUserTest() {
		
		IUserService service = new UserServiceImpl();
		User user = new User("admin","admin");
		Message<User> message = service.getUser(user);
		System.out.println(message.isSuccess());
		
	}
}
