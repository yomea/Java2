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
	
	//打开查看流程图片的界面
	public ActionForward openViewImage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("flow_image");
	}
	
	//查看图片（此请求由flow_image.jsp中的<img src="workflow.do?method=viewImage">发起的请求）
	public ActionForward viewImage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		
		response.setContentType("image/jpeg");
		response.getOutputStream().write(wf.getProcessImage());
		
		return null;
	}
	
	//查看流程定义文件的内容
	public ActionForward viewFlowDef(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		byte[] defs = wf.getProcessDefinition();
		
		//将byte[]转换为字符串
		//String defString = new String(defs,"UTF-8");
		
		//为了避免硬编码encoding，可以利用dom4j工具来帮助我们转换xml文件
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
