package com.bjsxt.oa.model;

/**
 * ��������б�Ԫ�أ���<option value="value">label</option>
 * @author Administrator
 *
 */
public class FieldItem {
	
	/**
	 * �ı�
	 * @hibernate.property
	 */
	private String label;
	
	/**
	 * ֵ
	 * @hibernate.property
	 */
	private String value;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
