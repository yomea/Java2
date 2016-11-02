package com.bjsxt.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.bjsxt.oa.managers.UserManager;
import com.bjsxt.oa.model.User;
import com.bjsxt.oa.web.forms.UserActionForm;

public class LoginAction extends DispatchAction {

	private UserManager userManager;
	
	//Ö´ÐÐµÇÂ¼²Ù×÷
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = userManager.login(uaf.getUsername(), uaf.getPassword());
		
		request.getSession().setAttribute("login", user);
		
		return mapping.findForward("back_index");
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
