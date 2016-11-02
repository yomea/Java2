package youth.hong;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {
	private Object t = null;
	public TimeInvocationHandler(Object t) {
		this.t = t;
	}

	@Override
	public void invoke(Object o, Method m) {
		 Long start = System.currentTimeMillis();
		
		 try {
			m.invoke(t, new Object[]{});
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		 Long end = System.currentTimeMillis();
		 System.out.println(end - start);

	}

}
