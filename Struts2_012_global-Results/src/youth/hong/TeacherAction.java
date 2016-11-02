package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TeacherAction extends ActionSupport{
	private int type;

	public String add() {
		if(type == 1) {
			return SUCCESS;
		}
		return "main";
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	

}
