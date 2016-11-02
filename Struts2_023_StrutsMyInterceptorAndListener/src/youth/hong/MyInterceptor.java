package youth.hong;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start = System.currentTimeMillis();
		//((ActionSupport)invocation.getAction()).addActionError(anErrorMessage);
		invocation.addPreResultListener(new MyPreResultListener());
		System.out.println(1);
		String returnString = invocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println(-1);
		System.out.println(end - start);
		
		return returnString;
	}

	

}
