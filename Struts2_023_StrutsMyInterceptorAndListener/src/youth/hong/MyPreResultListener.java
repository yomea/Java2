package youth.hong;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class MyPreResultListener implements PreResultListener {

	@Override
	public void beforeResult(ActionInvocation invocation, String returnString) {
		// TODO Auto-generated method stub
		System.out.println("·µ»ØµÄ×Ö·û´®ÊÇ£º" + returnString);
		
		
	}
	
	
}
