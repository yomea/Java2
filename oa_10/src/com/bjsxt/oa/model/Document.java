package com.bjsxt.oa.model;

import java.util.Date;
import java.util.Map;

/**
 * ����
 * @author Administrator
 * @hibernate.class table="T_Document"
 */
public class Document {
	
	public final static String STATUS_NEW = "�½�";
	public final static String STATUS_END = "���";
	
	/**
	 * @hibernate.id 
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String title;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String description;
	
	/**
	 * �������ݣ����ϴ��ļ������ݣ�
	 * ��Щ�ϴ��ļ������ݽ��ᱻ���浽���ݿ�
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] content;
	
	/**
	 * ������
	 * @hibernate.many-to-one
	 */
	private User creator;
	
	/**
	 * ����ʱ��
	 * @hibernate.property
	 */
	private Date createTime;
	
	/**
	 * �������ߵ�����
	 * @hibernate.many-to-one
	 */
	private Workflow workflow;
	
	/**
	 * ����ʵ���ı�ʶ
	 * @hibernate.property
	 */
	private long processInstanceId;
	
	/**
	 * ���ĵĵ�ǰ״̬��Ϣ��
	 * ֻ���½�״̬�Ĺ��ģ��ſ��Ա����º�ɾ��
	 * ֻ�������״̬�Ĺ��ģ��ſ��Ա��鵵
	 * @hibernate.property
	 */
	private String status;
	
	/**
	 * ���Ķ�̬���ԣ�key:String , value: DocumentProperty
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
