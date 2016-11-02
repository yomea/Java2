package youth.hong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiController extends MultiActionController {
	
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add........");
		return new ModelAndView("add","method","add");
	}
	
	//http://localhost:8888/springMVC_003_multiple/multiple?action=update
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("update........");
		return new ModelAndView("update","method","update");
	}
	
}
