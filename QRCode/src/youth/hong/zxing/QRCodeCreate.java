package youth.hong.zxing;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeCreate {
	private static final int width = 300;
	private static final int height = 300;
	private static final int imageWidth = 50;
	private static final int imageHeight = 50;
	private static final String format = "png";
	// 一个名片
	private static final String content = "BEGIN:VCARD" + "\n"
		+	"N:振宏;吴" + "\n"
		+	"TEL:+86 12345678911" + "\n"
		+	"EMAIL:953454643@qq.com" + "\n"
		+	"URL:www.yomea.win" + "\n"
		+	"END:VCARD";

	public static void main(String[] args) {
		Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>();
		hint.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hint.put(EncodeHintType.MARGIN, 2);

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hint);
			// Path file = new File("D:/temp/QRCode.png").toPath();
			// MatrixToImageWriter.writeToPath(bitMatrix, format,
			// file);//直接生成二维码
			// 生成image实例
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
			// 创建一个彩色的空白image
			BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			// 注意不要直接使用bufferedImage.createGraphics();
			// 否侧拿到的是黑白的画笔，画上去的图片会变成黑白的
			Graphics2D g = newImage.createGraphics();
			// 读取需要添加上去的图片
			BufferedImage image = ImageIO.read(new File("D:\\temp\\warAreaBak.jpg"));
			g.drawImage(bufferedImage, 0, 0, width, height, null);
			// 旋转四十五度
			g.rotate(Math.toRadians(45), width / 2, height / 2);
			// 由于二维码有很强的接错能力，所以可以在上面添加小图片
			g.drawImage(image, (width - imageWidth) / 2, (height - imageHeight) / 2, imageWidth, imageHeight, null);
			ImageIO.write(newImage, format, new File("D:\\temp\\img.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
