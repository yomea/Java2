<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>输入表单域</title>
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
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">输入表单域</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >标签</td>			
		<td class="tdEditContent"><input type="text" name="fieldLabel">
		</td>
		<td class="tdEditLabel" >名称</td>			
		<td class="tdEditContent"><input type="text" name="fieldName"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >类型</td>			
		<td class="tdEditContent">
		<select name="fieldTypeId">
		<c:forEach items="${fieldtypes }" var="ft">
		<option value="${ft.id }">${ft.name }</option>
		</c:forEach>
		</select>
		</td>
		<td class="tdEditLabel" >输入形式</td>			
		<td class="tdEditContent">
		<select name="fieldInputId">
		<c:forEach items="${fieldinputs }" var="fi">
		<option value="${fi.id }">${fi.name }</option>
		</c:forEach>
		</select>		
		</td>
	</tr>
</table>
			<!-- 主输入域结束 -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="保存表单域信息">
			<input type="button" class="MyButton"
				value="关闭窗口" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>