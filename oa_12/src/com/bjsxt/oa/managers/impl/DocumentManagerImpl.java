package com.bjsxt.oa.managers.impl;

import java.util.Date;
import java.util.List;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.managers.DocumentManager;
import com.bjsxt.oa.managers.WorkflowManager;
import com.bjsxt.oa.model.ApproveInfo;
import com.bjsxt.oa.model.Document;
import com.bjsxt.oa.model.User;
import com.bjsxt.oa.model.Workflow;

public class DocumentManagerImpl extends AbstractManager implements
		DocumentManager {

	private WorkflowManager workflowManager;
	
	//����
	public void addApproveInfo(ApproveInfo approveInfo, int documentId,
			int approverId) {
		approveInfo.setDocument((Document)getHibernateTemplate().load(Document.class, documentId));
		approveInfo.setApprover((User)getHibernateTemplate().load(User.class, approverId));
		getHibernateTemplate().save(approveInfo);
	}

	//��ӹ���
	public void addDocument(Document document, int workflowId, int userId) {
		
		//���湫����Ϣ
		document.setWorkflow((Workflow)getHibernateTemplate().load(Workflow.class, workflowId));
		document.setCreator((User)getHibernateTemplate().load(User.class, userId));
		document.setStatus(Document.STATUS_NEW);
		document.setCreateTime(new Date());
		getHibernateTemplate().save(document);
		
		//�������ʵ��
		long processInstanceId = workflowManager.addProcessInstance(document.getWorkflow().getName(), document.getId());
		
		//������ʵ���ı�ʶ�����Ķ���
		document.setProcessInstanceId(processInstanceId);
		getHibernateTemplate().update(document);
	}

	//ɾ������
	public void delDocument(int documentId) {
		Document document = (Document)getHibernateTemplate().load(Document.class, documentId);
		
		//ɾ��������Ϣ
		getHibernateTemplate().delete(document);
		
		//ɾ������ʵ��
		workflowManager.delProcessInstance(document.getProcessInstanceId());
	} 

	//�����ض�����
	public Document findDocument(int documentId) {
		
		return (Document)getHibernateTemplate().load(Document.class, documentId);
	}

	//���ҹ��ĵ�������ʷ
	public List<?> searchApproveInfos(int documentId) {
		
		return getHibernateTemplate().find("from ApproveInfo ai where ai.document.id = ?", documentId);
	}

	//�����û����������Ĺ���
	public PagerModel searchApprovedDocuments(int userId) {
		
		return searchPaginated("select distinct ai.document from ApproveInfo ai where ai.approver.id = ?",userId);
	}

	//�������ڵȴ������Ĺ���
	public List<?> searchApprovingDocuments(int userId) {
		User user = (User)getHibernateTemplate().load(User.class, userId);
		
		//��������ת���û�����Ĺ��ı�ʶ�б�
		List<?> docIds = workflowManager.searchApprovingDocuments(user.getUsername());
		
		if(docIds == null || docIds.isEmpty()){
			return null;
		}
		
		//���ݹ��ı�ʶ�������еĹ��Ķ���
		return getSession()
			.createQuery("select d from Document d where d.id in (:ids)")
			.setParameterList("ids", docIds)
			.list();
	}

	//�����û����������й���
	public PagerModel searchMyDocuments(int userId) {
		
		return searchPaginated("select d from Document d where d.creator.id = ?", userId);
	}

	//�ύ������
	public void submitToWorkflow(int userId, int documentId, String transitionName) {
		User user = (User)getHibernateTemplate().load(User.class, userId);
		String username = user.getUsername();
		
		Document document = (Document)getHibernateTemplate().load(Document.class, documentId);
		long processInstanceId = document.getProcessInstanceId();
		
		String status = workflowManager.flowToNextStep(username, processInstanceId, transitionName);
		
		document.setStatus(status);
		getHibernateTemplate().update(document);
	}
	
	//���¹�����Ϣ
	public void updateDocument(Document document) {
		
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}

}
