<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.hello{
	outline: solid blue 5px;
}
</style>
</head>
<body>
<p>user的详细信息：</p>
<form:form commandName="user" action="usercontroller/adduser" method="post">
	<form:input path="username" cssClass="hello" /><br>
	<form:input path="age" /><br>
	<form:input path="address.address" /><br>
	<form:input path="gender" /><br>
</form:form>
</body>
</html>