package youth.hong;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAop {
	public void log() {
		System.out.println("test...");
	}
	
	public void after() {
		System.out.println("after...");
	}
	
	public void afterReturning() {
		System.out.println("afterReturning...");
	}
	
	public void afterThrowException() {
		System.out.println("afterThrowException...");
	}
	
	public Object round(ProceedingJoinPoint pjp) {
		Object obj = null;
		
		try {
			System.out.println("round 1");
			obj = pjp.proceed();
			System.out.println("round 2");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public Object around(ProceedingJoinPoint pjp, String username, int times) {
		Object obj = null;
		System.out.println("around:" + username + "    " + times);
		try {
			System.out.println("around: 1");
			obj = pjp.proceed();
			System.out.println("around: 2");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
