package youth.hong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Component
@Configuration
public class PersonFactory {
	
	@Bean(name="boy", initMethod="init")
	public Boy boy() {
		return new Boy();
	}
	@Bean(name="girl", initMethod="init")
	public Girl girl() {
		return new Girl();
	}
}
