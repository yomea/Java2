package org.topxp.utils;

import junit.framework.TestCase;

/**
 * @author Lee
 *
 */
public class UnicodeTest extends TestCase {
	public void testEncoding(){
		try {
			String str = "����";
			byte[] bytes = str.getBytes("UTF-16");

			//4e:2d:65:87
			log(EncodingUtils.toHexString(bytes));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//"����"��GBK�����ǣ�d6:d0:ce:c4
	public void testEncoding2(){
		
		try {
			//��ȷ��GBK������ֽ���
			byte[] bytes = new byte[]{(byte)0xd6,(byte)0xd0,(byte)0xce,(byte)0xc4};
			
			//ָ������ȷ�ı���֮���ܹ�ת��Ϊ��ȷ��unicode������ַ�
			String unicodeChar = new String(bytes,"GBK");
			
			log(unicodeChar);
			
			log("���ڴ��еı����ǣ�"+EncodingUtils.toHexString(unicodeChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//"����"��UTF-8�����ǣ�e4:b8:ad:e6:96:87
	public void testEncoding3(){
		
		try {
			//��ȷ��UTF-8������ֽ���
			byte[] bytes = new byte[]{(byte)0xe4,(byte)0xb8,(byte)0xad,(byte)0xe6,(byte)0x96,(byte)0x87};
			
			//ָ������ȷ�ı���֮���ܹ�ת��Ϊ��ȷ��unicode������ַ�
			String unicodeChar = new String(bytes,"UTF-8");
			
			log(unicodeChar);
			
			log("���ڴ��еı����ǣ�"+EncodingUtils.toHexString(unicodeChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//"����"��UTF-8�����ǣ�e4:b8:ad:e6:96:87
	public void testEncoding4(){
		
		try {
			//��ȷ��UTF-8������ֽ���
			byte[] bytes = new byte[]{(byte)0xe4,(byte)0xb8,(byte)0xad,(byte)0xe6,(byte)0x96,(byte)0x87};
			
			//ָ���˴���ı��룬�õ�������ַ�
			String unicodeChar = new String(bytes,"GBK");
			log(EncodingUtils.toHexString(unicodeChar));
			
			//��ԭ·����
			byte[] nextbytes = unicodeChar.getBytes("GBK");
			log(EncodingUtils.toHexString(nextbytes));
			
			String nextChar = new String(nextbytes,"UTF-8");
			
			log(unicodeChar);
			log("���ڴ��еı����ǣ�"+EncodingUtils.toHexString(unicodeChar));
			
			log("nextChar ->");
			log(nextChar);
			log("���ڴ��еı����ǣ�"+EncodingUtils.toHexString(nextChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testEncoding5(){
		
		try {
			//String str = "��ͨ";
			//��ȷ��UTF-8������ֽ���
			byte[] bytes = new byte[]{(byte)0xe8,(byte)0x81,(byte)0x94,(byte)0xe9,(byte)0x80,(byte)0x9a};//str.getBytes("UTF-8"); 
			
			log(EncodingUtils.toHexString(bytes));
			
			//ָ���˴���ı��룬�õ�������ַ�
			String unicodeChar = new String(bytes,"GBK");
			
			//��ԭ·���أ���һ���ܹ����أ�����
			byte[] nextbytes = unicodeChar.getBytes("GBK");
			log(EncodingUtils.toHexString(nextbytes));
			
			String nextChar = new String(nextbytes,"UTF-8");
			
			log(unicodeChar);
			log("���ڴ��еı����ǣ�"+EncodingUtils.toHexString(unicodeChar));
			log(unicodeChar.length()+"");
			
			log("nextChar ->");
			log(nextChar);
			log("���ڴ��еı����ǣ�"+EncodingUtils.toHexString(nextChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void log(String s){
		System.out.println(s);
	}
}
