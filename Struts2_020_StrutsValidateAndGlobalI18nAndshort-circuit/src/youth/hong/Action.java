package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	
	private String username;
	private String password;
	private int age;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	//�ڱ��ύ�󣬻��ȵ�������������������this.addFieldError("username", "username error");
	//�ͻ��Զ�����input��
	/*@Override
	public void validate() {
		if(username == null || username.trim().equals("")) {
			this.addFieldError("username", "username error");
		}
		if(password == null || "".equals(password.trim())) {
			this.addFieldError("password", "passwordNotCorrent");
		}
	}*/
	
}
