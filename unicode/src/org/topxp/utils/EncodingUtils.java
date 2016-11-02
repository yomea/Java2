package org.topxp.utils;

/**
 * ������Թ�����
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
	 * ����һ��intֵ�Ķ����Ʊ�ʾ���ַ���
	 * @param i
	 * @return
	 */
	public static String toBinaryString(int i){
		return toUnsignedString(i,32,1);
	}
	
	/**
	 * ����һ��charֵ�Ķ����Ʊ�ʾ���ַ���
	 * @param c
	 * @return
	 */
	public static String toBinaryString(char c){
		return toUnsignedString(c,16,1);
	}
	
	/**
	 * ����һ���ַ����Ķ����Ʊ�ʾ���ַ���
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
	 * ����һ��byte[]�Ķ����Ʊ�ʾ���ַ���
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
	 * ����һ��byte�Ķ����Ʊ�ʾ���ַ���
	 * @param c
	 * @return
	 */
	public static String toBinaryString(byte c){
		return toUnsignedString(c,8,1);
	}
	
	/**
	 * ����һ��int��ʮ�����Ʊ�ʾ���ַ���
	 * @param i
	 * @return
	 */
	public static String toHexString(int i){
		return toUnsignedString(i,8,4);
	}
	
	/**
	 * ����һ��char��ʮ�����Ʊ�ʾ���ַ���
	 * @param c
	 * @return
	 */
	public static String toHexString(char c){
		return toUnsignedString(c,4,4);
	}
	
	/**
	 * ����һ��byte��ʮ�����Ʊ�ʾ���ַ���
	 * @param b
	 * @return
	 */
	public static String toHexString(byte b){
		return toUnsignedString(b,2,4);
	}
	
	/**
	 * ����һ��String��ʮ�����Ʊ�ʾ���ַ���
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
	 * ����һ��byte[]��ʮ�����Ʊ�ʾ���ַ���
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
