package youth.hong.watermark;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class FontWaterMark implements WaterMark {

	@Override
	public String watermark(File file, String uploadPath, String realUploadPath, String fileFileName,
			String fileContextType) {

		OutputStream out = null;

		try {
			out = new FileOutputStream(realUploadPath + "/font_" + fileFileName);
			Image image = ImageIO.read(file);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bi.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			g.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
			g.setColor(FONT_COLOR);
			int textWidth = this.getTextLength(MARK_TEXT);
			int textHeight = FONT_SIZE;
			int widthOff = width - textWidth;
			int heightOff = height - textHeight;
			int x = X;
			int y = Y;

			if (x > widthOff) {
				x = widthOff;
			}

			if (y > heightOff) {
				y = heightOff;
			}
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));

			g.drawString(MARK_TEXT, x, y + FONT_SIZE);

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

		return uploadPath + "/font_" + fileFileName;
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
