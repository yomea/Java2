package youth.hong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import youth.hong.entity.Tree;
import youth.hong.entity.User;
import youth.hong.message.Message;
import youth.hong.service.IUserService;
import youth.hong.service.impl.UserServiceImpl;
import youth.hong.util.DigitUtil;

public class LoginController extends HttpServlet {

	private IUserService service = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String action = req.getParameter("action");
			resp.setDateHeader("Expires", 0);  
			resp.setHeader("Cache-Control", "no-cache");  
			resp.setHeader("Prama", "no-cache"); 
			if(action != null && action.equals("logout")) {
				req.getSession().removeAttribute("user");
			//	System.out.println(req.getSession().getAttribute("user"));
				resp.sendRedirect("/login");
				return;
				
			}
			
			if(action != null && action.equals("tree")) {
				//JSONArray json = JSONArray.fromObject(object);
				String idStr = req.getParameter("id");
				int id = 0;
				if(idStr != null || DigitUtil.isDigit(idStr)) {
					id = Integer.valueOf(idStr);
					
					
				}
				List<Tree> tree = service.findTree(id);
				JSONArray json = JSONArray.fromObject(tree);
				resp.setContentType("application/json;charset=utf-8");
				PrintWriter p = resp.getWriter();
				p.write(json.toString());
				p.flush();
				p.close();
			}
			
			if(action == null) {
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				if(username == null || password == null ||  "".equals(username.trim()) || "".equals(password.trim())) {
					resp.sendRedirect("/jsp/login.html");
					return ;
				}
				User user = new User(username,password);
				Message<User> message = service.getUser(user);
				resp.setContentType("application/json;charset=utf-8");
				boolean success = message.isSuccess();
				List<User> users = message.getData();
				if(users != null) {
					req.getSession().setAttribute("user", users.get(0));
					
				}
				PrintWriter p = resp.getWriter();
				p.write("{\"success\":" + success + "}");
				p.flush();
				p.close();
			}
			
			
	
		
	}
	
	

}
