<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloStruts2</title>
</head>
<body>
Hello Struts2
<br />
<p><%=request.getServletPath() %></p>
<p><%=request.getContextPath() %></p>
<p><%=request.getRequestURI() %></p>
<p><%=request.getRequestURL() %></p>
<p><a href="<%=request.getContextPath() %>/index.jsp">index.jsp</a></p>
</body>
</html>