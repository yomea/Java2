package youth.hong.watermark;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class MoreFontWaterMark implements WaterMark {

	@Override
	public String watermark(CommonsMultipartFile file, String uploadPath, String realUploadPath) {

		OutputStream out = null;

		try {
			out = new FileOutputStream(realUploadPath + "/font_" + file.getOriginalFilename());
			Image image = ImageIO.read(file.getInputStream());
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bi.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			g.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
			g.setColor(FONT_COLOR);
			
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));

			//倾斜画布，以画布的中心点倾斜30°
			g.rotate(Math.toRadians(30), bi.getWidth() / 2, bi.getHeight() / 2);
			
			int textWidth = this.getTextLength(MARK_TEXT);
			
			int x = -width / 2;
			while(x < width * 2) {
				
				
				int y = -height / 2;
				
				while(y < height * 2) {
					g.drawString(MARK_TEXT, x, y);
					
					y += 100;
				}
				
				x = x + 100 + textWidth;
			}
			

			g.dispose();

			ImageIO.write(bi, file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.') + 1), out);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return uploadPath + "/font_" + file.getOriginalFilename();
	}

	public int getTextLength(String text) {
		int length = 0;
		// 存储文字的像素长度
		int pixValue = 0;
		for (int i = 0; i < text.length(); i++) {

			length = String.valueOf(text.getBytes()).length();

			if (length > 1) {
				pixValue += FONT_SIZE;
			} else {
				pixValue += FONT_SIZE / 2;
			}
		}

		return pixValue;
	}


}
