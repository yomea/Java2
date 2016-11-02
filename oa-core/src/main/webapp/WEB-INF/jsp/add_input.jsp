<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="/style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/script/jquery-1.8.3.min.js"></script>
<script language="javascript" src="/script/public.js"></script>
<!-- <script language="javascript" src="/script/jquery.validate-1.13.1.js"></script> -->
<title>添加机构信息</title>
<style type="text/css">
#tip {
	position: fixed;
	top: 50%;
	left: 50%;
	background-color: green;
	font-size: 35px;
	font-weight: bold;
	padding: 10px 10px;
	display: none;
}
</style>

<script type="text/javascript">
	$(function() {
		$("#pidval").click(function() {
			window.open("/orgnization/topOrgs?select=1", "_blank",{width:600, height:500});
		});
	});

	function validation() {
		var nameval = $.trim($("#nameval").val());
		var snval = $.trim($("#snval").val());
		if (nameval == "") {
			alert("机构名不能为空！");
			return false;
		} else if (snval == "") {
			alert("编号不能为空！");
			return false;
		}
		return true;
	}

	/* $("#formvalidate").validate({
		rules : {
			name : {
				required : true
			},
			decription : {
				required : true
			},
			sn : {
				required : true
			}
		},
		submitHandler : function(form) {
			$(form).ajaxSubmit();
		}
	}); */
</script>
</head>
<body>
	<div id="tip"></div>
	<center>
		<form action="/orgnization/add" method="post"
			onsubmit="return oa.ajaxSubmit();" id="formvalidate">
			<input 	type="hidden" name="pid"  id="setpid"  value="0">
			<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0"
				style="width: 580px;">
				<TBODY>
					<TR>
						<!-- 这里是添加、编辑界面的标题 -->
						<td align="center" class="tdEditTitle">添加机构信息</TD>
					</TR>
					<TR>
						<td>
							<!-- 主输入域开始 -->
							<table class="tableEdit" style="width: 580px;" cellspacing="0"
								border="0" cellpadding="0">
								<tr>
									<td class="tdEditLabel">机构名称</td>
									<td class="tdEditContent"><input type="text" name="name"
										id="nameval"></td>
									<td class="tdEditLabel">机构描述</td>
									<td class="tdEditContent"><input type="text"
										name="decription" id="decriptionval"></td>
									<td class="tdEditLabel">机构编号</td>
									<td class="tdEditContent"><input type="text" name="sn"
										id="snval"></td>
									<td class="tdEditLabel">所属机构</td>
									<td class="tdEditContent"><input type="button" 
										id="pidval" value="select"></td>
										<td class="tdEditContent"><input type="text" id="orgName" name="orgName"
										></td>
								</tr>
							</table> <!-- 主输入域结束 -->
						</td>
					</TR>
				</TBODY>
			</TABLE>

			<TABLE>
				<TR align="center">
					<TD colspan="3" bgcolor="#EFF3F7"><input type="submit"
						name="saveButton" class="MyButton" value="保存机构信息"
						onclick="return validation();"> <input type="button"
						class="MyButton" value="关闭窗口" onclick="window.close()"></TD>
				</TR>
			</TABLE>
		</form>
	</center>
</body>
</html>