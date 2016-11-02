package com.bjsxt.oa.managers;

import java.util.List;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.ApproveInfo;
import com.bjsxt.oa.model.Document;

public interface DocumentManager {
	
	/**
	 * ��ӹ�����Ϣ
	 * @param document
	 * @param workflowId
	 * @param userId
	 */
	public void addDocument(Document document,int workflowId,int userId);
	
	/**
	 * ����ĳ�����ĵ���Ϣ
	 * @param documentId
	 * @return
	 */
	public Document findDocument(int documentId);
	
	/**
	 * ���¹�����Ϣ
	 * @param document 
	 */
	public void updateDocument(Document document);
	
	/**
	 * ɾ��������Ϣ
	 * @param documentId
	 */
	public void delDocument(int documentId);
	
	/**
	 * �����û��������Ĺ����б�
	 * @param userId
	 * @return
	 */
	public PagerModel searchMyDocuments(int userId);
	
	/**
	 * ��ѯ���ĵ�������Ϣ
	 * @param documentId
	 * @return
	 */
	public List searchApproveInfos(int documentId);
	
	/**
	 * ��ѯ���û������Ĺ����б�
	 * @param userId
	 * @return
	 */
	public List searchApprovingDocuments(int userId);
	
	/**
	 * ��ѯ�û����������Ĺ����б�
	 * @param userId
	 * @return
	 */
	public PagerModel searchApprovedDocuments(int userId);
	
	/**
	 * �洢������Ϣ
	 * @param approveInfo ������Ϣ
	 * @param documentId �������Ĺ���
	 * @param approverId ������ID
	 */
	public void addApproveInfo(ApproveInfo approveInfo,int documentId,int approverId);
	
	/**
	 * �ύ������
	 *
	 */
	public void submitToWorkflow(int userId,int documentId,String transistionName);
}
