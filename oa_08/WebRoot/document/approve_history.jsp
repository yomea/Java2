<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>����������ʷ</title>
</head>
<body>
<logic:empty name="historys">
��δ��������ʷ��¼��
</logic:empty>
<logic:notEmpty name="historys">
<logic:iterate id="history" name="historys">
<hr>
�����ˣ�<c:out value="${history.approver.person.name }"/><br>
����ʱ�䣺<c:out value="${history.approveTime }"/><br>
���������<c:out value="${history.comment }"/><br>
<br>
</logic:iterate>
</logic:notEmpty>
</body>
</html>