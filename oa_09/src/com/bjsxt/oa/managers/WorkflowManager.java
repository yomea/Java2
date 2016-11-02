package com.bjsxt.oa.managers;

import java.util.List;

import com.bjsxt.oa.model.Workflow;

public interface WorkflowManager {
	
	/**
	 * �������̶���
	 * @param processDefinition
	 * @param processImage
	 */
	public void deployProcessDefinition(byte[] processDefinition,byte[] processImage);
	
	/**
	 * �����ض����̶�����Ϣ
	 * @param workflowId ���̱�ʶ(ID)
	 * @return
	 */
	public Workflow findWorkflow(int workflowId);
	
	/**
	 * ɾ�����̶���
	 * @param workflowId ���̱�ʶ��ID��
	 */
	public void delWorkflow(int workflowId);
	
	/**
	 * ��ѯ���е��������̶�����Ϣ
	 * @return �б��Ԫ����: Workflow����
	 */
	public List searchAllWorkflows();
	
	/**
	 * �������ʵ��
	 * @param workflowName ��������
	 * @param documentId ���ı�ʶ
	 * @return ����ʵ����ʶ
	 */
	public long addProcessInstance(String workflowName,int documentId);
	
	/**
	 * ɾ������ʵ��
	 * @param processInstanceId ����ʵ���ı�ʶ
	 */
	public void delProcessInstance(long processInstanceId);
	
	/**
	 * ������ת��ĳ���û���������й���
	 * @param username �û��ʺ�
	 * @return ���ĵı�ʶ�б���Ԫ����int����
	 */
	public List searchApprovingDocuments(String username);
	
	/**
	 * ������һ�������򣬼���һ������������Щ·��
	 * @param processInstanceId ����ʵ����ʶ
	 * @return ����������б�
	 */
	public List searchNextTransitions(long processInstanceId);
	
	/**
	 * ������һ��
	 * @param username �û��ʺ�
	 * @param processInstanceId ����ʵ����ʶ
	 * @param transitionName ��������
	 * @return ����״̬��Ϣ����Ϊ���ĵ���ת���ᴥ������״̬�ĸı䣡
	 */
	public String flowToNextStep(String username,long processInstanceId,String transitionName);
}
