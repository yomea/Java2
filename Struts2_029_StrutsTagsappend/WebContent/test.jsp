<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<s:append var="a">
	<s:param name="b" value="#{'a','b','c','d'}" />
	<s:param name="c" value="{1,2,3,4}" />
</s:append>
<s:iterator value="#a">
<s:property />
</s:iterator>
<s:set var="hello" value="#{'a':{1,2,3,4,5,6},'b':{2},'c':{3}}">

</s:set>
<s:doubleselect label="你好哈哈" name="hong" list="#hello.keySet()" doubleName="youth" doubleList="#hello[top]">
</s:doubleselect>

</body>
</html>