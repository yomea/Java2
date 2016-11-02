<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/T9.js"></script>
<script type="text/javascript">
function test1(){
	
	//设置为同步方式
	dwr.engine.setAsync(false);
	
	T9.method1(
		function(data){
			alert(data);
		}
	);
	
	T9.method2(
		function(data){
			alert(data);
		}
	);
}

</script>
</head>
<body>
授权：
<input userId="123" resourceSn="567" type="checkbox" name="t1" onclick="test1()">
<!-- 
也可以用这种方法来调用：

<input userId="123" resourceSn="567" type="checkbox" name="t1" onclick="test2()">
-->
</body>
</html>