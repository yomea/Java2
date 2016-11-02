package youth.hong.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class AnnotationController extends MultiActionController {
	
	@RequestMapping(value="/test/add",method=RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AnnotationController...add........");
		return new ModelAndView("add","method","AnnotationControlleradd");
	}
	@RequestMapping(value="/test/update",method=RequestMethod.GET)
	//http://localhost:8888/springMVC_003_multiple/multiple?action=update
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AnnotationController...update........");
		return new ModelAndView("update","method","AnnotationControllerupdate");
	}
	
}
