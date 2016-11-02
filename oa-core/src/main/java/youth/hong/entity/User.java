package youth.hong.entity;

import java.util.Date;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_User"
 */
public class User {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * 登录帐号
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
	 */
	private String username;
	
	/**
	 * 登录密码
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private String password;
	
	/**
	 * 帐号创建时间
	 * @hibernate.property update="false"
	 */
	private Date createTime;
	
	/**
	 * 帐号失效时间
	 * @hibernate.property
	 */
	private Date expireTime;
	
	/**
	 * 对应的人员信息
	 * User 1－－－－1 Person
	 * @hibernate.many-to-one
	 * 		unique="true"
	 */
	private Person person;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
}
