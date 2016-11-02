<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="/CkeditorUploadDownload/ckeditor/ckeditor.js"></script>

<script type="text/javascript" src="/CkeditorUploadDownload/ckfinder/ckfinder.js"></script>

</head>
<body>
	<form action="/CkeditorUploadDownload/testAction.action" method="post">
			<p>
				<label for="editor1">Editor 1:</label>
				<textarea cols="80" id="editor1" name="editor1" rows="10"></textarea>
			</p>
			<p>
				<input type="submit" value="Submit" />
			</p>
		</form>
		
		<ckeditor:replace replace="editor1" basePath="/CkeditorUploadDownload/ckeditor/" />
		
		
</body>
</html>