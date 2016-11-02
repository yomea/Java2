package youth.hong;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TeacherAction3 extends ActionSupport{
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	
	
	
	public TeacherAction3() {
		this.request = ServletActionContext.getRequest();
		this.session = request.getSession();
		this.application = session.getServletContext();
	}

	

	public String add() {
		request.setAttribute("r1", "r1");
		session.setAttribute("s1", "s1");
		application.setAttribute("a1", "a1");
		return SUCCESS;
	}
	
	
	

}
