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
	 * 模块名称
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
	 */
	private String name;
	
	/**
	 * 模块编号
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
	 */
	private String sn;
	
	/**
	 * 模块的入口地址
	 * @hibernate.property
	 */
	private String url;
	
	/**
	 * 模块的排序号
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
