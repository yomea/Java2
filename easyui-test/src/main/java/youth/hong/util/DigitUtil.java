package youth.hong.util;

public class DigitUtil {

	public static boolean isDigit(String string) {

		boolean flag = true;
		int count = 0;
		if (string != null) {
			for (int i = 0; i < string.length(); i++) {
				char validate = string.charAt(i);
				if (validate <= '0' || validate >= '9') {
					flag = false;
				}
				if (validate == '.') {
					if (count == 0) {
						flag = true;
					} else {
						flag = false;
					}
					count++;
				}

			}

		} else {
			flag = false;
		}

		return flag;

	}

}
