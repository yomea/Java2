package youth.hong;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) throws Throwable {
		User user = new User();
		MyHandler m = new MyHandler(user);
		Person p = (Person)Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{Person.class}, m);
		p.SayHello();
	}

}
