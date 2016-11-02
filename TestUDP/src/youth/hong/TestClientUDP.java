package youth.hong;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class TestClientUDP {
	public static void main(String[] args) {
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bis);
		DatagramPacket dp = null;
		DatagramSocket ds = null;
		Scanner in = new Scanner(System.in);
		try {
			ds = new DatagramSocket(999);
			while(true) {
				String str = in.next();
				if(str != null && str.equals("exit")) {
					break;
				}
				
				dos.writeUTF(str);
				byte[] buf = bis.toByteArray();
				dp = new DatagramPacket(buf, buf.length,new InetSocketAddress("127.0.01",8888));
				
				ds.send(dp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
}
