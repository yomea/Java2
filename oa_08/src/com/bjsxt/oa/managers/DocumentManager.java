package com.bjsxt.oa.managers;

import java.util.List;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.ApproveInfo;
import com.bjsxt.oa.model.Document;

public interface DocumentManager {
	
	/**
	 * 添加公文信息
	 * @param document
	 * @param workflowId
	 * @param userId
	 */
	public void addDocument(Document document,int workflowId,int userId);
	
	/**
	 * 查找某个公文的信息
	 * @param documentId
	 * @return
	 */
	public Document findDocument(int documentId);
	
	/**
	 * 更新公文信息
	 * @param document 
	 */
	public void updateDocument(Document document);
	
	/**
	 * 删除公文信息
	 * @param documentId
	 */
	public void delDocument(int documentId);
	
	/**
	 * 搜索用户自身创建的公文列表
	 * @param userId
	 * @return
	 */
	public PagerModel searchMyDocuments(int userId);
	
	/**
	 * 查询公文的审批信息
	 * @param documentId
	 * @return
	 */
	public List searchApproveInfos(int documentId);
	
	/**
	 * 查询待用户审批的公文列表
	 * @param userId
	 * @return
	 */
	public List searchApprovingDocuments(int userId);
	
	/**
	 * 查询用户已审批过的公文列表
	 * @param userId
	 * @return
	 */
	public PagerModel searchApprovedDocuments(int userId);
	
	/**
	 * 存储审批信息
	 * @param approveInfo 审批信息
	 * @param documentId 被审批的公文
	 * @param approverId 审批者ID
	 */
	public void addApproveInfo(ApproveInfo approveInfo,int documentId,int approverId);
	
	/**
	 * 提交到流程
	 *
	 */
	public void submitToWorkflow(int userId,int documentId,String transistionName);
}
