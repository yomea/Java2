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
	 * 使用JDK自带的base加密包
	 */
	public static void JDKBase64() {
		byte[] bytes = java.util.Base64.getEncoder().encode(src.getBytes());
		String baseStr = new String(bytes);
		System.out.println("JDKBase64加密:" + baseStr);
		bytes =  java.util.Base64.getDecoder().decode(baseStr.getBytes());
		System.out.println("JDKBase64解密:" + new String(bytes));
		
	}
	
	/**
	 * 使用apache的加密包
	 */
	public static void commonsCodeBase64() {
		byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		String baseStr = new String(bytes);
		System.out.println("commonsCodeBase64加密:" + baseStr);
		bytes = org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
		System.out.println("commonsCodeBase64解密:" + new String(bytes));
	}
	
	/**
	 * 使用bc包加解密
	 */
	public static void bcprovBase64One() {
		ByteArrayOutputStream pw = new ByteArrayOutputStream();
		Base64Encoder encoder = new Base64Encoder();
		try {
			encoder.encode(src.getBytes(), 0, src.getBytes().length, pw);
			String baseStr = pw.toString();
			System.out.println("bcprovBase64One加密:" + baseStr);
			pw.reset();
			encoder.decode(baseStr, pw);
			System.out.println("bcprovBase64One解密:" + pw.toString());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcprovBase64Two() {
		byte[] bytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		String baseStr = new String(bytes);
		System.out.println("bcprovBase64Two加密:" + baseStr);
		bytes = org.bouncycastle.util.encoders.Base64.decode(bytes);
		System.out.println("bcprovBase64Two解密:" + new String(bytes));
	}
	
}
