<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/T1.js"></script>
<script type="text/javascript">
function test1(){
	//T1Ϊjavascript������,helloΪ��̨����������
	T1.hello(
		function(data){
			alert(data);
		}
	);
}

</script>
</head>
<body>
<input type="button" value="����" onclick="test1()">
</body>
</html>