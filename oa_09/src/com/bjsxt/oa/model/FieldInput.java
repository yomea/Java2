package com.bjsxt.oa.model;

/**
 * ����������ʽ
 * @author Administrator
 * @hibernate.class table="T_FieldInput"
 */
public class FieldInput {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ҳ���Ԫ�ص����ƣ��磺
	 * �ı�������������ļ��ȵ�
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * ������ҳ���Ԫ�أ���γ���ΪHTML����
	 * ͨ��ģ����ʵ�֣�
	 * @hibernate.property
	 */
	private String template;

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

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
