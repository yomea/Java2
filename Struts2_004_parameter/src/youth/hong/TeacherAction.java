package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport {
	private String name;
	private int age;
	public String add() {
		System.out.println(name);
		System.out.println(age);
		return "test";
	}
	
	public String delete() {
		return "test";
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
	
	
}
