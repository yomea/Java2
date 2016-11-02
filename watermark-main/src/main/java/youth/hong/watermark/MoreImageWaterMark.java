package youth.hong.watermark;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class MoreImageWaterMark implements WaterMark {

	@Override
	public String watermark(File file, String uploadPath, String realUploadPath, String fileFileName,
			String fileContextType) {

		OutputStream out = null;
		File f = new File(realUploadPath + "/" + IMAGE_WATER);

		try {
			out = new FileOutputStream(realUploadPath + "/moreImage_" + fileFileName);
			Image image = ImageIO.read(file);
			Image imageWater = ImageIO.read(f);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bi.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));

			//倾斜画布，以画布的中心点倾斜30°
			g.rotate(Math.toRadians(30), bi.getWidth() / 2, bi.getHeight() / 2);
			
			int imageWidth = imageWater.getWidth(null);
			int imageHeight = imageWater.getHeight(null);
			
			
			int x = -width / 2;
			while(x < width * 2) {
				
				
				int y = -height / 2;
				
				while(y < height * 2) {
					g.drawImage(imageWater, x, y, null);
					
					y += 100 + imageHeight;
				}
				
				x = x + 100 + imageWidth;
			}
			

			g.dispose();

			ImageIO.write(bi, fileFileName.substring(fileFileName.indexOf('.') + 1), out);

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

		return uploadPath + "/moreImage_" + fileFileName;
	}

}
