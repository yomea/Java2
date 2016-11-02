package youth.hong.annotation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import youth.hong.entity.User;
import youth.hong.service.Service;

@Controller
@RequestMapping("/controller")
public class SpringController {
	
	@Resource(name="serviceImpl")
	private Service service;
	
	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request, HttpServletResponse response) {
		service.add(user);
		
		return "addUser";
	}
}
