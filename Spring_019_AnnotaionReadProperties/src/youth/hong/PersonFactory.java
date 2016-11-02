package youth.hong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Component
@Configuration
//@ImportResource(locations="classpath:/beans.xml")
public class PersonFactory {
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	
	
	@Bean(name="boy", initMethod="init")
	public Boy boy() {
		return new Boy();
	}
	@Bean(name="girl", initMethod="init")
	public Girl girl() {
		return new Girl();
	}
	
	@Bean
	@Scope(value="singleton")
	public User user() {
		return new User(username, password);
	}
}
