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

<s:property value="#request.r1" />|<%=request.getAttribute("r1") %><br />
<s:property value="#session.s1" />|<%=session.getAttribute("s1") %><br />
<s:property value="#application.a1" />|<%=application.getAttribute("a1") %><br />
<s:property value="#attr.r1" /><br />
<s:property value="#attr.s1" /><br />
<s:property value="#attr.a1" /><br />
<s:property value="#parameters.username" /><!-- 可以获取到直接传给jsp的参数 -->
<s:a href="main.jsp" >hello </s:a>
<s:debug></s:debug>
</body>
</html>