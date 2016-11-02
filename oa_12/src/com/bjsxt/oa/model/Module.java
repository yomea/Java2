package com.bjsxt.oa.model;

import java.util.Set;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_Module"
 */
public class Module {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ģ������
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
	 */
	private String name;
	
	/**
	 * ģ����
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
	 */
	private String sn;
	
	/**
	 * ģ�����ڵ�ַ
	 * @hibernate.property
	 */
	private String url;
	
	/**
	 * ģ��������
	 * @hibernate.property
	 */
	private int orderNo;
	
	/**
	 * @hibernate.many-to-one column="parentId"
	 */
	private Module parent;
	
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="parentId"
	 * @hibernate.one-to-many class="com.bjsxt.oa.model.Module"
	 */
	private Set children;
	
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
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
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Module getParent() {
		return parent;
	}
	public void setParent(Module parent) {
		this.parent = parent;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
