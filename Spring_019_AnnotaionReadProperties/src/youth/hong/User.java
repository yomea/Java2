package youth.hong;

import org.springframework.stereotype.Component;
@Component
//@ImportResource(locations="classpath:/beans.xml")
public class User {
	//@Value("${jdbc.username}")
	private String username;
	//@Value("${jdbc.password}")
	private String password;
	/*public User() {
		haha();
	}*/
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		haha();
	}
	
	private void haha() {
		System.out.println(username + "---" + password);

	}
}
