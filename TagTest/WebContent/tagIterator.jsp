<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="youth" uri="/tag" %>
<%
	String[] items = {"赵薇","苏有朋","周杰"};
	pageContext.setAttribute("items", items);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<youth:SimpleTagIterator items="${ items}" var="name">
	${ name}<br />
</youth:SimpleTagIterator>
</body>
</html>