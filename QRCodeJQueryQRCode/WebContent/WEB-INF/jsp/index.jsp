<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>js生成二维码</title>
</head>
<body>
	<div id="output" align="center"></div>

	<script
		src="<%=contextPath %>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/js/jquery.qrcode.min.js"></script>
	<script>
		jQuery(function() {
			jQuery('#output').qrcode("www.yomea.win");
		})
	</script>
</body>
</html>