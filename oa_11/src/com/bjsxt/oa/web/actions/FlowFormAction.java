package com.bjsxt.oa.web.actions;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.oa.managers.FormManager;
import com.bjsxt.oa.managers.WorkflowManager;
import com.bjsxt.oa.model.FieldItem;
import com.bjsxt.oa.model.FlowForm;
import com.bjsxt.oa.model.FormField;
import com.bjsxt.oa.model.Workflow;
import com.bjsxt.oa.web.forms.FlowFormActionForm;

public class FlowFormAction extends BaseAction {

	private FormManager formManager;
	private WorkflowManager workflowManager;
	
	//�����棬������̴򿪣�����������ϣ���ʾ���̱�����Ϣ
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FlowFormActionForm ffaf = (FlowFormActionForm)form;
		
		int workflowId = ffaf.getWorkflowId();
		
		Workflow workflow = workflowManager.findWorkflow(workflowId);
		FlowForm flowForm = formManager.findForm(workflowId);
		
		request.setAttribute("flowForm", flowForm);
		request.setAttribute("workflow", workflow);
		
		return mapping.findForward("index");
	}
	
	//������̱�
	public ActionForward addForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FlowFormActionForm ffaf = (FlowFormActionForm)form;
		
		FlowForm flowform = new FlowForm();
		flowform.setTemplate(ffaf.getTemplate());
		flowform.setId(ffaf.getId());
		formManager.addForm(flowform, ffaf.getWorkflowId());
		
		ActionForward forward = new ActionForward();
		forward.setPath("/flowform.do?workflowId="+ffaf.getWorkflowId());
		forward.setRedirect(true);
		return forward;
	}
	
	//�򿪽��棬�����������������ϣ���Ҫѡ���������ͺ�������ʽ
	public ActionForward formFieldInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FlowFormActionForm ffaf = (FlowFormActionForm)form;
		
		request.setAttribute("fieldtypes", formManager.searchFieldTypes());
		request.setAttribute("fieldinputs", formManager.searchFieldInputs());
		
		return mapping.findForward("formfield_input");
	}
	
	//��ӱ���
	public ActionForward addFormField(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FlowFormActionForm ffaf = (FlowFormActionForm)form;
		
		FormField field = new FormField();
		field.setId(ffaf.getId());
		field.setFieldLabel(ffaf.getFieldLabel());
		field.setFieldName(ffaf.getFieldName());
		
		formManager.addField(field, ffaf.getFormId(), ffaf.getFieldTypeId(), ffaf.getFieldInputId());
		
		return mapping.findForward("pub_add_success");
	}
	
	//ɾ������
	public ActionForward delField(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FlowFormActionForm ffaf = (FlowFormActionForm)form;
		
		formManager.delField(ffaf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	//��ĳ�����������Ŀ��������棩���г����е���Ŀ
	public ActionForward addItemInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FlowFormActionForm ffaf = (FlowFormActionForm)form;
		
		//���ȸ���ID��ֵ�����ر���
		FormField field = formManager.findFormField(ffaf.getId());
		
		request.setAttribute("field", field);
		
		return mapping.findForward("item_input");
	}
	
	//�����Ŀ
	public ActionForward addItem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FlowFormActionForm ffaf = (FlowFormActionForm)form;
		List items = ffaf.getItems();
		for (Iterator iter = items.iterator(); iter.hasNext();) {
			FieldItem item = (FieldItem) iter.next();
			//���û�������κ�ֵ������Բ�����
			if(item == null || item.getValue() == null || item.getValue().trim().equals("")){
				iter.remove();
			}
		}
		formManager.updateFieldItems(ffaf.getId(), ffaf.getItems());
		
		return mapping.findForward("pub_add_success");
	}

	public void setFormManager(FormManager formManager) {
		this.formManager = formManager;
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}
	
}
