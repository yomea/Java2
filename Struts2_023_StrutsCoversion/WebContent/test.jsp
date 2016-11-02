<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:property value="interests" />
	<br>
	<s:date name="d" format="yyyy/MM/dd HH:mm:ss" />
	<br>
	<s:property value="m" />
	<br>
	<s:property value="p" />
	<!-- http://localhost:8888/Struts2_023_StrutsCoversion/test?m['name']=youth&m['age']=22&interests=youth&interests=hong&d=2016-04-22 19:26:10 -->
</body>
</html>