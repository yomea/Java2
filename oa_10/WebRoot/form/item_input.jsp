<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>���������Ŀ</title>
</head>
<body>
<center>
<form action="flowform.do" method="post">
<input type="hidden" name="method" value="addItem">
<input type="hidden" name="id" value="${field.id}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">���������Ŀ</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
<c:forEach begin="0" end="20" var="i">
	<tr>
		<td class="tdEditLabel" >�ı�</td>			
		<td class="tdEditContent"><input type="text" name="items[${i}].label" value="${field.items[i].label }">
		</td>
		<td class="tdEditLabel" >ֵ</td>			
		<td class="tdEditContent"><input type="text" name="items[${i}].value" value="${field.items[i].value }"></td>
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
				class="MyButton" value="���������Ŀ��Ϣ">
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>