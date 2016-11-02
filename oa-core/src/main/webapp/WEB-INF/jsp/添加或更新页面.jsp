<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>添加人员信息</title>
</head>
<body>
<center>
<form action="person.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">添加人员信息</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->

<input type="hidden" name="method" value="add">
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >所属机构</td>			
		<td class="tdEditContent"><input type="text" 
		id="partyNameId" disabled="disabled">
		<input type="hidden" name="partyId" id="partyIdId">
		<input type="button" value="选择" 
		onclick="openWin('person.do?method=selectParties','selectparties',800,600,1);">
		</td>
		<td class="tdEditLabel" >姓名</td>			
		<td class="tdEditContent"><input type="text" name="name"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >性别</td>			
		<td class="tdEditContent"><input type="text" name="sex">
		</td>
		<td class="tdEditLabel" >年龄</td>			
		<td class="tdEditContent"><input type="text" name="age"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >电话</td>			
		<td class="tdEditContent"><input type="text" name="phone">
		</td>
		<td class="tdEditLabel" >地址</td>			
		<td class="tdEditContent"><input type="text" name="address"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >描述</td>			
		<td class="tdEditContent" colspan="3"><input type="text" name="description">
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
				class="MyButton" value="保存人员信息"> 
			<input type="button" class="MyButton"
				value="关闭窗口" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>