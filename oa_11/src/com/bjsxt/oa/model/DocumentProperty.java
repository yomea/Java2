package com.bjsxt.oa.model;

public class DocumentProperty {
	
	/**
	 * @hibernate.property
	 */
	private String java_lang_String;
	
	/**
	 * @hibernate.property
	 */
	private Integer java_lang_Integer;
	
	/**
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] java_io_File;
	
	public byte[] getJava_io_File() {
		return java_io_File;
	}
	public void setJava_io_File(byte[] java_io_File) {
		this.java_io_File = java_io_File;
	}
	public Integer getJava_lang_Integer() {
		return java_lang_Integer;
	}
	public void setJava_lang_Integer(Integer java_lang_Integer) {
		this.java_lang_Integer = java_lang_Integer;
	}
	public String getJava_lang_String() {
		return java_lang_String;
	}
	public void setJava_lang_String(String java_lang_String) {
		this.java_lang_String = java_lang_String;
	}
}
