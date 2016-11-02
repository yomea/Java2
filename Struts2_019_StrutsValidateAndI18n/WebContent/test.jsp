<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* function checkusername() {
	var username = document.getElementById("username");
	var request = new XMLHttpRequest();
	url = "path/index";
	request.open("POST", url, true);
	request.send(username.value);
} */
</script>
</head>
<body>
<s:form action="path/index">
	<s:textfield name="username" label="username" id="username" onblur="checkUsername()"></s:textfield><br>
	<s:password name="password" label="password" id="password"></s:password>
	<s:submit value="提交"></s:submit>
</s:form>
</body>
</html>