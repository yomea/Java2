<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/T7.js"></script>
<script type="text/javascript">
function test1(){
	T7.hasPermission(
		$("name").value,
		$("permission").value,
		function(datas){
			$("hp").checked = datas;
		}
	);
}

</script>
</head>
<body>
name: <input type="text" name="name"> <br>
permission: <input type="text" name="permission"> <br>
<input type="button" value="测试是否有权限" onclick="test1()"> <br>
<input type="checkbox" name="hp">拥有权限
</body>
</html>