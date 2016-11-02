package youth.hong;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	
	private Object p;

	public MyHandler(Object p) {
		super();
		this.p = p;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start...");
		method.invoke(p, args);
		System.out.println("end...");
		return null;
	}

}
