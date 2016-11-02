package youth.hong.watermark;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class WaterMarkAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<File> file;
	private List<String> fileContentType;
	private List<String> fileFileName;
	private List<String> srcs;

	public List<String> getSrcs() {
		return srcs;
	}

	public void setSrcs(List<String> srcs) {
		this.srcs = srcs;
	}

	@Override
	public String execute() throws Exception {
		dealWithFiles();
		return SUCCESS;
	}

	public String upload() {
		return "upload";
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void dealWithFiles() {
		List<String> imageSrcs = new ArrayList<String>();
//		UploadService us = new UploadService();
		WaterMark wm = new MoreImageWaterMark();


		String uploadPath = "/images";
		String realUploadPath = ServletActionContext.getServletContext().getRealPath("/images");
		System.out.println(realUploadPath);
		for (int i = 0; i < file.size(); i++) {
			// String imageSrc = us.upload(file.get(i), uploadPath,
			// realUploadPath, fileFileName.get(i), fileContentType.get(i));
			// String imageSrc = fwm.watermark(file.get(i), uploadPath,
			// realUploadPath, fileFileName.get(i), fileContentType.get(i));
			String imageSrc = wm.watermark(file.get(i), uploadPath, realUploadPath, fileFileName.get(i),
					fileContentType.get(i));
			imageSrcs.add(imageSrc);
			System.out.println(imageSrc);
		}
		this.setSrcs(imageSrcs);

	}

}
