package com.bjsxt.oa.model;

/**
 * ��������
 * @author Administrator
 * @hibernate.class table="T_FieldType"
 */
public class FieldType {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ���͵����ƣ��磺�ַ��������͡��ļ��ȵ�
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * ��Ӧ��Java���ͣ��磺String��Integer��File
	 * @hibernate.property
	 */
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
