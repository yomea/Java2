<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% String path = request.getServletPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error {
 outline: solid red 2px;
}
</style>
</head>
<body>
	<form:form commandName="user" action="/springMVC_011_springmvcmodelattributeAndRedirectFlash/usercontroller/adduser" method="post">
		<form:input  path="username" /><br> 
		<form:errors path="*"/><br>
		<form:input  path="age" cssErrorClass="error" /><br>
		<form:input  path="address.address" /><br> 
		<input type=submit value=submit />
	</form:form>
</body>
</html>