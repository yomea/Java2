package youth.hong.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SHADigest {
	
	private static String src = "Beijing welcome you!";
	
	public static void main(String[] args) {
		JDKSHA1();
		JDKSHA224();
		commonsCodecSHA1();
		bcprovSHA1();
		provider();
	}
	
	/**
	 * JDK实现的SHA-1散列算法
	 */
	public static void JDKSHA1() {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			byte[] bytes = messageDigest.digest(src.getBytes());
			messageDigest.update(bytes);
			String shaStr = Hex.encodeHexString(bytes);
			System.out.println("JDKSHA1:" + shaStr);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void JDKSHA224() {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-224");
			byte[] bytes = messageDigest.digest(src.getBytes());
			messageDigest.update(bytes);
			String shaStr = Hex.encodeHexString(bytes);
			System.out.println("JDKSHA224:" + shaStr);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void commonsCodecSHA1() {
		//String sha1Str = DigestUtils.sha1(src.getBytes());
		MessageDigest messageDigest = DigestUtils.getSha1Digest();
		byte[] bytes = messageDigest.digest(src.getBytes());
		String shaStr = Hex.encodeHexString(bytes);
		System.out.println("commonsCodecSHA1:" + shaStr);
		
	}
	
	public static void bcprovSHA1() {
		SHA1Digest sha1Digest = new SHA1Digest();
		sha1Digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] bytes = new byte[sha1Digest.getDigestSize()];
		sha1Digest.doFinal(bytes, 0);
		System.out.println("bcprovSHA1:" + org.bouncycastle.util.encoders.Hex.toHexString(bytes));
	}
	
	public static void provider() {
		Security.addProvider(new BouncyCastleProvider());
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA224");
			byte[] bytes = messageDigest.digest(src.getBytes());
			System.out.println("provider:" + org.bouncycastle.util.encoders.Hex.toHexString(bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
}
