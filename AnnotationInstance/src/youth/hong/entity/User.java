package youth.hong.entity;

import youth.hong.annotation.Column;
import youth.hong.annotation.Table;

@Table("user")
public class User {
	
	@Column("username")
	private String username;
	
	@Column("password")
	private String password;
	
	@Column("id")
	private int id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
