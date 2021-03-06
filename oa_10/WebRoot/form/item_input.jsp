<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>输入表单域条目</title>
</head>
<body>
<center>
<form action="flowform.do" method="post">
<input type="hidden" name="method" value="addItem">
<input type="hidden" name="id" value="${field.id}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">输入表单域条目</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
<c:forEach begin="0" end="20" var="i">
	<tr>
		<td class="tdEditLabel" >文本</td>			
		<td class="tdEditContent"><input type="text" name="items[${i}].label" value="${field.items[i].label }">
		</td>
		<td class="tdEditLabel" >值</td>			
		<td class="tdEditContent"><input type="text" name="items[${i}].value" value="${field.items[i].value }"></td>
	</tr>
</c:forEach>
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
				class="MyButton" value="保存表单域条目信息">
			<input type="button" class="MyButton"
				value="关闭窗口" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>