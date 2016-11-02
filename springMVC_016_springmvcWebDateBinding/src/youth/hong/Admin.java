package youth.hong;

public class Admin {
	private String username;
	private String gender;
	
	public Admin() {
		super();
	}
	public Admin(String username, String gender) {
		super();
		this.username = username;
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", gender=" + gender + "]";
	}
	
}
