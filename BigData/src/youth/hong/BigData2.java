package youth.hong;

import java.math.BigDecimal;

public class BigData2 {
	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("25.8");
		BigDecimal divisor = new BigDecimal("1");
		Double result = bigDecimal.divide(divisor, 0, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(result);
	}
}
