package youth.hong;

import java.io.IOException;
import java.util.Properties;

public class MyProperties {
	private static Properties pops = new Properties();
	
	static {
		try {
			pops.load(Test.class.getResourceAsStream("observer.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private MyProperties() {
		
	}
	
	public static String getProperty(String key) {
		return pops.getProperty(key);
	}
}
