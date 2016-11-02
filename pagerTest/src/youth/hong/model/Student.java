package youth.hong.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String stuName;
	
	private int age;
	
	private int gender;
	
	private String address;
	
	public Student() {
		super();
	}
	
	public Student(Map<String, Object> map) {
		super();
		if(map != null && !map.isEmpty()) {
			this.id = (int)map.get("id");
			this.stuName = (String)map.get("stu_name");
			this.age = (int)map.get("age");
			this.gender = (int)map.get("gender");
			this.address = (String)map.get("address");
		}
	}


	public Student(int id, String stuName, int age, int gender, String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="stu_name")
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age + ", gender=" + gender + ", address="
				+ address + "]";
	}

}
