package youth.hong.digest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class HmacMD5Digest {

	private static String src = "Beijing welcome you!";

	public static void main(String[] args) {
		JDKhmacMD5();
		bcprovHmacMD5();
	}

	public static void JDKhmacMD5() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytes = secretKey.getEncoded();
			SecretKey restoreSecretKey = new SecretKeySpec(bytes, "HmacMD5");
			Mac mac = Mac.getInstance("HmacMD5");
			mac.init(restoreSecretKey);
			mac.update(src.getBytes());
			byte[] key = mac.doFinal();
			System.out.println("JDKhmacMD5:" + Hex.encodeHexString(key));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void bcprovHmacMD5() {
			HMac hMac = new HMac(new MD5Digest());
			hMac.update(src.getBytes(),0,src.getBytes().length);
			byte[] bytes = new byte[hMac.getMacSize()];
			hMac.doFinal(bytes, 0);
			System.out.println("bcprovHmacMD5:" + org.bouncycastle.util.encoders.Hex.toHexString(bytes));
			
	}

}
