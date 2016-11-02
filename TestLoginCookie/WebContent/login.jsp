<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = "";
	String password = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0) {
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("username")) {
				username = cookie.getValue();
			} else if(cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
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
	<h1>用户登录</h1>
	<form action="checkuser.jsp" method="post" name="login">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="<%=username %>" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password" value="<%=password %>" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="submit" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="checkbox" value="true" name="isSave" />保存十天</td>
			</tr>
		</table>
	</form>
	<%-- <jsp:param value="testjspparam" name="test"/> 错误的做法--%>
</body>
</html>