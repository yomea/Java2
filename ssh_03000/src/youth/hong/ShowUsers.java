package youth.hong;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowUsers extends ActionSupport {
	private List<User> users = null;
	
	private UserServiceDao userService;

	public UserServiceDao getUserService() {
		return userService;
	}

	public void setUserService(UserServiceDao userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String execute() throws Exception {
		users = userService.getUsers();
		System.out.println(users.size());
		return SUCCESS;
	
	}
	
	
	
}
