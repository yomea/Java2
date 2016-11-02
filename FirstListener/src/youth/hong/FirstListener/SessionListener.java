package youth.hong.FirstListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	
	int i = 0;
	
	public void sessionCreated(HttpSessionEvent arg0) {
		i++;
		System.out.println(i);
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		i--;
		System.out.println(i);
	}

}
