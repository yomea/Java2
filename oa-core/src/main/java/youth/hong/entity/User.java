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
	 * ��¼�ʺ�
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
	 */
	private String username;
	
	/**
	 * ��¼����
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private String password;
	
	/**
	 * �ʺŴ���ʱ��
	 * @hibernate.property update="false"
	 */
	private Date createTime;
	
	/**
	 * �ʺ�ʧЧʱ��
	 * @hibernate.property
	 */
	private Date expireTime;
	
	/**
	 * ��Ӧ����Ա��Ϣ
	 * User 1��������1 Person
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
