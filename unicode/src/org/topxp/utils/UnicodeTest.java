package org.topxp.utils;

import junit.framework.TestCase;

/**
 * @author Lee
 *
 */
public class UnicodeTest extends TestCase {
	public void testEncoding(){
		try {
			String str = "中文";
			byte[] bytes = str.getBytes("UTF-16");

			//4e:2d:65:87
			log(EncodingUtils.toHexString(bytes));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//"中文"的GBK编码是：d6:d0:ce:c4
	public void testEncoding2(){
		
		try {
			//正确的GBK编码的字节流
			byte[] bytes = new byte[]{(byte)0xd6,(byte)0xd0,(byte)0xce,(byte)0xc4};
			
			//指定了正确的编码之后，能够转换为正确的unicode编码的字符
			String unicodeChar = new String(bytes,"GBK");
			
			log(unicodeChar);
			
			log("在内存中的编码是："+EncodingUtils.toHexString(unicodeChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//"中文"的UTF-8编码是：e4:b8:ad:e6:96:87
	public void testEncoding3(){
		
		try {
			//正确的UTF-8编码的字节流
			byte[] bytes = new byte[]{(byte)0xe4,(byte)0xb8,(byte)0xad,(byte)0xe6,(byte)0x96,(byte)0x87};
			
			//指定了正确的编码之后，能够转换为正确的unicode编码的字符
			String unicodeChar = new String(bytes,"UTF-8");
			
			log(unicodeChar);
			
			log("在内存中的编码是："+EncodingUtils.toHexString(unicodeChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//"中文"的UTF-8编码是：e4:b8:ad:e6:96:87
	public void testEncoding4(){
		
		try {
			//正确的UTF-8编码的字节流
			byte[] bytes = new byte[]{(byte)0xe4,(byte)0xb8,(byte)0xad,(byte)0xe6,(byte)0x96,(byte)0x87};
			
			//指定了错误的编码，得到错误的字符
			String unicodeChar = new String(bytes,"GBK");
			log(EncodingUtils.toHexString(unicodeChar));
			
			//按原路返回
			byte[] nextbytes = unicodeChar.getBytes("GBK");
			log(EncodingUtils.toHexString(nextbytes));
			
			String nextChar = new String(nextbytes,"UTF-8");
			
			log(unicodeChar);
			log("在内存中的编码是："+EncodingUtils.toHexString(unicodeChar));
			
			log("nextChar ->");
			log(nextChar);
			log("在内存中的编码是："+EncodingUtils.toHexString(nextChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testEncoding5(){
		
		try {
			//String str = "联通";
			//正确的UTF-8编码的字节流
			byte[] bytes = new byte[]{(byte)0xe8,(byte)0x81,(byte)0x94,(byte)0xe9,(byte)0x80,(byte)0x9a};//str.getBytes("UTF-8"); 
			
			log(EncodingUtils.toHexString(bytes));
			
			//指定了错误的编码，得到错误的字符
			String unicodeChar = new String(bytes,"GBK");
			
			//按原路返回，不一定能够返回！！！
			byte[] nextbytes = unicodeChar.getBytes("GBK");
			log(EncodingUtils.toHexString(nextbytes));
			
			String nextChar = new String(nextbytes,"UTF-8");
			
			log(unicodeChar);
			log("在内存中的编码是："+EncodingUtils.toHexString(unicodeChar));
			log(unicodeChar.length()+"");
			
			log("nextChar ->");
			log(nextChar);
			log("在内存中的编码是："+EncodingUtils.toHexString(nextChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void log(String s){
		System.out.println(s);
	}
}
