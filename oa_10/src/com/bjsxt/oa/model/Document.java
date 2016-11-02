package com.bjsxt.oa.model;

import java.util.Date;
import java.util.Map;

/**
 * 公文
 * @author Administrator
 * @hibernate.class table="T_Document"
 */
public class Document {
	
	public final static String STATUS_NEW = "新建";
	public final static String STATUS_END = "完成";
	
	/**
	 * @hibernate.id 
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * 标题
	 * @hibernate.property
	 */
	private String title;
	
	/**
	 * 描述
	 * @hibernate.property
	 */
	private String description;
	
	/**
	 * 公文内容，即上传文件的内容，
	 * 这些上传文件的内容将会被保存到数据库
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] content;
	
	/**
	 * 创建者
	 * @hibernate.many-to-one
	 */
	private User creator;
	
	/**
	 * 创建时间
	 * @hibernate.property
	 */
	private Date createTime;
	
	/**
	 * 公文所走的流程
	 * @hibernate.many-to-one
	 */
	private Workflow workflow;
	
	/**
	 * 流程实例的标识
	 * @hibernate.property
	 */
	private long processInstanceId;
	
	/**
	 * 公文的当前状态信息：
	 * 只有新建状态的公文，才可以被更新和删除
	 * 只有已完成状态的公文，才可以被归档
	 * @hibernate.property
	 */
	private String status;
	
	/**
	 * 表单的动态属性，key:String , value: DocumentProperty
	 * @hibernate.map table="T_Document_Properties"
	 * @hibernate.key column="documentId"
	 * @hibernate.map-key type="string" column="propertyName"
	 * @hibernate.composite-element class="com.bjsxt.oa.model.DocumentProperty"
	 */
	private Map props;
	
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	public long getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map getProps() {
		return props;
	}
	public void setProps(Map props) {
		this.props = props;
	}
}
