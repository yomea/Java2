package com.bjsxt.oa.model;

import java.util.Date;

/**
 * 审批历史信息
 * @author Administrator
 * @hibernate.class table="T_ApproveInfo"
 */
public class ApproveInfo {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * 审批意见
	 * @hibernate.property
	 */
	private String comment;
	
	/**
	 * 审批时间
	 * @hibernate.property
	 */
	private Date approveTime;
	
	/**
	 * 被审批的公文
	 * @hibernate.many-to-one
	 */
	private Document document;
	
	/**
	 * 审批者
	 * @hibernate.many-to-one
	 */
	private User approver;
	
	public User getApprover() {
		return approver;
	}
	public void setApprover(User approver) {
		this.approver = approver;
	}
	public Date getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
