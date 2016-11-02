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
	 * �����̹��������棬�г���ǰ���е�����
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("workflows", workflowManager.searchAllWorkflows());
		
		return mapping.findForward("index");
	}
	
	//������̶���
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		//TODO ��һЩ�жϣ��ж��ϴ����ļ��Ƿ�Ϊ�գ������Ƿ��׳��쳣���ȵȣ���
		
		//��������
		workflowManager.deployProcessDefinition(
				waf.getProcessDefinition().getFileData(), 
				waf.getProcessImage().getFileData()
		);
		
		return mapping.findForward("add_success");
	}
	
	//ɾ�����̶���
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		workflowManager.delWorkflow(waf.getId());
		
		return mapping.findForward("pub_del_success");
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}
	
}
