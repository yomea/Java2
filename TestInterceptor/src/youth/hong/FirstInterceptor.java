package youth.hong;

public class FirstInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation a) {
		System.out.println(1);
		a.invoke();
		System.out.println(-1);
	}

}
