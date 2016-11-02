<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="youth.hong.dao.ItemsDao"%>
<%@page import="youth.hong.items.Items"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cart" class="youth.hong.cart.Cart" scope="session"></jsp:useBean>
<%
	Map<Items,Integer> items = cart.getItems();
	Set<Items> keys = items.keySet();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.pictureBox{
	width:800px;
	margin:0 auto;
	
}
.pictureBox div {
	display:inline-block;
}
img {
	width:100px;
	height:100px;
}
span{
	display:inline-block;
	width:30px;
	height:30px;
	border: 1px solid;
	text-align: center;
	line-height: 30px;
}
</style>

</head>
<body>

	<div class="pictureBox">
	<%
		for(Items mm : keys) {
			
	%>
		<div>
			<img alt="picture" src="images/<%=mm.getPicture() %>">
			<p><%=mm.getName() %></p>
			<p><%=mm.getPrice() %></p>
			<p><%=items.get(mm) %></p>
			
		</div>
	<%
		}
	%>
	</div>
</body>
</html>