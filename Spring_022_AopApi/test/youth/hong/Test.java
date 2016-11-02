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
		/*TestAOPPointcut test = ((TestAOPPointcut)applicationContext.getBean("aop"));
		TestAOPBeforeAdvice taba = ((TestAOPBeforeAdvice)applicationContext.getBean("beforeAdvice"));
		test.test();
		taba.beforeAdvice();*/
		((Fit)applicationContext.getBean("t")).fitler();
		
	}
	
	@After
	public void after() {
		applicationContext.destroy();
	}
}
