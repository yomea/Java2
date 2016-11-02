<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 function testAJAX() {
	 //alert();
	 var value=document.getElementById("input").value;
	 var request = new XMLHttpRequest();
	 var url = "<%=request.getContextPath() %>/test";
	// alert(url);
	 request.open("POST",url);
	 request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	 request.send("num=" + parseInt(value));
	 //alert(parseInt(value) + 1);
	// alert();
	 request.onreadystatechange = function() {
		// alert();
		 if(request.readyState === 4) {
			// alert();
			 if(request.status === 200) {
				var str = request.responseText;
				var div = document.createElement("div");
				div.innerHTML = str;
				document.body.appendChild(div)
			 }
		 }
	 }
 }
</script>
</head>

<body>
<input id="input" type="text" name="num" />
<br>
<a onclick="testAJAX()">提交</a>
</body>
</html>