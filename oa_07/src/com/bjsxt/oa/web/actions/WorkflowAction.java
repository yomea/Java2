package com.bjsxt.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.oa.managers.WorkflowManager;
import com.bjsxt.oa.model.Workflow;
import com.bjsxt.oa.web.forms.WorkflowActionForm;

public class WorkflowAction extends BaseAction {

	private WorkflowManager workflowManager;
	
	/**
	 * 打开流程管理主界面，列出当前所有的流程
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("workflows", workflowManager.searchAllWorkflows());
		
		return mapping.findForward("index");
	}
	
	//添加流程定义
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		//TODO 做一些判断，判断上传的文件是否为空，决定是否抛出异常，等等！！
		
		//部署流程
		workflowManager.deployProcessDefinition(
				waf.getProcessDefinition().getFileData(), 
				waf.getProcessImage().getFileData()
		);
		
		return mapping.findForward("add_success");
	}
	
	//删除流程定义
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		workflowManager.delWorkflow(waf.getId());
		
		return mapping.findForward("pub_del_success");
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}
	
}
