package com.bjsxt.oa.model;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_Person"
 */
public class Person {
	
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
	private String sex;
	
	/**
	 * @hibernate.property
	 */
	private String address;
	
	/**
	 * @hibernate.property
	 */
	private String duty;
	
	/**
	 * @hibernate.property
	 */
	private String phone;
	
	/**
	 * @hibernate.property
	 */
	private String description;
	
	/**
	 * @hibernate.many-to-one
	 */
	private Orgnization org;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Orgnization getOrg() {
		return org;
	}
	public void setOrg(Orgnization org) {
		this.org = org;
	}
}
