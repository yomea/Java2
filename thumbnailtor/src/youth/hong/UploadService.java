package youth.hong;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class UploadService {
	public String uploadImage(CommonsMultipartFile file, String uploadPath, String realUploadPath) {
		InputStream in = null;
		
		OutputStream out = null;
		
		try {
			File f = new File(realUploadPath + "/" + file.getOriginalFilename());
			file.transferTo(f);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return uploadPath + "/" + file.getOriginalFilename();
	}
}
