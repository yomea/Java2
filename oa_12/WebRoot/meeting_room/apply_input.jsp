<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>���������</title>
</head>
<body>
<center>
<form action="meetingRoom.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">���������</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->

<input type="hidden" name="method" value="save">
<input type="hidden" name="applyId" value="${meetingRoomForm.applyId }">
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >�����ұ��</td>			
		<td class="tdEditContent"><input type="text" name="sn" value="${meetingRoomForm.sn }">
		</td>
		<td class="tdEditLabel" >����ԭ��</td>			
		<td class="tdEditContent"><input type="text" name="applyReason" value="${meetingRoomForm.applyReason }"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >��ʼʱ��</td>			
		<td class="tdEditContent">
		<input type="text" name="beginDate" value="<fmt:formatDate value="${meetingRoomForm.beginDate }" pattern="yyyy-M-d" />">
		<input type="text" style="width:20px" name="beginTime" value="${meetingRoomForm.beginTime }">
		</td>
		<td class="tdEditLabel" >����ʱ��</td>			
		<td class="tdEditContent">
		<input type="text" name="endDate" value="<fmt:formatDate value="${meetingRoomForm.endDate }" pattern="yyyy-M-d" />">
		<input type="text" style="width:20px" name="endTime" value="${meetingRoomForm.endTime }">
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >����״̬</td>			
		<td class="tdEditContent">
		<select name="status">
			<option value="A" <c:if test="${meetingRoomForm.status eq 'A' }">selected</c:if>>����</option>
			<option value="O" <c:if test="${meetingRoomForm.status eq 'O' }">selected</c:if>>ռ��</option>
		</select>
		</td>
		<td class="tdEditLabel" ></td>			
		<td class="tdEditContent">
		
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
				class="MyButton" value="����"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>