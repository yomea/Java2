<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>��Ա����</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
      <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7> ��Ա����<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
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
            	<!-- ����������ѯ���� -->
            </TD>
            <TD height=14 align="left" vAlign=center noWrap>
            <% 
            /**
            * �����ﶨ�塰���ӡ�������ѯ���Ȱ�ť
            * <input type="image" name="find" value="find" src="images/cz.gif">
            * &nbsp;&nbsp;&nbsp;&nbsp; 
            * <a href="#" onClick="openWin('document.do?method=addInput','470')">
            * <img src="images/addpic.gif" border=0 align=absMiddle style="CURSOR: hand"></a>
            */
            %>
            <a href="#" onclick="openWin('person.do?method=addInput','addperson',600,200);">������Ա��Ϣ</a>
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
          <!-- �б������� -->
	      <tr bgcolor="#EFF3F7" class="TableBody1">
		      <td width="5%" height="37" align="center"><b>���</b></td>
		      <td width="18%" height="37" align="center"><B>����</B></td>
		      <td width="18%" height="37" align="center"><b>�Ա�</b></td>
		      <td width="18%" height="37" align="center"><b>ְ��</b></td>
              <td width="18%" height="37" align="center"><b>�绰</b></td>
              <td width="18%" height="37" align="center"><b>��������</b></td>
              <td width="5%" height="37" align="center"><b>����</b></td>
          </tr>
          <!-- �б������� -->
          <c:if test="${!empty pm.datas}">
          <c:forEach items="${pm.datas }" var="person">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = '#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		      <td align="center" vAlign="center">${person.id }</td>
	          <td align="center" vAlign="center">${person.name }</td>
	          <td align="center" vAlign="center">${person.sex }</td>
	          <td align="center" vAlign="center">${person.duty }</td>
	          <td align="center" vAlign="center">${person.phone }</td>
	          <td align="center" vAlign="center">${person.org.name }</td>
	          <td align="center" vAlign="center">
			  <c:if test="${my:hasPermission(login.id,'person',3) }">
	          <a href="#" onclick="del('person.do?method=del&id=${person.id }');">ɾ��</a>
			  </c:if>
	          </td>
        </tr>
        </c:forEach>
		</c:if>
        <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	    <c:if test="${empty pm.datas}">
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
<pg:pager items="${pm.total }" url="person.do" export="currentPageNumber=pageNumber">
	<pg:first><a href="${pageUrl}">��ҳ</a></pg:first>
	<pg:prev><a href="${pageUrl }">ǰҳ</a></pg:prev>
	<pg:pages>
		<c:choose>
		<c:when test="${ currentPageNumber eq pageNumber}">
		<font color="red">${pageNumber}</font>
		</c:when>
		<c:otherwise>
		<a href="${pageUrl }">${pageNumber }</a>
		</c:otherwise>
		</c:choose>
	</pg:pages>
	<pg:next><a href="${pageUrl }">��ҳ</a></pg:next>
	<pg:last><a href="${pageUrl }">βҳ</a></pg:last>
</pg:pager>            
    		</TD>
          </TR>
        </TBODY>
      </TABLE>
</center>

</body>

</html>