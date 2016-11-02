<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%System.out.println(request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:property value="fieldErrors.usererror[0]" />
<s:form method="post" action="test/register">
	<s:textfield name="username" key="user.username"></s:textfield>
	<s:textfield name="password" key="user.password"></s:textfield>
	<s:submit value="submit"></s:submit>
</s:form>
<s:property value="get{'user.username'}"/>
<s:debug></s:debug>
</body>
</html>