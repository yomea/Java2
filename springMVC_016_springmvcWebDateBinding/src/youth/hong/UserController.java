package youth.hong;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/adduser")
	@ResponseBody
	public String addUser(@ModelAttribute User user2, BindingResult bs,@ModelAttribute Admin admin ) {
		
		if(bs.hasErrors()) {
			System.out.println("errorCount" + bs.getErrorCount() + "errorMsg" + bs.getFieldError());
			return "adduser";
		}
		
		System.out.println(user2);
		System.out.println(admin);
		
		return user2.toString() + "<br>" + admin.toString();
	}
	//http://localhost:8888/springMVC_016_springmvcWebDateBinding/adduser?user2.username=22&admin.username=bb&user2.address.address=BeiJing
	//http://localhost:8888/springMVC_016_springmvcWebDateBinding/adduser?user2.words=1&user2.words=2&user2.words=3
	//http://localhost:8888/springMVC_016_springmvcWebDateBinding/adduser?user2.words[0]=1&user2.words[1]=2&user2.words[20]=3
	//用于传参是的加前缀
	@InitBinder("user")//类名首字母小写
	public void initBinderUser(WebDataBinder wb) {
		wb.setFieldDefaultPrefix("user2.");
	}
	
	@InitBinder("admin")//类名首字母小写
	public void initBinderAdmin(WebDataBinder wb) {
		wb.setFieldDefaultPrefix("admin.");
	}
	
}
