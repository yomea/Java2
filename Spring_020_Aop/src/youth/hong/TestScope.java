package youth.hong;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component("t")
public class TestScope implements ApplicationContextAware {
	private ApplicationContext applicationConext;
	
	
	
	

	public void setApplicationConext(ApplicationContext applicationConext) {
		this.applicationConext = applicationConext;
	}

	

	

	public boolean test() {
		System.out.println("--------------------------------------------------");
		System.out.println("**********************************************");
		//int n = 3/0;
		return true;
	}
	
	public void advice(String username, int times) {
		System.out.println(username + "/////" + times);
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		//System.out.println("test");
		this.applicationConext = arg0;
		((TestScope)applicationConext.getBean("t")).test();
		((TestScope)applicationConext.getBean("t")).advice("youth", 3);
		//test();
	}
}
