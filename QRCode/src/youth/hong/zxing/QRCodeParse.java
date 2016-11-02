package youth.hong.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeParse {
	
	public static void main(String[] args) {
		Map<DecodeHintType, Object> hint = new HashMap<DecodeHintType, Object>();
		hint.put(DecodeHintType.CHARACTER_SET, "utf-8");
		MultiFormatReader multiFormatReader = new MultiFormatReader();
		BufferedImage image;
		try {
			image = ImageIO.read(new File("D:/temp/QRCode.png"));
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			Result result = multiFormatReader.decode(binaryBitmap, hint);
			System.out.println("解析二维码后的信息：");
			System.out.println("二维码后的格式：" + result.getBarcodeFormat());
			System.out.println("二维码后的：" + result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
