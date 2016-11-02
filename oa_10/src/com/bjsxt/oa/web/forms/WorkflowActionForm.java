package com.bjsxt.oa.web.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class WorkflowActionForm extends ActionForm {
	private int id;
	
	private String name;
	
	/**
	 * ͨ��FormFile�����ϴ��ļ�
	 */
	private FormFile processDefinition;
	
	private FormFile processImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FormFile getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(FormFile processDefinition) {
		this.processDefinition = processDefinition;
	}

	public FormFile getProcessImage() {
		return processImage;
	}

	public void setProcessImage(FormFile processImage) {
		this.processImage = processImage;
	}
}
