import java.io.IOException;

import javax.security.auth.login.Configuration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspToServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	/*@Override
	public void init(ServletConfig config) throws ServletException {
		config.getInitParameter(arg0)
	}*/



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletConfig().getServletContext().getRequestDispatcher("/servlet/ServletUseJsp.jsp").forward(request, response);
	}
	
	
	
}
