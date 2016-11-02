package com.bjsxt.oa.managers;

import java.util.List;

import com.bjsxt.oa.model.Workflow;

public interface WorkflowManager {
	
	/**
	 * 部署流程定义
	 * @param processDefinition
	 * @param processImage
	 */
	public void deployProcessDefinition(byte[] processDefinition,byte[] processImage);
	
	/**
	 * 查找特定流程定义信息
	 * @param workflowId 流程标识(ID)
	 * @return
	 */
	public Workflow findWorkflow(int workflowId);
	
	/**
	 * 删除流程定义
	 * @param workflowId 流程标识（ID）
	 */
	public void delWorkflow(int workflowId);
	
	/**
	 * 查询已有的所有流程定义信息
	 * @return 列表的元素是: Workflow对象
	 */
	public List searchAllWorkflows();
	
	/**
	 * 添加流程实例
	 * @param workflowName 流程名称
	 * @param documentId 公文标识
	 * @return 流程实例标识
	 */
	public long addProcessInstance(String workflowName,int documentId);
	
	/**
	 * 删除流程实例
	 * @param processInstanceId 流程实例的标识
	 */
	public void delProcessInstance(long processInstanceId);
	
	/**
	 * 查找流转到某个用户那里的所有公文
	 * @param username 用户帐号
	 * @return 公文的标识列表，其元素是int类型
	 */
	public List searchApprovingDocuments(String username);
	
	/**
	 * 搜索下一步的流向，即下一步都可以走哪些路径
	 * @param processInstanceId 流程实例标识
	 * @return 流向的名称列表
	 */
	public List searchNextTransitions(long processInstanceId);
	
	/**
	 * 流向下一步
	 * @param username 用户帐号
	 * @param processInstanceId 流程实例标识
	 * @param transitionName 流向名称
	 * @return 返回状态信息，因为公文的流转将会触发公文状态的改变！
	 */
	public String flowToNextStep(String username,long processInstanceId,String transitionName);
}
