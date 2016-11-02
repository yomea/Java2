package youth.hong;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport implements SessionAware{
	private String username;
	private String password;
	private Map<String, Object> session;
	@Override
	public String execute() throws Exception {
		if(username != null && password != null && username.equals("admin") && password.equals("admin")) {
			
			session.put("username", username);
			return SUCCESS;
		} else {
			return "login";
		}
		
	}
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
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	
	
}
