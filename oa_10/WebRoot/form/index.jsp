<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>�������̱�</title>
</head>
<body>
<center>
<form action="flowform.do" method="post">
<input type="hidden" name="method" value="addForm">
<input type="hidden" name="id" value="${flowForm.id }">
<input type="hidden" name="workflowId" value="${workflow.id}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">���������̡�${workflow.name }���ı�</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
<c:if test="${empty flowForm.template }">
<c:set var="tmp" value="document_form.ftl"/>
</c:if>
<c:if test="${!empty flowForm.template }">
<c:set var="tmp" value="${flowForm.template}"/>
</c:if>
	<tr>
		<td class="tdEditLabel" >��ģ��</td>			
		<td class="tdEditContent"><input type="text" name="template" value="${tmp}">
		</td>
		<td class="tdEditLabel" ></td>			
		<td class="tdEditContent"></td>
	</tr>
</table>

<c:if test="${!empty flowForm }">
<hr>
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr bgcolor="#EFF3F7" class="TableBody1">
		<td width="20%"><B>��ǩ</B></td>			
		<td width="20%"><B>����</B></td>
		<td width="20%" ><B>����</B></td>			
		<td width="20%"><B>������ʽ</B></td>
		<td width="20%"><B>����</B></td>
	</tr>
	<c:forEach items="${flowForm.fields }" var="field">
	<tr>
		<td >${field.fieldLabel }</td>			
		<td >${field.fieldName }</td>
		<td >${field.fieldType.name }</td>			
		<td >${field.fieldInput.name }</td>
		<td>
		<a href="#" onclick="del('flowform.do?method=delField&id=${field.id}')">ɾ��</a>
		<a href="#" onclick="openWin('flowform.do?method=addItemInput&id=${field.id }','additem',700,600)">��Ŀ</a>
		</td>
	</tr>
	</c:forEach>
</table>
</c:if>
			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="�������Ϣ">
			<c:if test="${!empty flowForm }">
			<input type="button" class="MyButton"
				value="��ӱ���" onclick="openWin('flowform.do?method=formFieldInput&formId=${flowForm.id }','addformfield',600,200)">
			</c:if>
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>