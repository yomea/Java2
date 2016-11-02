package youth.hong;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {
	private String editor1;

	
	public String getEditor1() {
		return editor1;
	}


	public void setEditor1(String editor1) {
		this.editor1 = editor1;
	}


	@Override
	public String execute() throws Exception {
		/*String string =" <p>
		<img alt="" src="/CkeditorUploadDownload/userfiles/images/warArea.jpg" style="width: 800px; height: 600px;" /></p>"";*/
		int beginIndex = 0;
		
		while(beginIndex != -1) {
			String ss = ServletActionContext.getServletContext().getContextPath();
			beginIndex = editor1.indexOf(ss, beginIndex);
			int endIndex = editor1.indexOf("\"",beginIndex);
			int filebegin = editor1.lastIndexOf("/", endIndex);
			
			String fileName = editor1.substring(filebegin + 1,endIndex);
			String temp1 = editor1.substring(0,beginIndex);
			String temp2 = editor1.substring(endIndex);
			String middle = ss + "/download.action?fileName=" + fileName;
			editor1 = temp1 + middle + temp2;
			beginIndex = editor1.indexOf(ss, endIndex);
			System.out.println(editor1);
		}
		
		return SUCCESS;
	}
	
	
}
