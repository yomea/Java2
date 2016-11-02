package youth.hong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	private String title;
	private File[] upload;//private List<File> upload
	private String[] uploadContentType;//private List<String>
	private String[] uploadFileName;
	private String savePath;
	private String allowTypes;
	
	public String getAllowTypes() {
		return allowTypes;
	}
	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}
	
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String execute() throws Exception {
		String[] types = this.getTypes();
		String check = this.fileFilter(types);
		System.out.println(check);
		if(check == null) {
			return INPUT;
		}
		String newName = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		for(int i = 0; i < upload.length; i++) {
			
			newName = UUID.randomUUID() + uploadFileName[i].substring(uploadFileName[i].lastIndexOf('.'));
			uploadFileName[i] = newName;
			String path = ServletActionContext.getServletContext().getRealPath(savePath);
			System.out.println(path + "\\" + newName);
			System.out.println(upload[i].getName());
			fis = new FileInputStream(upload[i]);
			fos = new FileOutputStream(path + "\\" + newName);
			byte[] buff = new byte[1024];
			int len = 0;
			while((len=fis.read(buff)) > 0) {
				fos.write(buff, 0, len);
			}
		}
		this.setUploadFileName(uploadFileName);
		fis.close();
		fos.close();
		return SUCCESS;
	}
	/**
	 * 还可以使用struts2自带的fileUpload来过滤
	 * @param types
	 * @return
	 */
	
	public String fileFilter(String[] types) {
		boolean check;
		for(int i = 0; i < upload.length; i++) {
			
			check = false;
			
			for(String string : types) {
				if(uploadContentType[i].equals(string)) {
					check = true;
				}
			}
			
			if(!check) {
				return null;
			}
		}
		return "continue";
	}
	
	public String[] getTypes() {
		String[] types = allowTypes.split(",");
		return types;
	}
	
}
