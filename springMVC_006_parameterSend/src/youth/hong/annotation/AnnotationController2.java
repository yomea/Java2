package youth.hong.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/test2")
public class AnnotationController2 extends MultiActionController {
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AnnotationController...add........");
		request.setAttribute("method", "AnnotationControlleradd");
		return "/add";
	}
	@RequestMapping("/update")
	//http://localhost:8888/springMVC_003_multiple/multiple?action=update
	public String update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AnnotationController...update........");
		request.setAttribute("method", "AnnotationControllerupdate");
		return "update";
	}
	
}
