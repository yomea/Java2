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
			//׼���ϴ�
			smartUpload.upload();
			//�ϴ��������ϴ��ɹ��ĸ���
			smartUpload.save(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Files files = smartUpload.getFiles();
		
		for(int i = 0; i < files.getCount(); i++) {
			System.out.println("-------------------------");
			System.out.println("���е��ֶ�����" + files.getFile(i).getFieldName());
			System.out.println("�ļ�����" + files.getFile(i).getFileName());
			System.out.println("�ļ�·������" + files.getFile(i).getFilePathName());
			System.out.println("�ļ��Ĵ�С��" + files.getFile(i).getSize());
			System.out.println("-------------------------");
		}
	
		
	}

	
	
}
