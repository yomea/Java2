package youth.hong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class StaticController extends MultiActionController {
	
	public ModelAndView img(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("img........");
		return new ModelAndView("img","method","img");
	}
	
	//http://localhost:8888/springMVC_003_multiple/multiple?action=update
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("update........");
		return new ModelAndView("update","method","update");
	}
	
}
