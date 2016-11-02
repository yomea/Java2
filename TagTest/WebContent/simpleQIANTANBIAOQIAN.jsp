<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="youth" uri="/tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<youth:choose>
	<youth:when text="${ param.score >= 60}"> 
		恭喜你过了！
	</youth:when>
	
	<youth:otherwise>
		明年再来吧！
	</youth:otherwise>
</youth:choose>
</body>
</html>