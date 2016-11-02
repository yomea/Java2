package youth.hong.watermark;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class UploadService {

	public String upload(CommonsMultipartFile file, String uploadPath, String realUploadPath) {

		InputStream in = null;

		OutputStream out = null;

		try {
			in = file.getInputStream();
			out = new FileOutputStream(realUploadPath + "/" + file.getOriginalFilename());
			byte[] buff = new byte[1024];

			while ((in.read(buff)) > 0) {
				out.write(buff);
			}

		} catch (Exception e) {
			System.out.println("����Ĳ����޷���ʹ���û�ӳ������򿪵��ļ���ִ�С�");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return uploadPath + "/" + file.getOriginalFilename();
	}

}
