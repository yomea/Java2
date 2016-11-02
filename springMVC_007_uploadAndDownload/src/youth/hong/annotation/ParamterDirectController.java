package youth.hong.annotation;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/test4")
public class ParamterDirectController extends MultiActionController {
	
	@RequestMapping("/add")
	public String add(String username, int age, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		//username = new String(username.getBytes("ISO-8859-1"),"utf-8");
		request.setAttribute("username", username);
		request.setAttribute("age", age);
		System.out.println("AnnotationController...add........");
		return "/success";
	}
	@RequestMapping("/update")
	//http://localhost:8888/springMVC_003_multiple/multiple?action=update
	public String update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AnnotationController...update........");
		return "update";
	}
	
}
