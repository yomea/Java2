package youth.hong;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class Check extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	
	/*private String username;
	
	private String password;
	
	
	
	//private ClassPathXmlApplicationContext applicationContext;
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

*/

	private UserServiceDao userService;

	public UserServiceDao getUserService() {
		return userService;
	}


	public void setUserService(UserServiceDao userService) {
		this.userService = userService;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String execute() throws Exception {
//		applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		UserServiceDao userService = (UserServiceDao)applicationContext.getBean("userService");
		System.out.println(userService);
		System.out.println(user);
		boolean t = userService.save(user);
		if(t) {
			this.addFieldError("usererror", "ÓÃ»§Ãû³åÍ»£¡");
			return INPUT;
		}
		return SUCCESS;
	}



	@Override
	public User getModel() {
		
		return user;
	}
	
	
}
