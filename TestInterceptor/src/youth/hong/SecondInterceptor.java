package youth.hong;

public class SecondInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation a) {
		System.out.println(2);
		a.invoke();
		System.out.println(-2);
	}

	

}
