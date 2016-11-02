package youth.hong.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter implements javax.servlet.Filter {
	private FilterConfig config;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String str = config.getInitParameter("path");
		String[] strArray = str.split(";");
		for (String string : strArray) {
			if(request.getRequestURI().indexOf(string)!=-1) {
				arg2.doFilter(arg0, arg1);
				return;
			}
		}
		if(request.getSession().getAttribute("username") != null) {
			arg2.doFilter(arg0, arg1);
		} else {
			response.sendRedirect("login.jsp");
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}
	
}
