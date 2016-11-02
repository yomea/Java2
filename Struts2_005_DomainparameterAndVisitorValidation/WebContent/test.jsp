<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="path/Teacher_add" method="post">
<s:textfield label="username" name="user.username"></s:textfield>
<s:password label="password" name="user.password"></s:password>
<s:textfield label="age" name="user.age"></s:textfield>
<s:submit></s:submit>
</s:form>
</body>
</html>