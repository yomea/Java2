package youth.hong.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import youth.hong.entity.User;

public class LoginFilter implements Filter {
	private String login = "";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String uri = request.getRequestURI();
		Pattern pattern = Pattern.compile(".+\\.do$|.+\\.jsp$|.+\\.html$");
		Matcher matcher = pattern.matcher(uri);
		boolean flag = matcher.matches();
		int index = login.indexOf(uri);
		System.out.println(login);
		if(index != -1) {
			chain.doFilter(req, resp);
			return;
		}
			
		if (flag) {
			if (user == null) {
				response.sendRedirect("/login");
				// System.out.println("login...");
				return;
			}
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setDateHeader("Expires", 0);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Prama", "no-cache");
			System.out.println("tiaozhuang");
			chain.doFilter(req, resp);
		} else {
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		login = config.getInitParameter("view");
	}

}
