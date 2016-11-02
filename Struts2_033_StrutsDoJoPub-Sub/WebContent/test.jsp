<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<sx:head/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript">
<%--  function testAJAX() {
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
 } --%>
 dojo.event.topic.subscribe("/lee",function(data, type, request) {
	 alert(type + "---||---" + data + "---||---" + request);
	// request.cancel = true;
 });
</script> 
</head>

<body>
<sx:div cssStyle="color:red;" listenTopics="/lee" href="book" updateFreq="1000" loadingText="正在加载。。。">

</sx:div>

<sx:div listenTopics="/lee" href="hello" updateFreq="1000" loadingText="正在加载。。。">

</sx:div>
<form action="test" method="post">
	<input name="num" /> <br>
	<!-- 只运行远程的js代码，相当于直接将远程的js代码加载到此页面运行，其他非js代码无效 -->
	<%-- <sx:submit  value="submit" targets="hello" notifyTopics="/lee" /> --%><%-- executeScripts="true" --%>
	<sx:submit  type="submit" value="submit" notifyTopics="/lee" /><br>
	
	<sx:datetimepicker
		name="date1"
		label="dateTime"
		displayFormat="yyyy-MM-dd"
		value="13:00"
	></sx:datetimepicker>
</form>
</body>
</html>