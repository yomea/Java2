package com.bjsxt.oa.web.actions;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.io.SAXReader;

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
	
	//�򿪲鿴����ͼƬ�Ľ���
	public ActionForward openViewImage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("flow_image");
	}
	
	//�鿴ͼƬ����������flow_image.jsp�е�<img src="workflow.do?method=viewImage">���������
	public ActionForward viewImage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		
		response.setContentType("image/jpeg");
		response.getOutputStream().write(wf.getProcessImage());
		
		return null;
	}
	
	//�鿴���̶����ļ�������
	public ActionForward viewFlowDef(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		byte[] defs = wf.getProcessDefinition();
		
		//��byte[]ת��Ϊ�ַ���
		//String defString = new String(defs,"UTF-8");
		
		//Ϊ�˱���Ӳ����encoding����������dom4j��������������ת��xml�ļ�
		String defString = new SAXReader().read(
				new ByteArrayInputStream(defs)
			).asXML();
		
		request.setAttribute("def", defString);
		
		return mapping.findForward("flow_def");
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}

}
