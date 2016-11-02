import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestForm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println(request.getParameter("param1") + "<br />");
		pw.println(request.getParameter("param2"));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println(request.getParameter("param1") + "<br />");
		pw.println(request.getParameter("param2"));*/
		doGet(request,response);
	}
	
}
