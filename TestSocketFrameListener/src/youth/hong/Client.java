package youth.hong;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
/**
 * 
 * @author May
 *
 */
public class Client implements Runnable {
	Socket socket = null;
	InputStream in = null;
	OutputStream out = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	String str = null;
	TCPSocket tcpSocket = null;
	public Client(Socket socket) {
		this.socket = socket;
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			System.out.println(dos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Client(Socket s, TCPSocket tcpSocket) {
		this(s);
		this.tcpSocket = tcpSocket;
	}
	/**
	 * 遍历当前在线用户，将信息发给除自身外的其他用户
	 * @param clients
	 */
	public void send(List<Client> clients) {
		for (Client client : clients) {
			if(this != client) {
				
				//System.out.println(client);
				client.send(str);
			}
		}
	}

	public void send(String str) {
		try {
			dos.writeUTF("other:" + str + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		
			try {
				while(true) {
					
					str = dis.readUTF();
					System.out.println(str);
					send(tcpSocket.getClients());
					//System.out.println("sdg");
				}
			} catch (SocketException e) {
				tcpSocket.getClients().remove(this);
				str = "对方已离线";
				this.send(tcpSocket.getClients());;
				System.out.println("离线");
			} catch (IOException e) {
				e.printStackTrace();
			}  finally {
				try {
					dos.close();
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		
	}

 

}