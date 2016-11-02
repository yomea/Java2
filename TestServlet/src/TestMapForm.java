import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestMapForm extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String title = "response html form";
		pw.println("<html>\n<head>\n<title>" + title
				+ "</title>\n<style type='text/css'>caption{border:2px solid #0c3}</style></head>\n<body>\n"
				+ "<table border=1 align=center style='text-align:center;width:600px;'>\n");
		pw.println("<caption>hello</caption>\n");

		Map<String, String[]> mp = request.getParameterMap();
		Set<String> st = mp.keySet();
		Iterator<String> it = st.iterator();
		String[] s = null;
		String name = "";
		while (it.hasNext()) {
			name = it.next();
			if (name.equalsIgnoreCase("submit")) {
				continue;
			}
			s = mp.get(name);
			if ((s.length == 1)) {
				pw.println("<tr>\n<td>" + name + "</td>\n");
				if (s[0].trim().equals("")) {
					pw.println("<td>null</td>\n</tr>");
				} else {
					pw.println("<td>" + s[0].trim() + "</td>\n</tr>");
				}
			} else {
				pw.println("<tr>\n<td>" + name + "</td>\n<td>");
				for (String string : s) {
					pw.println(string.trim() + "<br />");
				}
				pw.println("</td></tr>\n");
			}
		}
		pw.println("</table></body>\n</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String title = "response html form";
		pw.println("<html>\n<head>\n<title>" + title
				+ "</title>\n<style type='text/css'>caption{border:2px solid #0c3}</style></head>\n<body>\n"
				+ "<table border=1 align=center style='text-align:center;width:600px;'>\n");
		pw.println("<caption>hello</caption>\n");

		Map<String, String[]> mp = request.getParameterMap();
		Set<String> st = mp.keySet();
		Iterator<String> it = st.iterator();
		String[] s = null;
		String name = "";
		while (it.hasNext()) {
			name = it.next();
			if (name.equalsIgnoreCase("submit")) {
				continue;
			}
			s = mp.get(name);
			if ((s.length == 1)) {
				pw.println("<tr>\n<td>" + name + "</td>\n");
				if (s[0].trim().equals("")) {
					pw.println("<td>null</td>\n</tr>");
				} else {
					pw.println("<td>" + s[0].trim() + "</td>\n</tr>");
				}
			} else {
				pw.println("<tr>\n<td>" + name + "</td>\n<td>");
				for (String string : s) {
					pw.println(string.trim() + "<br />");
				}
				pw.println("</td></tr>\n");
			}
		}
		pw.println("</table></body>\n</html>");
	}

}
