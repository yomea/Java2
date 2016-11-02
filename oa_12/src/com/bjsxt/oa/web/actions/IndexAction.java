package com.bjsxt.oa.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.oa.managers.AclManager;
import com.bjsxt.oa.model.User;

public class IndexAction extends BaseAction {
	
	private AclManager aclManager;
	
	//��outlook����
	public ActionForward outlook(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��ȡ��ǰ��¼�û���������Ȩ
		User user = (User)request.getSession().getAttribute("login");
		List modules = aclManager.searchModules(user.getId());
		
		request.setAttribute("modules", modules);
		
		return mapping.findForward("outlook");
	}
	
	//��main����
	public ActionForward main(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		return mapping.findForward("main");
	}

	public void setAclManager(AclManager aclManager) {
		this.aclManager = aclManager;
	}
}
