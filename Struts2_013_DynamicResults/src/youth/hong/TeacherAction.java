package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TeacherAction extends ActionSupport{
	private int type;
	private String r;
	public String add() {
		if(type == 1) {
			r = "/getRequestSessionApplication.jsp";
		} else {
			
			r = "/main.jsp";
		}
		return SUCCESS;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}
	
	
	
	

}
