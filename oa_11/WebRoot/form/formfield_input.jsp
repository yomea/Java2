<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>�������</title>
</head>
<body>
<center>
<form action="flowform.do" method="post">
<input type="hidden" name="method" value="addFormField">
<input type="hidden" name="id" value="${formfield.id}">
<input type="hidden" name="formId" value="${flowFormForm.formId}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">�������</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >��ǩ</td>			
		<td class="tdEditContent"><input type="text" name="fieldLabel">
		</td>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent"><input type="text" name="fieldName"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >����</td>			
		<td class="tdEditContent">
		<select name="fieldTypeId">
		<c:forEach items="${fieldtypes }" var="ft">
		<option value="${ft.id }">${ft.name }</option>
		</c:forEach>
		</select>
		</td>
		<td class="tdEditLabel" >������ʽ</td>			
		<td class="tdEditContent">
		<select name="fieldInputId">
		<c:forEach items="${fieldinputs }" var="fi">
		<option value="${fi.id }">${fi.name }</option>
		</c:forEach>
		</select>		
		</td>
	</tr>
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
				class="MyButton" value="���������Ϣ">
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>