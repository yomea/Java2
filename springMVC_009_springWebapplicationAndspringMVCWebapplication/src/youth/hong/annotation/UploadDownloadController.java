package youth.hong.annotation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/upload")
public class UploadDownloadController extends MultiActionController {
	
	@RequestMapping("/file")
	public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		
		InputStream in = null;
				
		OutputStream out = null;
		
		System.out.println("文件名：" + file.getOriginalFilename() + "---------" + file.getContentType() + "----------" + file.getSize());
		
		long start = System.currentTimeMillis();
		
		if(!file.isEmpty()) {
			
			try {
				in = file.getInputStream();
				
				out = new FileOutputStream("D:/" + new Date().getTime() + file.getOriginalFilename());
				
				byte[] buff = new byte[1024];
				
				while((in.read(buff)) != -1) {
					out.write(buff);
					out.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(in != null) {
						in.close();
					}
					if(out != null) {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("传统java上传用时：" + (end - start));
		
		return "/fileupload";
	}
	
	@RequestMapping("/file2")
	public String uploadFile2(HttpServletRequest request, HttpServletResponse response){
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
		
		if(resolver.isMultipart(request)) {
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			
			Map<String, MultipartFile> map = multipartRequest.getFileMap();
			
			Set<Map.Entry<String, MultipartFile>> set = map.entrySet();
			
			for (Entry<String, MultipartFile> entry : set) {
				
				MultipartFile file = entry.getValue();
				
				String fileName = "demo" + UUID.randomUUID() + "." + file.getOriginalFilename().split("\\.")[1];
				
				File f = new File("D:/" + fileName);
				
				try {
					long start = System.currentTimeMillis();
					file.transferTo(f);
					long end = System.currentTimeMillis();
					
					System.out.println("springMVC 上传用时：" + (end - start));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("ok!!");
			}
			
		}
		
		return "/fileupload";
	}
	
	@RequestMapping("/download")
	public void download(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		
		System.out.println(path);
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("multipart/form-data");
		
		File file = new File("D:/" + fileName);
		
		InputStream in = new FileInputStream(file);
		
		OutputStream out = response.getOutputStream();
		
		byte[] buff = new byte[1024];
		
		int length = 0;
		
		while((length = in.read(buff)) != -1) {
			out.write(buff);
		}
				
		
	}
	
	
}
