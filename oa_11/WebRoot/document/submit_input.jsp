<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>��ѡ��һ����������ύ��</title>
</head>
<body>
<center>
<form action="document.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">��ѡ��һ����������ύ��</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->

<input type="hidden" name="method" value="submit">
<input type="hidden" name="id" value="${documentForm.id }">
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
    <c:forEach items="${steps }" var="step">
	<tr>
		<td  style="width:100%;align:left" ><input type="radio" name="transitionName" value="${step }">${step }</td>
	</tr>
	</c:forEach>
</table>

			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="�ύ"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>