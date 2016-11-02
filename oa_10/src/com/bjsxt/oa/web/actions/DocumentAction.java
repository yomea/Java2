package com.bjsxt.oa.web.actions;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.bjsxt.oa.managers.DocumentManager;
import com.bjsxt.oa.managers.FormManager;
import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.managers.WorkflowManager;
import com.bjsxt.oa.model.ApproveInfo;
import com.bjsxt.oa.model.Document;
import com.bjsxt.oa.model.DocumentProperty;
import com.bjsxt.oa.model.FieldType;
import com.bjsxt.oa.model.FlowForm;
import com.bjsxt.oa.model.FormField;
import com.bjsxt.oa.web.forms.DocumentActionForm;

public class DocumentAction extends BaseAction {

	private DocumentManager documentManager;
	private WorkflowManager workflowManager;
	private FormManager formManager;
	
	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}

	//���Ĺ��������棬��ʾ�ҵĹ����б�
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pm", documentManager.searchMyDocuments(currentUser(request).getId()));
		
		return mapping.findForward("index");
	}
	
	/**
	 * �������б���ʾ�ɵ�ǰ��¼��Ա��˵Ĺ����б�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvedList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pm", documentManager.searchApprovedDocuments(currentUser(request).getId()));
		
		return mapping.findForward("approved_list");
	}
	
	/**
	 * �������б���ʾ�ȴ���ǰ��¼��Ա��˵Ĺ����б�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvingList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("documents", documentManager.searchApprovingDocuments(currentUser(request).getId()));
		
		return mapping.findForward("approving_list");
	}
	
	/**
	 * �ڴ������б��ϣ����ĳ���ĵ������Ե�����������棬�Դ��ĵ���������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approveInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("approve_input");
	}
	
	/**
	 * �û�����������Ϣ֮�󣬵�����棬���ĵ�������������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		
		String comment = daf.getApproveInfo();
		int documentId = daf.getId();
		int approverId = currentUser(request).getId();
		
		ApproveInfo approveInfo = new ApproveInfo();
		approveInfo.setApproveTime(new Date());
		approveInfo.setComment(comment);
		
		documentManager.addApproveInfo(approveInfo, documentId, approverId);
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * ���ҵĹ��Ļ�������б��ϣ�����ύ���ɴ��ύ��ѡ�����
	 * ����������ϣ��г���һ�����п�ѡ�Ĳ��裬�û�����ѡ������һ��
	 * ��������ύ������ϵͳ�������û���ѡ��ת�Ƶ���һ���ڵ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submitInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		Document doc = documentManager.findDocument(daf.getId());
		List transitions = workflowManager.searchNextTransitions(doc.getProcessInstanceId());
		request.setAttribute("steps", transitions);
		return mapping.findForward("submit_input");
	}
	
	/**
	 * �û�ѡ��������һ�����裬����ύ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentActionForm daf = (DocumentActionForm)form;
		
		
//		workflowManager.flowToNextStep(
//				currentUser(request).getUsername(), 
//				doc.getProcessInstanceId(), 
//				daf.getTransitionName());
//		
		documentManager.submitToWorkflow(currentUser(request).getId(), daf.getId(), daf.getTransitionName());
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * �鿴���ĵ�������ʷ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvedHistory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		request.setAttribute("historys", documentManager.searchApproveInfos(daf.getId()));		
		
		return mapping.findForward("approve_history");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		documentManager.delDocument(daf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	/**
	 * �����ӹ��ĵ�ʱ����Ҫѡ����Ӧ�����̣��˽����г����е������Թ�ѡ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward selectFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("workflows", workflowManager.searchAllWorkflows());
		
		return mapping.findForward("select_flow");
	}
	
	/**
	 * ѡ��������֮�󣨼�����������ƣ�����Ҫ�򿪹���¼�����
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
	
	/**
	 * ��ӹ��ĵĲ���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		Document document = new Document();
		BeanUtils.copyProperties(document, daf);
		
		//����Map������
		
		//��ActionForm�е�Map�����ݣ����ձ������Ӧ������������ת���������õ�document���󼴿�
		if(daf.getProps().isEmpty()){
			document.setProps(null);
		}else{
			int workflowId = daf.getWorkflowId();
			
			//���̶�Ӧ�ı�����
			FlowForm flowForm = formManager.findForm(workflowId);
			
			if(flowForm == null){
				document.setProps(null);
			}else{
				
				Map documentProps = new HashMap();
				
				//�õ��������Ӧ�����е�����
				Set fields = flowForm.getFields();
				
				for (Iterator iter = fields.iterator(); iter.hasNext();) {
					FormField field = (FormField) iter.next();
					
					String propertyName = field.getFieldName();
					FieldType propertyType = field.getFieldType();
					
					//���ݱ����������ƣ���Map�н������ϴ�������ԭʼֵ�ó���
					Object source = daf.getProps().get(propertyName);
					Object target = null;
					
					if(source != null){
						
						//����������ַ���
						if(source instanceof String && !propertyType.getType().equals("java.io.File")){
							
							Class targetClass = Class.forName(propertyType.getType());
							
							//����ConvertUtils���ߣ����ӽ����ϴ��������ַ���
							//ת��ΪFormFiled��Ӧ��FieldType��ָ�����͵Ķ���
							target = ConvertUtils.convert((String)source, targetClass);
						}
						
						//����������ϴ��ļ�
						if(propertyType.getType().equals("java.io.File")){
							
							//ע�⣺��������ϴ������ļ���struts�����Զ�ת��ΪFormFile
							//���͵Ķ��󣡣�����
							FormFile ff  = (FormFile)source;
							target = ff.getFileData();
						}
						
						//���ڣ���Ҫ��target��ֵ����document����
						if(target == null){
							throw new SystemException("�޷����������ֵ��");
						}
						
						DocumentProperty dp = new DocumentProperty();
						String type = propertyType.getType();
						if(type.equals("java.io.File")){
							dp.setJava_io_File((byte[])target);
						}
						if(type.equals("java.lang.Integer")){
							dp.setJava_lang_Integer((Integer)target);
						}
						if(type.equals("java.lang.String")){
							dp.setJava_lang_String((String)target);
						}
						
						documentProps.put(propertyName, dp);
					}
				}
				
				//��documentProps������document�����props����
				document.setProps(documentProps);
			}
		}
		
		if(daf.getContentFile() != null){
			document.setContent(daf.getContentFile().getFileData());
		}
		
		documentManager.addDocument(document, daf.getWorkflowId(), currentUser(request).getId());
		
		return mapping.findForward("pub_add_success");
	}
	
	//���ع��ĸ���
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		
		Document document = documentManager.findDocument(daf.getId());
		
		response.reset();
		response.setContentType("application/x-download;charset=GBK");
		response.setHeader("Content-Disposition", "attachment;filename=temp.doc");
		
		response.getOutputStream().write(document.getContent());
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		//ָʾstruts����Ҫ�Է���ֵ���д���
		return null;
	}

	public void setFormManager(FormManager formManager) {
		this.formManager = formManager;
	}
	
}
