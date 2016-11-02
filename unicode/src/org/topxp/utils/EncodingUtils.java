package org.topxp.utils;

/**
 * 编码测试工具类
 * @author <a href='mailto:tengfei.lee@gmail.com'>Kenny Lee</a>
 * <br/>2006-8-1 15:28:05
 */
public class EncodingUtils {
	final static char[] digits = {
		'0' , '1' , '2' , '3' , '4' , '5' ,
		'6' , '7' , '8' , '9' , 'a' , 'b' ,
		'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
		'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
		'o' , 'p' , 'q' , 'r' , 's' , 't' ,
		'u' , 'v' , 'w' , 'x' , 'y' , 'z'
	    };
	
	/**
	 * 返回一个int值的二进制表示的字符串
	 * @param i
	 * @return
	 */
	public static String toBinaryString(int i){
		return toUnsignedString(i,32,1);
	}
	
	/**
	 * 返回一个char值的二进制表示的字符串
	 * @param c
	 * @return
	 */
	public static String toBinaryString(char c){
		return toUnsignedString(c,16,1);
	}
	
	/**
	 * 返回一个字符串的二进制表示的字符串
	 * @param s
	 * @return
	 */
	public static String toBinaryString(String s){
		char[] cs = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<cs.length; i++){
			sb.append(toBinaryString(cs[i]));
			sb.append(":");
		}
		return sb.toString();
	}
	
	/**
	 * 返回一个byte[]的二进制表示的字符串
	 * @param bs
	 * @return
	 */
	public static String toBinaryString(byte[] bs){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<bs.length; i++){
			sb.append(toBinaryString(bs[i]));
			sb.append(":");
		}
		return sb.toString();
	}
	
	/**
	 * 返回一个byte的二进制表示的字符串
	 * @param c
	 * @return
	 */
	public static String toBinaryString(byte c){
		return toUnsignedString(c,8,1);
	}
	
	/**
	 * 返回一个int的十六进制表示的字符串
	 * @param i
	 * @return
	 */
	public static String toHexString(int i){
		return toUnsignedString(i,8,4);
	}
	
	/**
	 * 返回一个char的十六进制表示的字符串
	 * @param c
	 * @return
	 */
	public static String toHexString(char c){
		return toUnsignedString(c,4,4);
	}
	
	/**
	 * 返回一个byte的十六进制表示的字符串
	 * @param b
	 * @return
	 */
	public static String toHexString(byte b){
		return toUnsignedString(b,2,4);
	}
	
	/**
	 * 返回一个String的十六进制表示的字符串
	 * @param s
	 * @return
	 */
	public static String toHexString(String s){
		char[] cs = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<cs.length; i++){
			sb.append(toHexString(cs[i]));
			sb.append(":");
		}
		return sb.toString();
	}
	
	/**
	 * 返回一个byte[]的十六进制表示的字符串
	 * @param bs
	 * @return
	 */
	public static String toHexString(byte[] bs){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<bs.length; i++){
			sb.append(toHexString(bs[i]));
			sb.append(":");
		}
		return sb.toString();
	}

	private static String toUnsignedString(int i,int length,int shift){
		char[] buf = new char[32];
		for(int j=0; j<32; j++){
			buf[j] = '0';
		}
		int charPos = 32;
		int radix = 1 << shift;
		int mask = radix - 1;
		do {
		    buf[--charPos] = digits[i & mask];
		    i >>>= shift;
		} while (i != 0);
		
		return new String(buf,32-length,length);
	}
}
