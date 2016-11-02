package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

public class ActionTest2 extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "test";
	}
	
	public String add() {
		return SUCCESS;
	}
	
}
