package youth.hong;

public class HTMLDecoder {
	public static String decode(String data) {
		String[] str = data.split(";&#|&#|;");
		String returnStr = "";
		for(int i = 0; i < str.length; i++) {
			if(str[i].matches("\\d{5}")) {
				returnStr += (char)Integer.parseInt(str[i]);
			} else {
				returnStr += str[i];
			}
		}
		return returnStr;
		
	}
}
