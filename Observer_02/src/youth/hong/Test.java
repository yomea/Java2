package youth.hong;

import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		Child c = new Child();
		String str = MyProperties.getProperty("observer");
		System.out.println(str);
		StringTokenizer st = new StringTokenizer(str, ",");
		while(st.hasMoreTokens()) {
			try {
				c.addActionListener((ActionListener)Class.forName(st.nextToken()).newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
