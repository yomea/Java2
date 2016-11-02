package youth.hong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Autowired@Qualifier("stringStore")
	private Store<String> s1;
	@Autowired
	@Qualifier("integerStore")
	
	private Store<Integer> s2;
	
	
	@Bean(name="boy", initMethod="init")
	public Boy boy() {
		return new Boy();
	}
	@Bean(name="girl", initMethod="init")
	public Girl girl() {
		return new Girl();
	}
	
	
	@Bean
	public Store<String> stringStore() {
		return new StringStore();
	}
	
	@Bean
	public Store<Integer> integerStore() {
		return new IntegerStore();
	}
	
	@Bean
	public User youth() {
		System.out.println(s1.getClass().getName());
		System.out.println(s2.getClass().getName());
		return new User(username, password);
	}
	
	/*@Bean
	public Store Sstore() {//将会导致自动装配出现多个found的错误
		
		return new IntegerStore();
	}*/
}
