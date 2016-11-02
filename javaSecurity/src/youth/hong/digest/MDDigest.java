package youth.hong.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.digests.MD5Digest;

public class MDDigest {
	
	private static String src = "Beijing welcome you!";
	
	public static void main(String[] args) {
		ApacheMD5();
		JDKMD5();
		bcprovMD5();
		bcprovFixMD();
	}
	/**
	 * apache实现的md5算法
	 */
	public static void ApacheMD5() {
		byte[] md5Bytes = DigestUtils.getMd5Digest().digest(src.getBytes());
		String md5StrOne = Hex.encodeHexString(md5Bytes);
		System.out.println("ApacheMD5:"+ md5StrOne);
		String md5StrTwo = DigestUtils.md5Hex(src.getBytes());
		System.out.println("ApacheMD5:"+ md5StrTwo);
	}
	
	/**
	 * JDK实现的md5算法
	 */
	public static void JDKMD5() {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] bytes = messageDigest.digest(src.getBytes());
			String md5Str = Hex.encodeHexString(bytes);
			System.out.println("JDKMD5:" + md5Str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * bcprov实现的md5算法
	 */
	public static void bcprovMD5() {
		MD5Digest md5Digest = new MD5Digest();
		md5Digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] bytes = new byte[md5Digest.getDigestSize()];
		md5Digest.doFinal(bytes, 0);
		String md5Str = org.bouncycastle.util.encoders.Hex.toHexString(bytes);
		System.out.println("bcprovMD5:" + md5Str);
	}
	
	/**
	 * 使用jdkaddprovider方式添加实现，当然也可以使用添加配置文件的方式添加
	 */
	public static void bcprovFixMD() {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD4");
			byte[] bytes = messageDigest.digest(src.getBytes());
			String md4Str = Hex.encodeHexString(bytes);
			System.out.println("bcprovFixMD4:" + md4Str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
}
