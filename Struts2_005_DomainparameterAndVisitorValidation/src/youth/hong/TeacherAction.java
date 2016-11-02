package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

import youth.hong.user.User;

public class TeacherAction extends ActionSupport {
	private User user;
	
	public String add() {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAge());
		return "test";
	}
	
	public String delete() {
		return "test";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
