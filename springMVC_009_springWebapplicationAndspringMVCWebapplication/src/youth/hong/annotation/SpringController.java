package youth.hong.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import youth.hong.entity.User;
import youth.hong.service.Service;

@Controller
@RequestMapping("/controller")
public class SpringController {
	
	//@Resource(name="serviceImpl")
	//private Service service;
	
	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request, HttpServletResponse response) {
		
		//spring上下文
		WebApplicationContext ac1 = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		//springMVC上下文
		WebApplicationContext ac2 = RequestContextUtils.findWebApplicationContext(request);
		
		//Service service = ac2.getBean("serviceImpl", Service.class);
		
		Service service = ac1.getBean("serviceImpl", Service.class);
		
		service.add(user);
		
		return "addUser";
	}
}
