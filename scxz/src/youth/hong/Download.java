package youth.hong;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Download extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("fileName");
		String path = "D:/" + fileName;
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
		byte[] buff = new byte[inputStream.available()];
		OutputStream outputStream = resp.getOutputStream();
		resp.setContentType("application/x-msdownload");
		resp.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		inputStream.read(buff);
		outputStream.write(buff);
		inputStream.close();
		outputStream.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
}
