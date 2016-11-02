package com.bjsxt.oa.model;

import java.util.Set;

/**
 * ���̱�
 * @author Administrator
 * @hibernate.class table="T_FlowForm"
 */
public class FlowForm {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ��Ӧ�Ĺ�����
	 * @hibernate.many-to-one
	 */
	private Workflow workflow;
	
	/**
	 * ��ģ��
	 * @hibernate.property
	 */
	private String template;
	
	/**
	 * �������ı���
	 * @hibernate.set inverse="true"
	 * @hibernate.key column="flowFormId"
	 * @hibernate.one-to-many class="com.bjsxt.oa.model.FormField"
	 */
	private Set fields;

	public Set getFields() {
		return fields;
	}

	public void setFields(Set fields) {
		this.fields = fields;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
}
