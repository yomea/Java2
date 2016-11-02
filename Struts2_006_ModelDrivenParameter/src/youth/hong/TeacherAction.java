package youth.hong;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import youth.hong.user.User;

public class TeacherAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public String add() {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAge());
		return "test";
	}
	
	public String delete() {
		return "test";
	}
	
	public String test() {
		return "test";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
	
	
	
}
