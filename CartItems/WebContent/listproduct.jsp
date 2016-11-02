<%@page import="youth.hong.items.Items"%>
<%@page import="java.util.List"%>
<%@page import="youth.hong.dao.ItemsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ItemsDao im = new ItemsDao();
	List<Items> items = im.getAllItems();
	
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
</style>
</head>
<body>
	<div class="pictureBox">
	<%
		for(Items item : items) {
	%>
		<div>
			<a href="detail.jsp?id=<%=item.getId()%>"><img alt="picture" src="images/<%=item.getPicture() %>"></a>
			<p><%=item.getName() %></p>
			<p><%=item.getPrice() %></p>
		</div>
	<%
		}
	%>
	</div>
</body>
</html>