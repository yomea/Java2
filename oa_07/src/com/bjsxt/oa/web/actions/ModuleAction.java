package com.bjsxt.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.oa.managers.ModuleManager;
import com.bjsxt.oa.model.Module;
import com.bjsxt.oa.web.forms.ModuleActionForm;

public class ModuleAction extends BaseAction {
	
	private ModuleManager moduleManager;
	
	/**
	 * �򿪻�������������
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModuleActionForm maf = (ModuleActionForm)form;
		
		request.setAttribute("pm", moduleManager.searchModules(maf.getParentId()));
		
		return mapping.findForward("index");
	}
	
	/**
	 * �򿪻�������¼�����
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

	//���ӻ�����Ϣ
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModuleActionForm maf = (ModuleActionForm)form;
		
		Module module = new Module();
		
		BeanUtils.copyProperties(module, maf);
		
		moduleManager.addModule(module, maf.getParentId());
		
		return mapping.findForward("pub_add_success");
	}
	
	//ɾ��������Ϣ
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModuleActionForm maf = (ModuleActionForm)form;
		
		moduleManager.delModule(maf.getId());
		
		return mapping.findForward("pub_del_success");
	}

	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}
}