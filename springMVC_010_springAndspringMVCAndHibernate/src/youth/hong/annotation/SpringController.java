package youth.hong.annotation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import youth.hong.entity.User;
import youth.hong.service.Service;

@Controller
@RequestMapping("/controller")
public class SpringController {
	
	@Resource(name="serviceImpl")
	private Service service;
	
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) {
		service.add(user);
		
		return "addUser";
	}
	
	@RequestMapping("/showusers")
	public String getAllUsers(HttpServletRequest request) {
		
		List<User> users = service.showUsers();
		
		request.setAttribute("users", users);
		
		return "showUsers";
	}
	
	@RequestMapping("/showoneuser")
	public String loadUserById(int id, HttpServletRequest request) {
		
		User user = service.loadUserById(id);
		System.out.println(user);
		request.setAttribute("user", user);
		
		return "updateuser";
	}
	
	@RequestMapping("/deleteusers")
	public String deleteUser(int id, HttpServletRequest request, HttpServletResponse response) {
		
		service.deleteUser(id);
		
		/*try {
			//request.getRequestDispatcher("showusers").forward(request, response);
			response.sendRedirect("showusers");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return "redirect:/controller/showusers";
	}
	
	@RequestMapping("/updateusers")
	public void updateuser(User user, HttpServletRequest request, HttpServletResponse response) {
		
		service.updateuser(user);
		
		try {
			//request.getRequestDispatcher("showusers").forward(request, response);
			response.sendRedirect("showusers");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
