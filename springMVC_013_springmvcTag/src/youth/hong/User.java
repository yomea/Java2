package youth.hong;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private int age;
	private Address address;
	private String gender;
	private List<Address> sorce = new ArrayList<Address>();
	
	public List<Address> getSorce() {
		return sorce;
	}

	public void setSorce(List<Address> sorce) {
		this.sorce = sorce;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
		super();
		for(int i = 0; i < 10; i++) {
			sorce.add(new Address("" + i));
		}
	}

	public User(String username, int age, Address address, String gender) {
		super();
		this.username = username;
		this.age = age;
		this.address = address;
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
