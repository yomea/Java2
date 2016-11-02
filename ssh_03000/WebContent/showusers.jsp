<%@page import="youth.hong.ShowUsers"%>
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
<table>
	<tr><td>用户列表</td></tr>
	<s:iterator value="users" var="user">
		<tr><td>
			<s:property value="#user.username"/>
			</td>
		</tr>
	
	</s:iterator>
	

</table>
<s:debug></s:debug>
</body>
</html>