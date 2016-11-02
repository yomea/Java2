package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport{
	private String name;
	
	public String add() {
		if(name == null || !"admin".equals(name)) {
			this.addFieldError("name", "name is error");
			this.addFieldError("name", "name too long");
			this.addFieldError("wrning", "Input correct name");
			return "error";
		}
		return SUCCESS;
	}
	
	public String delete() {
		return "test";
	}
	
	public String test() {
		return "test";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
		
	}
	
	
	

	
}
