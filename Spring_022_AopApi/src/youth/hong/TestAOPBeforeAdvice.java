package youth.hong;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class TestAOPBeforeAdvice implements MethodBeforeAdvice {
	
	private int count;
	
	public void beforeAdvice() {
		System.out.println("TestAOPBeforeAdvice...");
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		//method.invoke(target, args)
		System.out.println("TestAOPBeforeAdvice" + method.getName() + "  " + target.getClass().getName());
		++count;
	}
	
	public int getCount() {
        return count;
    }
}
