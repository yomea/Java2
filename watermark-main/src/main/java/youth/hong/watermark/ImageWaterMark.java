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

public class ImageWaterMark implements WaterMark {

	@Override
	public String watermark(File file, String uploadPath, String realUploadPath, String fileFileName,
			String fileContextType) {

		OutputStream out = null;
		File f = new File(realUploadPath + "/" + IMAGE_WATER);
		
		System.out.println(f);

		try {
			out = new FileOutputStream(realUploadPath + "/image_" + fileFileName);
			Image image = ImageIO.read(file);
			Image imageWater = ImageIO.read(f);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bi.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			
			int imageWidth = imageWater.getWidth(null);
			int imageHeight = imageWater.getHeight(null);
			int widthOff = width - imageWidth;
			int heightOff = height - imageHeight;
			int x = X;
			int y = Y;

			if (x > widthOff) {
				x = widthOff;
			}

			if (y > heightOff) {
				y = heightOff;
			}
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.7f));

			g.drawImage(imageWater, x, y, null);

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

		return uploadPath + "/image_" + fileFileName;
	}

	

}
