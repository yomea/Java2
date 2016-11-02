package youth.hong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import youth.hong.bean.User;
import youth.hong.service.IService;

@Controller
@RequestMapping("/")
public class ChatController {
	
	@Autowired
	private IService service;
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/response")
	public String response() {
		
		return "main";
	}
	
	@RequestMapping("/validation")
	public void validation(User user, Model model, HttpServletResponse response) {
		
		System.out.println(user);
		PrintWriter out = null;
		String s = null;
		try {
			out = response.getWriter();
			response.setContentType("text/javascript");
			response.setHeader("Pragma","No-cache");  
			response.setHeader("Cache-Control","no-cache");  
			response.setDateHeader("Expires", 0); 
			if(service.getUser(user) == null) {
				
				System.out.println("0");
				s = "0";
				
			} else {
				model.addAttribute("user", user);
				
				System.out.println(new Date() + "  1");
				s = "1";
			}
			s = "{s:\"" + s + "\"}";
			System.out.println(s);
			out.write(s);
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				
				out.close();
			}
		}
	
		
		
	}
	
}
