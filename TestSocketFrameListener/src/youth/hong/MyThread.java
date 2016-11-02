package youth.hong;

import java.awt.TextArea;
import java.awt.TextField;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MyThread implements Runnable {
	Socket s = null;
	TextField tf = null;
	TextArea ta = null;
	MyFrame mf = null;
	InputStream in = null;
	DataInputStream dis = null;
	public MyThread(Socket s, MyFrame mf) {
		this.s = s;
		this.mf = mf;
		this.tf = mf.tf;
		this.ta = mf.ta;
		try {
			in = s.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dis = new DataInputStream(in);
	}

	@Override
	/**
	 * 接收他人发过来的信息
	 */
	public void run() {
		
			try {
				while(true) {
					
					
					String str = dis.readUTF();
					ta.append(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					dis.close();
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}

}
