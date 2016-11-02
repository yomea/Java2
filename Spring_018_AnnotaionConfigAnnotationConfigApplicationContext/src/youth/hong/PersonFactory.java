package youth.hong;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Component
@Configuration
@ComponentScan(basePackages="youth.hong")
public class PersonFactory {
	
	/*@Bean(name="boy", initMethod="init")
	public Boy boy() {
		return new Boy();
	}
	@Bean(name="girl", initMethod="init")
	public Girl girl() {
		return new Girl();
	}*/
}
