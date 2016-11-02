package youth.hong;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ThumService2 {
	
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	
	public String createThumImage(CommonsMultipartFile file, String uploadPath, String realUploadPath) {
		
		try {
			String des = realUploadPath + "/thum_" + file.getOriginalFilename();
			Image image = ImageIO.read(file.getInputStream());
			int realWidth = image.getWidth(null);
			int realHeight = image.getHeight(null);
			BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			int rate1 = WIDTH / realWidth;
			int rate2 = HEIGHT / realHeight;
			int rate = 0;
			if(rate1 > rate2) {
				rate = rate1;
			} else {
				rate = rate2;
			}
			FileOutputStream fps = new FileOutputStream(realUploadPath + file.getOriginalFilename());
			int newWidth = realWidth * rate;
			int newHeight = realHeight * rate;
			image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			bi.getGraphics().drawImage(image, newWidth, newHeight, null);
			ImageIO.write(bi, file.getContentType().substring(file.getContentType().indexOf("/")+1), fps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uploadPath + "/thum_" + file.getOriginalFilename();
	}
}
