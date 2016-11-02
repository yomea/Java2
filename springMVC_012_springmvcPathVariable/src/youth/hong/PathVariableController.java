package youth.hong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class PathVariableController {
	
	@RequestMapping("/test/{id}")
	public String test(@PathVariable int id) {
		
		System.out.println("@PathVariable" + id);
		
		return "NewFile";
		
	}
	
	
	
}
