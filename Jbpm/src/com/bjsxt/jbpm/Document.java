package com.bjsxt.jbpm;

/**
 * ����Ҫ�����Ĺ���document
 * @author May
 *
 */
public class Document {
	private int id;
	private String title;
	private String content;
	private String creator;
	//������ʵ��
	private Long processIntanceId;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getProcessIntanceId() {
		return processIntanceId;
	}
	public void setProcessIntanceId(Long processIntanceId) {
		this.processIntanceId = processIntanceId;
	}
}
