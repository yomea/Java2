package youth.hong;

import java.util.ArrayList;
import java.util.List;



public class ActionInvocation {
	List<Interceptor> interceptors = new ArrayList<Interceptor>();
	int index = -1;
	Action action = new Action();
	
	public ActionInvocation() {
		interceptors.add(new FirstInterceptor());
		interceptors.add(new SecondInterceptor());
	}
	public void invoke() {
		index++;
		if(index >= interceptors.size()) {
			action.execute();
		} else {
			interceptors.get(index).intercept(this);
		}
	}
	
}
