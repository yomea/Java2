<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="youth" uri="/tag" %>
<%
	String url="jdbc:mysql://localhost:3306/test";
	String password="root";
	String sql="select username from t_user";
	String username="root";
	String driver="com.mysql.jdbc.Driver";
	pageContext.setAttribute("url", url);
	pageContext.setAttribute("password", password);
	pageContext.setAttribute("sql", sql);
	pageContext.setAttribute("username", username);
	pageContext.setAttribute("driver", driver);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<youth:connDatabase password="${ password}" url="${ url}" sql="${ sql}" username="${ username}" driver="${ driver}"/><br>
</body>
</html>