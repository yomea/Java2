<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateCode() {
		var image = document.getElementById("image");
		var date = new Date().getTime();
		image.src = "<%=request.getContextPath() %>/servlet/ImageCreate?date" + date;
	}
</script>
</head>
<body>
<form action="CheckInfo" method="post" name="checkCode">
	验证码：<input type="text" name="userCode" />
	<img alt="验证码" src="<%=request.getContextPath() %>/servlet/ImageCreate" id="image" />
	<span style="cursor: pointer; color:blue;" onclick="updateCode();">看不清</span><br />
	<input type="submit" value="submit" />
</form>
</body>
</html>