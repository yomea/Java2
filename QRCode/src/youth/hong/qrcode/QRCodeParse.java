package youth.hong.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class QRCodeParse {
	public static void main(String[] args) throws Exception {
		File file = new File("D:/temp/img2.png");
		BufferedImage bufferedImage = ImageIO.read(file);
		QRCodeDecoder decoder = new QRCodeDecoder();
		String result = new String(decoder.decode(new QRCodeImageImpl(bufferedImage)), "utf-8");
		System.out.println(result);
	}
}
