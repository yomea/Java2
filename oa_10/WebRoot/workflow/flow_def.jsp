<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>�鿴���̶���</title>
</head>
<body>
<center>
<form action="user.do" method="post">
<input type="hidden" name="method" value="add">
<input type="hidden" name="personId" value="${userForm.personId}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">
			<a href="workflow.do?method=openViewImage&id=${workflowForm.id }">���鿴����ͼƬ��</a>
			���鿴���̶��塿
			</TD>
		</TR>
		<TR>
			<td align="left">
			<!-- ��������ʼ -->
			<pre><c:out value="${def }" escapeXml="true"/></pre>
			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>