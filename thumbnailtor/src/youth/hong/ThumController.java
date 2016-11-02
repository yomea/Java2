package youth.hong;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ThumController")
public class ThumController {
	private ThumService thumService;
	private UploadService uploadService;
	
	@RequestMapping("/ThumController")
	public ModelAndView upload(@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws Exception, IOException {
		String uploadPath = "/image";
		String realUploadPath = session.getServletContext().getRealPath(uploadPath);
		String imageUrl = uploadService.uploadImage(file, uploadPath, realUploadPath);//原图的访问路径
		String thumUrl = thumService.createThumImage(file, uploadPath, realUploadPath);//缩略图的访问路径
		
		/*File f = new File(uploadPath + file.getOriginalFilename());
		
		file.transferTo(f);*/
		
		ModelAndView ret = new ModelAndView();
		
		ret.addObject("imageUrl", imageUrl);
		ret.addObject("thumUrl", thumUrl);
		ret.setViewName("/index");
		
		
		
		
		return ret;
	}

	@Autowired
	public void setThumService(ThumService thumService) {
		this.thumService = thumService;
	}
	@Autowired
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}
	
}
