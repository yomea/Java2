<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/T5.js"></script>
<script type="text/javascript">
function test1(){
	T5.hello(
		function(datas){
		    //�����֪����Map��key������������ַ�ʽ��ö�Ӧ��value
			alert(datas.k1);
			alert(datas["k2"]);
		}
	);
}

function test2(){
	T5.hello(
		function(datas){
			//ѭ����ȡMap�е�����
			for(var prop in datas){
				alert("key="+prop+",value="+datas[prop]);
			}
		}
	);
}

</script>
</head>
<body>
<input type="button" value="����1" onclick="test1()">
<input type="button" value="����2" onclick="test2()">
</body>
</html>