<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/T3.js"></script>
<script type="text/javascript">
function test1(){
	T3.hello(
		function(datas){
			for(var i=0; i < datas.length; i++){
				alert(datas[i]);
			}
		}
	);
}

</script>
</head>
<body>
<input type="button" value="测试" onclick="test1()">
</body>
</html>