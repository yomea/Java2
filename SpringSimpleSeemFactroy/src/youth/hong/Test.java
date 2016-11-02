package youth.hong;

public class Test {

	public static void main(String[] args) throws Exception {
		BeanFactory applicationContext = new ClassPathXmlApplicationContext();
		Moveable moveable = (Moveable) applicationContext.getBean("car");
		moveable.run();
	}

}
