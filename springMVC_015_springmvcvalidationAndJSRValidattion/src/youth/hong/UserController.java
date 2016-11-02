package youth.hong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usercontroller")
public class UserController {
	
	@RequestMapping("/adduser")
	public String addUser(@ModelAttribute User user, BindingResult bs) {
		
		if(bs.hasErrors()) {
			MyValidation mv = new MyValidation();
			mv.validate(user, bs);
			System.out.println("errorCount" + bs.getErrorCount() + "errorMsg" + bs.getFieldError());
			return "adduser";
		}
		
		return "userdetail";
	}
	
	@RequestMapping("/inputuser")
	public String user(Model model) {
		
		model.addAttribute("user", new User());
		
		return "adduser";
	}
	
}
