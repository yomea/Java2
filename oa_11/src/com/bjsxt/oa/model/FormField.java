package com.bjsxt.oa.model;

import java.util.List;

/**
 * ����
 * @author Administrator
 * @hibernate.class table="T_FormField"
 */
public class FormField {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * �����ǩ
	 * @hibernate.property
	 */
	private String fieldLabel;
	
	/**
	 * ���������
	 * @hibernate.property
	 */
	private String fieldName;
	
	/**
	 * �����������ʽ
	 * @hibernate.many-to-one
	 */
	private FieldInput fieldInput;
	
	/**
	 * ���������
	 * @hibernate.many-to-one
	 */
	private FieldType fieldType;
	
	/**
	 * �����������Ŀ
	 * ���磺����������򣬶�����Щֵ�ɹ�ѡ��
	 * @hibernate.list table="T_FieldItem"
	 * @hibernate.key column="fieldId"
	 * @hibernate.list-index column="itemIndex"
	 * @hibernate.composite-element class="com.bjsxt.oa.model.FieldItem"
	 */
	private List items;
	
	/**
	 * ��Ӧ�ı�
	 * @hibernate.many-to-one column="flowFormId"
	 */
	private FlowForm flowForm;

	public FieldInput getFieldInput() {
		return fieldInput;
	}

	public void setFieldInput(FieldInput fieldInput) {
		this.fieldInput = fieldInput;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public FlowForm getFlowForm() {
		return flowForm;
	}

	public void setFlowForm(FlowForm flowForm) {
		this.flowForm = flowForm;
	}
}
