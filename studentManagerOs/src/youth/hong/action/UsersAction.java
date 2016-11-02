package youth.hong.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import youth.hong.model.Users;
import youth.hong.service.IUsersService;
import youth.hong.service.UsersServiceImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	private static final long serialVersionUID = 2L;
	
	private Users user = new Users();
	
	private IUsersService service = new UsersServiceImpl();
	
	public String login() {
		boolean isLogin = service.isLogin(user);
		if(isLogin) {
			session.setAttribute("loginUserName", user.getUsername());
			return SUCCESS;
		}
		else {
			this.addFieldError("errorLogin", "用户名或者密码错误！");
			return INPUT;
		}
	}
	
	@SkipValidation
	public String logout() {
		if(session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
			
		}
		return INPUT;
	}

	@Override
	public Users getModel() {
		return user;
	}
	
	

}
