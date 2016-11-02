package youth.hong.watermark;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadService {

	public String upload(File file, String uploadPath, String realUploadPath, String fileFileName,
			String fileContextType) {

		InputStream in = null;

		OutputStream out = null;

		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(realUploadPath + "/" + fileFileName);
			byte[] buff = new byte[1024];

			while ((in.read(buff)) > 0) {
				out.write(buff);
			}

		} catch (Exception e) {
			System.out.println("请求的操作无法在使用用户映射区域打开的文件上执行。");
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

		return uploadPath + "/" + fileFileName;
	}

}
