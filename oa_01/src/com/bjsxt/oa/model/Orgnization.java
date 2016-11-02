package com.bjsxt.oa.model;

import java.util.Set;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_Orgnization"
 */ 
public class Orgnization {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;

	/**
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * @hibernate.property
	 */
	private String sn;
	
	/**
	 * @hibernate.property
	 */
	private String description;
	
	/**
	 * @hibernate.many-to-one
	 * 		column="pid"
	 */
	private Orgnization parent;
	
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="pid"
	 * @hibernate.one-to-many class="com.bjsxt.oa.model.Orgnization"
	 */
	private Set children;
	
	
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Orgnization getParent() {
		return parent;
	}
	public void setParent(Orgnization parent) {
		this.parent = parent;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
}
