package youth.hong;

import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.load(Test.class.getResourceAsStream("test.properties"));
		
		String className = p.getProperty("test");
//		System.out.println(className);
		Moveable m = (Moveable)Class.forName(className).newInstance();
		m.run();
	}

}
