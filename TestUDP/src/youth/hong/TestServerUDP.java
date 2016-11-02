package youth.hong;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestServerUDP {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			ByteArrayInputStream bis = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bis);
			dp.getLength();
			ds = new DatagramSocket(8888);
			while(true) {
				ds.receive(dp);
				System.out.println(dis.readUTF());
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ds != null) {
				ds.close();
				ds = null;
			}
		}
	}
}
