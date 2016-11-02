package youth.hong;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	//private ClassPathXmlApplicationContext applicationContext;
	private AnnotationConfigApplicationContext ac;
	@Before
	public void before() {
		//this.applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		this.ac = new AnnotationConfigApplicationContext(PersonFactory.class);//可以写多个class来定义多个config定义的配置类。
		
	}
	
	@org.junit.Test
	public void test() {
		//TestScope t = ((TestScope)applicationContext.getBean("t"));
		//System.out.println(t);
		Boy boy = ac.getBean(Boy.class);
		boy.init();
	}
	
	@After
	public void after() {
		//applicationContext.destroy();
		ac.destroy();
	}
}
