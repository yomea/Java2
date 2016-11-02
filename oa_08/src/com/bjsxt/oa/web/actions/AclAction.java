package com.bjsxt.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.SystemContext;
import com.bjsxt.oa.managers.ModuleManager;
import com.bjsxt.oa.managers.RoleManager;
import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.managers.UserManager;
import com.bjsxt.oa.model.ACL;
import com.bjsxt.oa.web.forms.AclActionForm;

public class AclAction extends BaseAction {

	private RoleManager roleManager;
	private UserManager userManager;
	private ModuleManager moduleManager;
	
	//打开ACL授权界面
	//接收的参数：principalType,principalSn
	//输出的参数：模块列表、角色或用户对象
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AclActionForm aaf = (AclActionForm)form;
		
		//如果主体类型是角色
		if(ACL.TYPE_ROLE.equals( aaf.getPrincipalType())){
			request.setAttribute("role", roleManager.findRole(aaf.getPrincipalSn()));
		}else if(ACL.TYPE_USER.equals(aaf.getPrincipalType())){
			request.setAttribute("user", userManager.findUser(aaf.getPrincipalSn()));
		}else{
			throw new SystemException("无效的主体类型！！！！");
		}
		
		//获得所有顶级模块列表
		SystemContext.setOffset(0);
		SystemContext.setPagesize(Integer.MAX_VALUE);
		PagerModel pm = moduleManager.searchModules(0);
		request.setAttribute("modules", pm.getDatas());
		
		return mapping.findForward("index");
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}
	
}
