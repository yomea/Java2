package youth.hong;

import java.sql.Blob;

public class Student {
	private int id;
	private String name;
	private int age;
	private Blob picture;
	private Address address;
	
	
	public Student() {}
	
	
	
	public Student(int id, String name, int age) {
		
		this.id = id;
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	


	public Blob getPicture() {
		return picture;
	}



	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	
	


	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
