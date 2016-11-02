<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%  Date now = new Date();
	request.setAttribute("now", now);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forTokens var="s" items="hello,world" delims=",">
		<c:out value="${fn:substring(s,0,2)}"></c:out><br />
	</c:forTokens>
	
	<fmt:formatNumber value="123456789" pattern=".000"></fmt:formatNumber><br />
	
	<fmt:formatDate value="${now }" type="both" pattern="yyyy-MM-dd"/><br />
	
	${fn:escapeXml("<br />") }
</body>
</html>