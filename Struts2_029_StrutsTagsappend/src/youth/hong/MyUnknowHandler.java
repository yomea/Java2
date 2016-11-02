package youth.hong;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.UnknownHandler;
import com.opensymphony.xwork2.XWorkException;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class MyUnknowHandler implements UnknownHandler {

	@Override
	public ActionConfig handleUnknownAction(String arg0, String arg1) throws XWorkException {
		return null;
	}

	@Override
	public Object handleUnknownActionMethod(Object arg0, String arg1) throws NoSuchMethodException {
		return null;
	}

	@Override
	public Result handleUnknownResult(ActionContext actioncontext, String arg1, ActionConfig arg2, String arg3)
			throws XWorkException {
		actioncontext.put("grate", "hello");
		
		return new ServletDispatcherResult("/test.jsp");
	}
	
}
