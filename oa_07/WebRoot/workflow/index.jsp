<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>���̹���</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
      <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7> ���̹���<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
            <TD align=middle width=11 background=images/title_middle.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
            <TD align=middle background=images/title_right.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT> </TD>
          </TR>
        </TBODY>
      </TABLE>
      <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD width="82%" height=14 align=right vAlign=center noWrap>
            </TD>
            <TD width="18%" align=right vAlign=center noWrap>��</TD>
          </TR>
          <TR>
            <TD height=14 align=right vAlign=center noWrap>
            	<!-- ����������ѯ�� -->
            </TD>
            <TD height=14 align="left" vAlign=center noWrap>

            </TD>
          </TR>
          <TR>
            <TD height=28 colspan="2" align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
            <!-- ��������������ҳ������ -->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
          <!-- �б������ -->
	      <tr bgcolor="#EFF3F7" class="TableBody1">
		      <td width="5%" height="37" align="center"><b>���</b></td>
		      <td width="80%" height="37" align="center"><B>��������</B></td>
              <td width="15%" height="37" align="center"><b>����</b></td>
          </tr>
          <!-- �б������� -->
          <c:if test="${!empty workflows}">
          <c:forEach items="${workflows }" var="workflow">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		      <td align="center" vAlign="center">${workflow.id }</td>
	          <td align="center" vAlign="center">${workflow.name }</td>
	          <td align="center" vAlign="center">
	          <a href="#" onclick="del('workflow.do?method=del&id=${workflow.id }');">ɾ��</a>
	          </td>
        </tr>
        </c:forEach>
		</c:if>
        <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	    <c:if test="${empty workflows}">
	    <tr>
	    	<td colspan="7" align="center" bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
	    	û���ҵ���Ӧ�ļ�¼
	    	</td>
	    </tr>
	    </c:if>
      </table>
      <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD height=28 align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
            <!-- ��������������ҳ������ -->


    		</TD>
          </TR>
        </TBODY>
      </TABLE>
<form action="workflow.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="method" value="add">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">��ӻ������ϴ����̶����ļ���ͼƬ</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
				��ѡ���ϴ������̶����ļ���<input type="file" name="processDefinition"> <br>
				��ѡ���ϴ������̶���ͼƬ��<input type="file" name="processImage"> <br>
				<input type="submit" name="submit1" value="�ϴ�">
			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

</form>      
</center>

</body>

</html>
