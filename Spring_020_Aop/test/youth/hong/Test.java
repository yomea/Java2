package youth.hong;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	private ClassPathXmlApplicationContext applicationContext;
	@Before
	public void before() {
		this.applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
	}
	
	@org.junit.Test
	public void test() {
		/*TestScope t = ((TestScope)applicationContext.getBean("t"));
		t.test();*/
	}
	
	@After
	public void after() {
		applicationContext.destroy();
	}
}
