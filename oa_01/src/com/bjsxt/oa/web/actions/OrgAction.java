package com.bjsxt.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.bjsxt.oa.manager.OrgManager;
import com.bjsxt.oa.model.Orgnization;
import com.bjsxt.oa.web.forms.OrgActionForm;

public class OrgAction extends DispatchAction {

	private OrgManager orgManager;
	
	/**
	 * 打开机构管理主界面
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OrgActionForm oaf = (OrgActionForm)form;
		
		int offset = 0;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception ignore) {
		}
		
		int pagesize = 10;
		
		request.setAttribute("pm",
			orgManager.findOrgs(oaf.getParentId(),offset,pagesize)
		);
		
		//
		int ppid = 0;
		if(oaf.getParentId() != 0){
			Orgnization org = orgManager.findOrg(oaf.getParentId());
			Orgnization parent = org.getParent();
			if(parent != null){
				ppid = parent.getId();
			}
		}
		
		request.setAttribute("ppid", ppid);
		
		return mapping.findForward("index");
	}
	
	/**
	 * 打开机构管理录入界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("add_input");
	}

	//添加机构信息
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OrgActionForm oaf = (OrgActionForm)form;
		int parentId = oaf.getParentId();
		
		Orgnization org = new Orgnization();
		
		BeanUtils.copyProperties(org, oaf);
		
		orgManager.addOrg(org, parentId);
		
		return mapping.findForward("pub_add_success");
	}
	
	//删除机构信息
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OrgActionForm oaf = (OrgActionForm)form;
		
		int id = oaf.getId();
//		try{
		orgManager.delOrg(id);
//		}catch(Exception e){
//			ActionMessages msgs = new ActionMessages();
//			
//			ActionMessage msg = new ActionMessage("errors.detail",e.getMessage()); 
//			
//			msgs.add("detail", msg);
//			
//			this.saveErrors(request, msgs);
//			
//			return mapping.findForward("exception");
//		}
		return mapping.findForward("pub_del_success");
	}

	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}
	
}
