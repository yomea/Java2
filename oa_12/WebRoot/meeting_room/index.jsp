<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<script type="text/javascript">
function initTable(){
	<c:forEach items="${applies}" var="apply">
	<c:forEach items="${my:splitApply(apply)}" var="app">
		if(document.getElementById("${app.id}")){
			<c:if test="${app.status eq 'A'}">
				document.getElementById("${app.id}").style.background = "#CC6633";
			</c:if>
			<c:if test="${app.status eq 'O'}">
				document.getElementById("${app.id}").style.background = "#FF0000";
			</c:if>
			document.getElementById("${app.id}").objectId = ${app.oid};
		}
	</c:forEach>
	</c:forEach>
}

function meetingRoomInput(url,field){
	if(field.objectId){
		url = url + "&applyId=" +field.objectId;
	}
	openWin(url,'newwindow',600,400,1);
}
</script>
<title>�������������</title>
</head>
<BODY onload="initTable()" bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
      <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7>�������������<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
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
            <% 
            /**
            * �����ﶨ�塰��ӡ�������ѯ���Ȱ�ť
            * <input type="image" name="find" value="find" src="images/cz.gif">
            * &nbsp;&nbsp;&nbsp;&nbsp; 
            * <a href="#" onClick="openWin('document.do?method=addInput','470')">
            * <img src="images/addpic.gif" border=0 align=absMiddle style="CURSOR: hand"></a>
            */
            %>
			<a href="meetingRoom.do?nav=pre&year=${year }&month=${month }">�ϸ���</a> <a href="meetingRoom.do?nav=next&year=${year }&month=${month }">�¸���</a>
            </TD>
          </TR>
          <TR>
            <TD height=28 colspan="2" align=center vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
            <!-- ��������������ҳ������ -->
              �����ڲ鿴${year }��${month }�µĻ��������
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
          <!-- �б������ -->
	      <tr bgcolor="#EFF3F7" class="TableBody1">
	      	
		      <td width="5%" height="37" align="center"><b>���</b></td>
		      <td width="2%" height="37" align="center"><b></b></td>
		    <c:forEach var="m" begin="1" end="${maxDay}">
		      <td width="3%" height="37" align="center"><B>${m }</B></td>
            </c:forEach>
          </tr>
          <!-- �б������� -->
          <c:if test="${!empty rooms}">
          <c:forEach items="${rooms }" var="room">
          <c:forEach var="d" begin="${beginTime }" end="${endTime }" varStatus="status">
	      <tr bgcolor="#EFF3F7" style="height:5px" >
	      	  <c:if test="${status.first}">
		      <td align="center" vAlign="center" rowspan="${endTime - beginTime + 1 }" ><span style="color:red;font-weight: bold;">${room.sn}</span></td>
		      </c:if>
	          <td align="center" vAlign="center"><span>${d}</span></td>
		      <c:forEach var="m" begin="1" end="${maxDay}">
		      	<td align="center" objectId="" onclick="meetingRoomInput('meetingRoom.do?method=applyInput&sn=${room.sn }&beginDate=${year}-${month}-${m}&beginTime=${d }',this)" id="${room.sn }_${year }-${month }-${m }-${d }" style="cursor:hand;<c:if test="${my:holiday(year,month,m)}">background-color:#CDDDF5</c:if>">
		      	</td>
              </c:forEach>
          </tr>
          </c:forEach>
          </c:forEach>
		  </c:if>
        <!-- ���б�����Ϊ�յ�ʱ��Ҫ��ʾ����ʾ��Ϣ -->
	    <c:if test="${empty rooms}">
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
</center>

</body>

</html>
