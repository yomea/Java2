package youth.hong;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CheckAction extends ActionSupport {
	
	private User user;
	
	private ClassPathXmlApplicationContext applicationContext;

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String execute() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserServiceDao userService = (UserServiceDao)applicationContext.getBean("userService");
		boolean t = userService.save(user);
		if(t) {
			this.addFieldError("usererror", "ÓÃ»§Ãû³åÍ»£¡");
			return INPUT;
		}
		return SUCCESS;
	}
	
	
}
