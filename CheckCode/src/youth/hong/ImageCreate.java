package youth.hong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageCreate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c = g.getColor();
		g.setColor(new Color(200,100,246));
		g.fillRect(0, 0, 68, 22);
		char[] ch = "ABCDEFGHIJKLMN0123456789".toCharArray();
		int chLength = ch.length;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		for(int i = 0; i < 4; i++) {
			index = rd.nextInt(chLength);
			g.setColor(new Color(rd.nextInt(88),rd.nextInt(200),rd.nextInt(255)));
			g.drawString(ch[index]+"", i*15+3, 18);
			sb.append(ch[index]);
		}
		g.setColor(c);
		request.getSession().setAttribute("checkCode", sb.toString());
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}
	
}
