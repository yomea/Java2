package youth.hong;

import java.math.BigInteger;

public class BigData {
	public static void main(String[] args) {
		BigInteger bigIntegerA = new BigInteger("5562562659875745235467689234546239289");
		BigInteger bigIntegerB = new BigInteger("7452453278674274527452453745824");
		System.out.println(bigIntegerA.subtract(bigIntegerB));
	}
}
