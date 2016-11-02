package youth.hong;

import java.util.List;

public class User {
	
	private String username;
	private int age;
	private Address address;
	private List<String> words;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
		super();
	}

	public User(String username, int age, Address address) {
		super();
		this.username = username;
		this.age = age;
		this.address = address;

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

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", address=" + address + ", words=" + words + "]";
	}
  
	
	
}
