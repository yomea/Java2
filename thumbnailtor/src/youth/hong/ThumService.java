package youth.hong;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ThumService {
	
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	
	public String createThumImage(CommonsMultipartFile file, String uploadPath, String realUploadPath) {
		
		try {
			String des = realUploadPath + "/thum_" + file.getOriginalFilename();
			Thumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(des);
			//强制变成100像素的宽
			//Thumbnails.of(file.getInputStream()).keepAThumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(des);spectRatio(false).size(WIDTH, HEIGHT).toFile(des);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uploadPath + "/thum_" + file.getOriginalFilename();
	}
}
