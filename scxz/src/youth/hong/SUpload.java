package youth.hong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

@SuppressWarnings("serial")
public class SUpload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(this.getServletConfig() , req, resp);
		String filePath = "D:/temp";
		smartUpload.setMaxFileSize(1024*1024*10);
		smartUpload.setTotalMaxFileSize(1024*1024*30);
		smartUpload.setAllowedFilesList("txt,jpg,jpeg,gif");
		try {
			//smartUpload.setDeniedFilesList("exe");
			//准备上传
			smartUpload.upload();
			//上传并返回上传成功的个数
			smartUpload.save(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Files files = smartUpload.getFiles();
		
		for(int i = 0; i < files.getCount(); i++) {
			System.out.println("-------------------------");
			System.out.println("表单中的字段名：" + files.getFile(i).getFieldName());
			System.out.println("文件名：" + files.getFile(i).getFileName());
			System.out.println("文件路径名：" + files.getFile(i).getFilePathName());
			System.out.println("文件的大小：" + files.getFile(i).getSize());
			System.out.println("-------------------------");
		}
	
		
	}

	
	
}
