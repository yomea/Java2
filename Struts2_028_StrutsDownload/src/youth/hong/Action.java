package youth.hong;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	private String inputName;
	private String contentType;
	private String fileName;
	
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName)  {
		this.getInputStream();
		System.out.println(inputName);
		try {
			inputName = new String(inputName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.inputName = inputName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType)  {
		try {
			contentType = new String(contentType.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.contentType = contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName)  {
		try {
			fileName = new String(fileName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fileName = fileName;
	}
	
	public InputStream getInputStream() {
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream("/upload/warArea.jsp");
		System.out.println(is);
		return is;
	}
	
}
