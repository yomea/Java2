package youth.hong;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TeacherAction extends ActionSupport{
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
	
	
	@SuppressWarnings("unchecked")
	public TeacherAction() {
		this.request = (Map<String,Object>)ActionContext.getContext().get("request");
		this.session = (Map<String,Object>)ActionContext.getContext().getSession();
		this.application = (Map<String,Object>)ActionContext.getContext().getApplication();
	}

	

	public String add() {
		request.put("r1", "r1");
		session.put("s1", "s1");
		application.put("a1", "a1");
		return SUCCESS;
	}
	
	
	

}
