package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	
	private String username;
	private String password;
	
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
