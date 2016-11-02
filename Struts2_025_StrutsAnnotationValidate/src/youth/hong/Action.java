package youth.hong;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	
	private String username;
	private String password;
	private int age;
	
	public String getUsername() {
		return username;
	}
	@RequiredStringValidator(type=ValidatorType.FIELD,key="pass.username",message="")
	@RegexFieldValidator(type=ValidatorType.FIELD,regexExpression="\\w{4,25}",message="hah")
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@RequiredStringValidator(type=ValidatorType.FIELD,key="pass.username",message="")
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	@IntRangeFieldValidator(min="1",max="10",message="1~~~10")
	public void setAge(int age) {
		this.age = age;
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
