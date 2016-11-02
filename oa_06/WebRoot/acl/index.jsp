<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/aclManager.js"></script>
<script type="text/javascript">
//��Ȩ
function addOrUpdatePermission(field){

	//�����ѡ���ϣ���ͬʱѡ����"���̳�"��"����"checkbox
	if(field.checked){
		$(field.resourceSn+"_USE").checked = true;
		<c:if test="${aclForm.principalType eq 'User' }">
		$(field.resourceSn+"_EXT").checked = true;
		</c:if>
	}

	aclManager.addOrUpdatePermission(
		"${aclForm.principalType}",
		${aclForm.principalSn},
		field.resourceSn,
		field.permission,
		field.checked
	);
}

//�����û��ļ̳�����
function addOrUpdateExtends(field){
	aclManager.addOrUpdateUserExtends(
		${aclForm.principalSn},
		field.resourceSn,
		!field.checked
	);
}

//�������checkbox
function usePermission(field){
	//���checkbox��ѡ�У���ζ����Ҫ����ACL��״̬
	//����C/R/U/D�Լ�Extends״̬
	
	//����Ϊͬ����ʽ���Ա�DWR���η�����������
	dwr.engine.setAsync(false);
	
	if(field.checked){
		addOrUpdatePermission($(field.resourceSn+"_C"));
		addOrUpdatePermission($(field.resourceSn+"_R"));
		addOrUpdatePermission($(field.resourceSn+"_U"));
		addOrUpdatePermission($(field.resourceSn+"_D"));
		<c:if test="${aclForm.principalType eq 'User' }">
		addOrUpdateExtends($(field.resourceSn+"_EXT"));
		</c:if>
	}else{
		aclManager.delPermission(
			"${aclForm.principalType}",
			${aclForm.principalSn},
			field.resourceSn		
		);
		$(field.resourceSn+"_C").checked = false;
		$(field.resourceSn+"_R").checked = false;
		$(field.resourceSn+"_U").checked = false;
		$(field.resourceSn+"_D").checked = false;
		<c:if test="${aclForm.principalType eq 'User' }">
		$(field.resourceSn+"_EXT").checked = false;
		</c:if>
	}
}

function initTable(){
	aclManager.searchAclRecord(
		"${aclForm.principalType}",
		${aclForm.principalSn},
		function(datas){
			for(var i=0; i < datas.length; i++){
				var resourceSn = datas[i][0];
				var cState = datas[i][1];
				var rState = datas[i][2];
				var uState = datas[i][3];
				var dState = datas[i][4];
				var extState = datas[i][5];
				
				$(resourceSn+"_C").checked = cState == 0 ? false : true;
				$(resourceSn+"_R").checked = rState == 0 ? false : true;
				$(resourceSn+"_U").checked = uState == 0 ? false : true;
				$(resourceSn+"_D").checked = dState == 0 ? false : true;
				<c:if test="${aclForm.principalType eq 'User' }">
				$(resourceSn+"_EXT").checked = extState == 0 ? true : false;
				</c:if>
				$(resourceSn+"_USE").checked = true;
			}
		}
	);
}

</script>
<c:choose>
	<c:when test="${aclForm.principalType eq 'Role' }">
		<c:set var="title" value="�����ɫ��${role.name }����Ȩ"/>
	</c:when>
	<c:otherwise>
		<c:set var="title" value="����û���${user.person.name }����Ȩ"/>
	</c:otherwise>
</c:choose>
<title>${title }</title>
</head>
<body onload="initTable()">
<center>
<form action="person.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">${title }</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->

<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	
	<tr>
		<td class="tdEditLabel" >����ģ��</td>			
		<td class="tdEditContent">����ģ��</td>
		<td class="tdEditLabel" >Ȩ��</td>
	<c:if test="${aclForm.principalType eq 'User' }">
		<td class="tdEditLabel" >���̳�</td>
	</c:if>
		<td class="tdEditLabel" >����</td>
	</tr>
	
	<!-- ���ģ���� -->
	<c:forEach items="${modules }" var="module">
	<tr>
		<td>${module.name }</td>
		<td></td>
		<td>
		<input type="checkbox" id="${module.id }_C" onclick="addOrUpdatePermission(this)" resourceSn="${module.id }" permission="0">C
		<input type="checkbox" id="${module.id }_R" onclick="addOrUpdatePermission(this)" resourceSn="${module.id }" permission="1">R
		<input type="checkbox" id="${module.id }_U" onclick="addOrUpdatePermission(this)" resourceSn="${module.id }" permission="2">U
		<input type="checkbox" id="${module.id }_D" onclick="addOrUpdatePermission(this)" resourceSn="${module.id }" permission="3">D
		</td>
	<c:if test="${aclForm.principalType eq 'User' }">
		<td><input type="checkbox" id="${module.id }_EXT"  onclick="addOrUpdateExtends(this)" resourceSn="${module.id }"></td>
	</c:if>
		<td><input type="checkbox" id="${module.id }_USE" onclick="usePermission(this)" resourceSn="${module.id }"></td>
	</tr>
	<c:forEach items="${module.children }" var="child">
	<tr>
		<td></td>
		<td>${child.name }</td>
		<td>
		<input type="checkbox" id="${child.id }_C" onclick="addOrUpdatePermission(this)" resourceSn="${child.id }" permission="0">C
		<input type="checkbox" id="${child.id }_R" onclick="addOrUpdatePermission(this)" resourceSn="${child.id }" permission="1">R
		<input type="checkbox" id="${child.id }_U" onclick="addOrUpdatePermission(this)" resourceSn="${child.id }" permission="2">U
		<input type="checkbox" id="${child.id }_D" onclick="addOrUpdatePermission(this)" resourceSn="${child.id }" permission="3">D
		</td>
	<c:if test="${aclForm.principalType eq 'User' }">
		<td><input type="checkbox" id="${child.id }_EXT" onclick="addOrUpdateExtends(this)" resourceSn="${child.id }"></td>
	</c:if>
		<td><input type="checkbox" id="${child.id }_USE" onclick="usePermission(this)" resourceSn="${child.id }"></td>
	</tr>
	</c:forEach>
	</c:forEach>
</table>

			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>