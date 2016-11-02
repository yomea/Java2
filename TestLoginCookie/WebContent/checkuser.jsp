<%@page import="youth.hong.userDao.PasswordNotCorrectException"%>
<%@page import="youth.hong.userDao.UsernameNotFoundException"%>
<%@page import="youth.hong.user.User"%>
<%@page import="youth.hong.userDao.Userdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String isSave = request.getParameter("isSave");
	User user = null;
	if(username == null || "".equals(username)) {
		out.println("请输入用户名");
		response.setHeader("refresh", "1;url=login.jsp");
		return;
		
	} else if(password == null || password.equals("")) {
		out.println("请输入密码");
		response.setHeader("refresh", "1;url=login.jsp");
		return;
	} else {
		request.setCharacterEncoding("utf-8");
		username = new String(username.getBytes("ISO-8859-1"),"utf-8");
		password = new String(password.getBytes("ISO-8859-1"),"utf-8");
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		try {
			Userdao.getUd().checkUser(user);
			
		} catch(UsernameNotFoundException e) {
			out.println(e.getMessage());
			response.setHeader("refresh", "1;url=login.jsp");
			return;
		} catch(PasswordNotCorrectException e) {
			out.println(e.getMessage());
			response.setHeader("refresh", "1;url=login.jsp");
			return;
		}
		if(isSave != null && isSave.equals("true")) {
			Cookie usernameCookie = new Cookie("username",username);
			Cookie passwordCookie = new Cookie("password",password);
			usernameCookie.setMaxAge(864000);
			passwordCookie.setMaxAge(864000);
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
			
		} else {
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0) {
				for(int i = 0; i < cookies.length; i++) {
					cookies[i].setMaxAge(0);
				}
			}
			Cookie uCookie = new Cookie("username",username);
			Cookie pCookie = new Cookie("password",password);
			response.addCookie(uCookie);
			response.addCookie(pCookie);
		}
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=username %>登陆成功！</h1>
	<%=request.getParameter("test") %>
</body>
</html>