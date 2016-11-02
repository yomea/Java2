package youth.hong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/userredirectcontroller")
public class UserRedirectController {
	
	@RequestMapping("/adduser")
	public String addUser(RedirectAttributes ra) {
		
		User user = new User("youth", 22, new Address("½­Î÷"));
		
		ra.addFlashAttribute(user);
		return "redirect:userdetail";
	}
	
	@RequestMapping("/userdetail")
	public String addUser() {
		
		
		
		return "user";
	}
	
}
