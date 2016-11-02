<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Category_input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table style="text-align: center;">
  <tr>
			<td>id</td>
			<td>name</td>
			<td>description</td>
		</tr>
	<s:iterator value="categories" var="c">
	
	
		
		<tr>
			<td><s:property value="#c.id" /></td>
			<td><s:property value="#c.name" /></td>
			<td><s:property value="#c.description" /></td>
			<td><a href="<%=request.getContextPath() %>/admin/Category_updateInput?id=<s:property value="#c.id"/>">update</a></td>
			<td><a href="<%=request.getContextPath() %>/admin/Category_delete?id=<s:property value="#c.id"/>">delete</a></td>
		</tr>
	
	
		
	</s:iterator>
	</table>
  </body>
</html>
