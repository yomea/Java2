package com.bjsxt.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.bjsxt.oa.SystemContext;
import com.bjsxt.oa.managers.OrgManager;
import com.bjsxt.oa.model.Organization;
import com.bjsxt.oa.web.forms.OrgActionForm;

public class OrgActionTree extends BaseAction {

	private OrgManager orgManager;
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrgActionForm oaf = (OrgActionForm)form;
		
		SystemContext.setOffset(0);
		SystemContext.setPagesize(Integer.MAX_VALUE);
		request.setAttribute("pm", orgManager.findOrgs(oaf.getParentId()));

		return mapping.findForward("index");
	}

	public ActionForward addInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		
		return mapping.findForward("add_input");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OrgActionForm oaf = (OrgActionForm)form;
		
		Organization org = new Organization();
		
		//将从页面上传递过来的值拷贝到Org对象
		BeanUtils.copyProperties(org, oaf);
		
		orgManager.addOrg(org, oaf.getParentId());
		
		request.setAttribute("org", org);
		
		return mapping.findForward("add_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OrgActionForm oaf = (OrgActionForm)form;
		
		orgManager.delOrg(oaf.getId());
		
		return mapping.findForward("pub_del_success");
	}

	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}
}
