package youth.hong;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class BatchDownload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] fileNames = req.getParameterValues("fileName");
		
		String filePath = "D:/temp/";
		
		
		
		resp.setContentType("application/x-msdownload");
		resp.addHeader("Content-Disposition", "attachment; filename=\"hello.zip\"");
		
		ZipOutputStream zip = new ZipOutputStream(resp.getOutputStream());
		
		for (String fileName : fileNames) {
			File file = new File(filePath + fileName);
			//用于区分单个文件
			ZipEntry zipEntry = new ZipEntry(fileName);
			zip.putNextEntry(zipEntry);
			
			FileInputStream read = new FileInputStream(file);
			byte[] buff = new byte[1024];
			
			while((read.read(buff)) != -1) {
				zip.write(buff);
			}
			
			zip.flush();
			zip.setComment("下载的项目：" + fileName +"\r\n" );
			read.close();
		}
		
		
		zip.closeEntry();
		zip.close();
		
		
	}

	
	
}
