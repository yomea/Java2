<%@page import="java.util.List"%>
<%@page import="youth.hong.dao.ItemsDao"%>
<%@page import="youth.hong.items.Items"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strId = request.getParameter("id");
	int id = Integer.parseInt(strId);
	ItemsDao im = new ItemsDao();
	Items item = im.getItemById(id);
	String str = "";
	int i = 0;
	boolean isExist = false;
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0) {
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("listView")) {
				String cStr = cookie.getValue();
				if(cStr.length() > 1000) {
					cStr = "";
				}
				i++;
				isExist = true;
				str = cStr;
				str += id + ",";
				cookie.setValue(str);
				cookie.setMaxAge(100000);
				response.addCookie(cookie);
			} 
		}
		
	
	} else {
		str = id + ",";
		Cookie c = new Cookie("listView", str);
		//c.setMaxAge(10000);
		response.addCookie(c);
		System.out.println(i);
	}
	if(!isExist) {
		str = id + ",";
		Cookie c = new Cookie("listView", str);
		//c.setMaxAge(10000);
		response.addCookie(c);
		System.out.println(i);
	}
		
	
	List<Items> items = im.getItems(str);
	Items its= im.getItemById(id);
	/* System.out.println(str);
	System.out.println(items.size()); */
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
#buy{
	cursor: pointer;
}
</style>
<script type="text/javascript">
	window.onload = function() {
		var reduce = document.getElementById("reduce");
		var add = document.getElementById("add");
		var count = document.getElementById("count");
		var buy = document.getElementById("buy");
		var iCount= parseInt(count.innerHTML);
		//alert(i);
		add.onclick = function() {

			count.innerHTML = ++iCount;
		}
		
		reduce.onclick = function() {
			
			
			if(iCount < 1) {
				iCount = 1;
			}
			count.innerHTML = --iCount;
		}
		
		buy.onclick = function() {
			window.location.href = "<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/servlet/BuyProduct?id=<%=its.getId() %>&action=addToCart&count=" + iCount;
		}
	}
</script>
</head>
<body>
<div class="pictureBox">
	
		<div>
			<img alt="picture" src="images/<%=its.getPicture() %>">
			<p><%=its.getName() %></p>
			<p><%=its.getPrice() %></p>
			<p><a id="buy">购买</a><span id="reduce">-</span><span id="count">1</span><span id="add">+</span></p>
			<p><a href="lookcart.jsp">查看购物车</a></p>
		</div>
<h1>您的浏览记录</h1>
	</div>
	<div class="pictureBox">
	<%
		for(Items mm : items) {
	%>
		<div>
			<img alt="picture" src="images/<%=mm.getPicture() %>">
			<p><%=mm.getName() %></p>
			<p><%=mm.getPrice() %></p>
			
		</div>
	<%
		}
	%>
	</div>
</body>
</html>