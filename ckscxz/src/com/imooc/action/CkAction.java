package com.imooc.action;

import com.opensymphony.xwork2.ActionSupport;

public class CkAction extends ActionSupport {

	private String editor;

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("富文本信息：" + editor);
//		<p><a href="/ckscxz/userfiles/files/1421332943720.txt"><span style="font-size:36px">附件</span></a></p>
		int beginIndex = editor.indexOf("<a");
		while(beginIndex != -1){
			int endIndex = editor.indexOf(">",beginIndex) + 1;
			String beginStr = editor.substring(0,beginIndex);
			String endStr = editor.substring(endIndex);
			String str = editor.substring(beginIndex, endIndex);
			String filename = str.substring(str.lastIndexOf("/")+1, str.lastIndexOf("\""));
			String replace = "<a href=download.action?filename=" + filename + " /a>";
			editor = beginStr + replace + endStr;
			beginIndex = editor.indexOf("<a",endIndex);
		}
		
		
		
		return SUCCESS;
	}
}
