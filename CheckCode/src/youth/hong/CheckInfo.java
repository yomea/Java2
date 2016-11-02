package youth.hong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = (String)request.getSession().getAttribute("checkCode");
		String userCode = request.getParameter("userCode");
		System.out.println(code);
		System.out.println(userCode);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(code != null && userCode != null && code.equalsIgnoreCase(userCode)) {
			
			out.println("<html><body><h1>验证成功！</h1></body></html>");
			
		}
		else {
			out.println("<html><body><h1>验证失败！</h1></body></html>");
		}
	}
	
}
