package com.bjsxt.oa.web.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bjsxt.oa.model.FieldItem;
import com.bjsxt.oa.web.AutoArrayList;

public class FlowFormActionForm extends ActionForm {
	
	private int id;
	
	/**
	 * 流程
	 */
	private int workflowId;
	
	/**
	 * 模板
	 */
	private String template;
	
	//用于表单域的输入
	private int formId;
	private int fieldTypeId;
	private int fieldInputId;
	private String fieldName;
	private String fieldLabel;

	//表单域条目的输入
	private List items = new AutoArrayList(FieldItem.class);
	
	public int getFieldInputId() {
		return fieldInputId;
	}

	public void setFieldInputId(int fieldInputId) {
		this.fieldInputId = fieldInputId;
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

	public int getFieldTypeId() {
		return fieldTypeId;
	}

	public void setFieldTypeId(int fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
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

	public int getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}
}
