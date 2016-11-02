<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%=application.getRealPath("/upload") %>
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
<s:fielderror></s:fielderror>
<s:head/>
<form method="post" action="test" enctype="multipart/form-data">
	<input type="file" name="upload" /><br>
	<br>
	<input type="file" name="upload" /><br>
	<br>
	<input type="file" name="upload" /><br>
	<br>
	<input type="text" name="title" /><br>
	<br>
	<input type="submit" value="submit" />

</form>

</body>
</html>