package youth.hong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserModelAttributeController2 {
	
	@ModelAttribute
	public User user(User user) {
		
		System.out.println("��@ModelAttribute��ʶ�ķ�����ִ�У�");
		return user;
	}
	
	@RequestMapping("/adduser")
	public String addUser() {
		
			System.out.println("hello!is me!");
			return "userdetail";
		
	}
	
	
	
}
