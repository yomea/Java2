package youth.hong.FirstListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		String name = arg0.getServletRequest().getParameter("name");
		ServletContext application = arg0.getServletContext();
		Integer count = (Integer)arg0.getServletContext().getAttribute("count");
		if(count == null) {
			count = 1;
			application.setAttribute("count", count);
		}
		application.setAttribute("count", count + 1);
		System.out.println("requestInitialized count " + count);
	}

}
