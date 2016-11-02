package youth.hong;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
/**
 * ¼àÌýÆ÷
 * @author May
 *
 */
public class MyActionListener implements ActionListener {
	TextField tf = null;
	TextArea ta = null;
	MyFrame owner = null;
	Socket s = null;
	public MyActionListener(MyFrame myFrame) {
		tf = myFrame.tf;
		ta = myFrame.ta;
		owner = myFrame;
		try {
			s = new Socket("localhost",8888);
			MyThread mt = new MyThread(s,owner);
			Thread t = new Thread(mt);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//tf = (TextField) e.getSource();
		String str = tf.getText();
		
		ta.append(str + "\n");
		
		try {
			
			
			OutputStream out = s.getOutputStream();
			
			DataOutputStream  dos = new DataOutputStream(out);
			dos.writeUTF(str);
			tf.setText("");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
