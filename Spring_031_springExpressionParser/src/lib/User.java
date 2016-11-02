package lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("user")
public class User {
	@Value("#{systemProperties['user.dir']}")
	private String name;
	
	//@Value("#{T(java.lang.Math).random()*10000}")
	private int age;
	

	public User() {
		
		
	}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	@Autowired//这种形式的@Value需要与@Autowired配合
	public void setAge(@Value("#{T(java.lang.Math).random()*10000}") int age) {
		this.age = age;
	}
	
	
}
