package youth.hong;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TeacherAction2 extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
	
	
	

	public String add() {
		request.put("r1", "r1");
		session.put("s1", "s1");
		application.put("a1", "a1");
		return SUCCESS;
	}





	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
		
	}





	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}





	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}
	
	
	

}
