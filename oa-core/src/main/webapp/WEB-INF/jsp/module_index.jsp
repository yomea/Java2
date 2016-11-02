<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="/style/oa.css" rel="stylesheet" type="text/css">
<link href="/style/pagination.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/script/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/script/jquery.pagination.js"></script>
<script type="text/javascript" src="/script/public.js"></script>

<title>机构管理</title>
<style type="text/css">
#tip {
	position: fixed;
	left: 45%;
	top: 45%;
	background-color: green;
	padding: 5px;
	display: none;
}
</style>

<script type="text/javascript">
$(function(){
		//总记录
		var num_entries = ${pager.totalRecords};
		
		var select = 0;
		<c:if test="${! empty param.select}">
			select = ${param.select}
		</c:if>
		// 创建分页
		$("#pager").pagination(num_entries, {
			num_edge_entries: 1,//主题与边缘开始出现省略号如：1...234...1,如果是二：12...3456...78
			num_display_entries: 5, //主体页数1...23456...7
			current_page : ${pager.currentPage} - 1,
			items_per_page: ${pager.pageSize}, //每页显示项数
			prev_text : '上一页',
			next_text : '下一页',
			callback: pageselectCallback
		});
		
	function pageselectCallback(page_index, jq){
		
		var url = "/orgnization/orgs?currentPage=" + (page_index + 1)  + "&id=" + ${id};
		$.get(url, function(data) {
			var string = "";
			if(data.data == null) {
				$("#hehe").html("<td colspan='5' style='text-align:center;'>没有记录!</td>");
			} else {
				$.each(data.data, function(index, e) {
					string += '<tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor = ' + '#DEE7FF'+ ';" onmouseout="this.bgColor=' + '#EFF3F7'+';">'
					+ '<td align="center" vAlign="center">'+ e.id +'</td>' + 
					 +  '<td align="center" vAlign="center">">'+  +'</a></td>'
					 +  '<td align="center" vAlign="center"><a href="javascript:oa.accessSubOrg('+ e.id +',' +(e.parent == null ? 0 : ${id}) +','+ select + ');">'+e.name+'</a></td>'
					 +   ' <td align="center" vAlign="center">'+e.sn+'</td>';
					 if(e.parent != null) {
						 string +=  ' <td align="center" vAlign="center">'+e.parent.name+'</td>';
					 } else {
						 string +=  ' <td align="center" vAlign="center">'+'&nbsp;&nbsp;'+'</td>';
					 }
					
					  if(select == 1) {
						  string +=   '  <td align="center" vAlign="center">'
								 +   '<input type="radio" onclick="set(this);" name="select" value="'+ e.name +'" id="'+ e.id +'" /></td>'
								 +'</tr>';
					 }  else {
					string +=   '  <td align="center" vAlign="center">'
					 +   '<a id="delete" href="javascript:oa.del('+ e.id +')") >删除</a></td>'
					 +'</tr>';
						 
					 }
				});
			 $("#hehe").html(string);
			}
		});
		return false;
	}
});

function set(myself) {
	window.opener.document.getElementById("orgName").value = myself.value;
	window.opener.document.getElementById("setpid").value = myself.id;
	window.close();
}
</script>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0
	marginheight="0" marginwidth="0">
	<center>
		<TABLE width="778" border=0 cellPadding=0 cellSpacing=0
			borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
			<TBODY>
				<TR height=35>
					<TD align=middle width=20 background=images/title_left.gif
						bgColor=#dee7ff></TD>
					<TD align=middle width=120 background=images/title_left.gif
						bgColor=#dee7ff><FONT color=#f7f7f7> 机构管理<font
							color="#FFFFFF">&nbsp;</font></FONT></TD>
					<TD align=middle width=11 background=images/title_middle.gif
						bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT></TD>
					<TD align=middle background=images/title_right.gif bgColor=#dee7ff><FONT
						color=#f7f7f7>&nbsp;</FONT></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0
			borderColor=#ffffff style="FONT-SIZE: 10pt">
			<TBODY>
				<TR>
					<TD width="82%" height=14 align=right vAlign=center noWrap></TD>
					<TD width="18%" align=right vAlign=center noWrap></TD>
				</TR>
				<TR>
					<TD height=14 align=right vAlign=center noWrap>
						<!-- 在这里插入查询表单 -->
					</TD>
					<TD height=14 align="left" vAlign=center noWrap>
						<%
							/**
							* 在这里定义“添加”，“查询”等按钮
							* <input type="image" name="find" value="find" src="images/cz.gif">
							* &nbsp;&nbsp;&nbsp;&nbsp; 
							* <a href="#" onClick="openWin('document.do?method=addInput','470')">
							* <img src="images/addpic.gif" border=0 align=absMiddle style="CURSOR: hand"></a>
							*/
						%> <a href="#" onclick="oa.openNewWindow();">添加机构信息</a> <a
						href="/orgnization/topOrgs?id=${pid}&select=${param.select}">返回</a>
					</TD>
				</TR>
				<TR>
					<TD height=28 colspan="2" align=right vAlign=center noWrap
						background=images/list_middle.jpg>&nbsp;&nbsp; <!-- 可以在这里插入分页导航条 -->
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<table width="778" border="0" cellPadding="0" cellSpacing="1"
			bgcolor="#6386d6">
			<!-- 列表标题栏 -->
			<tr bgcolor="#EFF3F7" class="TableBody1">
				<td width="5%" height="37" align="center"><b>序号</b></td>
				<td width="18%" height="37" align="center"><B>机构名称</B></td>
				<td width="18%" height="37" align="center"><b>机构编号</b></td>
				<td width="18%" height="37" align="center"><b>父机构名称</b></td>
				<td width="18%" height="37" align="center"><b>相关操作</b></td>
			</tr>
			<!-- 列表数据栏 -->
			<tbody id="hehe">
			</tbody>
		</table>
		<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0
			borderColor=#ffffff style="FONT-SIZE: 10pt">
			<TBODY>
				<TR>
					<TD height=28 align=right vAlign=center noWrap
						background=images/list_middle.jpg>&nbsp;&nbsp; <!-- 可以在这里插入分页导航条 -->
						<div id="pager" class="pagination"></div>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</center>
	<div id="tip"></div>
</body>

</html>
