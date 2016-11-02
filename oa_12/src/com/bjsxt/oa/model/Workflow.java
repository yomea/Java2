package com.bjsxt.oa.model;

/**
 * 流程
 * @author Administrator
 * @hibernate.class table="T_Workflow"
 */
public class Workflow {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * 流程名称
	 * @hibernate.property
	 * 		unique="true"
	 */
	private String name;
	
	/**
	 * 流程定义文件
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] processDefinition;
	
	/**
	 * 流程定义图片
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] processImage;

	public byte[] getProcessDefinition() {
		return processDefinition;
	}
	public void setProcessDefinition(byte[] processDefinition) {
		this.processDefinition = processDefinition;
	}
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
	public byte[] getProcessImage() {
		return processImage;
	}
	public void setProcessImage(byte[] pic) {
		this.processImage = pic;
	}
	
}
