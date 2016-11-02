<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0, 0;
	padding: 0, 0;
}
</style>
</head>
<body>
	<div
		style="height: 100%; background: pink; position: absolute; width: 100%; text-align: center;">
		<table style="height: 100%; width: 100%">
			<tr>
				<td><p
						style="vertical-align: middel; font-size: 80px; color: red;">sorry！出错了！</p></td>
			</tr>

			<tr>
				<td><p
						style="vertical-align: middel; font-size: 80px; color: red;"><s:debug></s:debug></p></td>
			</tr>
		</table>
	</div>

</body>
</html>