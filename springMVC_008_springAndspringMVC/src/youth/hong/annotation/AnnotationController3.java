package youth.hong.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/test3")
public class AnnotationController3 extends MultiActionController {
	
	@RequestMapping("/add")
	public String add() {
		System.out.println("AnnotationController...add........");
		return "/add";
	}
	@RequestMapping("/update")
	//http://localhost:8888/springMVC_003_multiple/multiple?action=update
	public String update() {
		System.out.println("AnnotationController...update........");
		return "update";
	}
	
}
