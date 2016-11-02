package youth.hong.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QRCodeCreate {
	//���ַ�ʽ�Ĺ̶���ʽ
	private static final int width = 67 + 12 * (7 - 1);
	private static final int height = 67 + 12 * (7 - 1);
	private static final String format = "png";
	private static final String content = "���ү";
	
	public static void main(String[] args) throws Exception {
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('H');//�Ӵ�ȼ�
		qrcode.setQrcodeVersion(7);//version
		qrcode.setQrcodeEncodeMode('B');//N�������֣�A����a-Z��B���������ַ�
		BufferedImage bufferedImage = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.setBackground(Color.WHITE);
		graphics2D.setColor(Color.BLACK);
		graphics2D.clearRect(0, 0, width, height);
		byte[] contentByte = content.getBytes("utf-8");
		int pixoff = 2;//ƫ����
		//���ֻ�ܴ���ô��Ķ������Ѿ��ǳ�����
		if(contentByte.length > 0 && contentByte.length < 120) {
			boolean[][] s = qrcode.calQrcode(contentByte);
			for(int i = 0; i < s.length; i++){
				for(int j = 0; j < s.length; j++) {
					if(s[j][i]) {
						graphics2D.fillRect(j*3 + pixoff, i*3 + pixoff, 3, 3);
					}
				}
			}
			
		}
		
		graphics2D.dispose();
		bufferedImage.flush();
		ImageIO.write(bufferedImage, format, new File("D:/temp/img2.png"));
	}
}
