package com.bjsxt.service;

import java.util.Date;

public class Inventor {

	private String name;
	
	private Date time;
	
	private String country;
	
	public Inventor(String name, Date time, String country) {
		this.name = name;
		this.time = time;
		this.country = country;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
