package youth.hong.base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.bouncycastle.util.encoders.Base64Encoder;

public class Base64 {
	
	private static String src = "imooc security base64";
	
	public static void main(String[] args) {
		JDKBase64();
		commonsCodeBase64();
		bcprovBase64One();
		bcprovBase64Two();
	}
	
	/**
	 * ʹ��JDK�Դ���base���ܰ�
	 */
	public static void JDKBase64() {
		byte[] bytes = java.util.Base64.getEncoder().encode(src.getBytes());
		String baseStr = new String(bytes);
		System.out.println("JDKBase64����:" + baseStr);
		bytes =  java.util.Base64.getDecoder().decode(baseStr.getBytes());
		System.out.println("JDKBase64����:" + new String(bytes));
		
	}
	
	/**
	 * ʹ��apache�ļ��ܰ�
	 */
	public static void commonsCodeBase64() {
		byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		String baseStr = new String(bytes);
		System.out.println("commonsCodeBase64����:" + baseStr);
		bytes = org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
		System.out.println("commonsCodeBase64����:" + new String(bytes));
	}
	
	/**
	 * ʹ��bc���ӽ���
	 */
	public static void bcprovBase64One() {
		ByteArrayOutputStream pw = new ByteArrayOutputStream();
		Base64Encoder encoder = new Base64Encoder();
		try {
			encoder.encode(src.getBytes(), 0, src.getBytes().length, pw);
			String baseStr = pw.toString();
			System.out.println("bcprovBase64One����:" + baseStr);
			pw.reset();
			encoder.decode(baseStr, pw);
			System.out.println("bcprovBase64One����:" + pw.toString());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcprovBase64Two() {
		byte[] bytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		String baseStr = new String(bytes);
		System.out.println("bcprovBase64Two����:" + baseStr);
		bytes = org.bouncycastle.util.encoders.Base64.decode(bytes);
		System.out.println("bcprovBase64Two����:" + new String(bytes));
	}
	
}
