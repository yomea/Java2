package youth.hong.watermark;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/watermark")
public class WaterMarkController {

	private List<String> srcs;
	
	
	private WaterMark wm;
	
	
	@Resource(name="moreImageWaterMark")
	public void setWm(WaterMark wm) {
		this.wm = wm;
	}

	public List<String> getSrcs() {
		return srcs;
	}

	public void setSrcs(List<String> srcs) {
		this.srcs = srcs;
	}

	@RequestMapping("/execute")
	public ModelAndView execute(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request){
		if(files != null && files.length > 0) {
			
			dealWithFiles(request, files);
		}
		ModelAndView ma = new ModelAndView();
		ma.addObject("srcs", srcs);
		ma.setViewName("index");
		return ma;
	}
	
	@RequestMapping("/upload")
	public String upload() {
		System.out.println("saldjlf");
		return "watermark";
	}

	
	

	public void dealWithFiles(HttpServletRequest request, CommonsMultipartFile[] file) {
		List<String> imageSrcs = new ArrayList<String>();
//		UploadService us = new UploadService();
		


		String uploadPath = "/images";
		String realUploadPath = request.getServletContext().getRealPath("/images");
		System.out.println(realUploadPath);
		for (int i = 0; i < file.length; i++) {
			// String imageSrc = us.upload(file.get(i), uploadPath,
			// realUploadPath, fileFileName.get(i), fileContentType.get(i));
			// String imageSrc = fwm.watermark(file.get(i), uploadPath,
			// realUploadPath, fileFileName.get(i), fileContentType.get(i));
			System.out.println(file.length);
			System.out.println(file[i]);
			if(file[i] != null && file[i].getSize() > 0) {
				
				String imageSrc = wm.watermark(file[i], uploadPath, realUploadPath);
				imageSrcs.add(imageSrc);
				System.out.println(imageSrc);
			}
		}
		this.setSrcs(imageSrcs);

	}

}
