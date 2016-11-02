<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<script type="text/javascript">	djConfig = { isDebug: false };</script>
<script language="javascript" src="script/dojo.js"></script>
<script type="text/javascript">  
	dojo.require("dojo.widget.Tree");
	dojo.require("dojo.widget.TreeSelector");
	dojo.require("dojo.widget.TreeBasicController");
	dojo.require("dojo.widget.LinkPane");
	dojo.require("dojo.widget.TabContainer");
	dojo.require("dojo.widget.SplitContainer");
	dojo.require("dojo.widget.LayoutContainer");
</script>
<script type="text/javascript">
dojo.addOnLoad(function() {
	dojo.event.topic.subscribe("nodeSelected",
		 function(message) { 
		 	dojo.widget.byId("contentPane").setUrl("person_tree.do?orgId="+message.node.objectId);
		 }
	);
});
function getSelectedNode(){
	return dojo.widget.byId("treeSelector").selectedNode;
}
function addOrg(){
	var selectedNode = getSelectedNode();
	var url = "org_tree.do?method=addInput";
	if(selectedNode){
		url = url + "&parentId=" + selectedNode.objectId;
	}
	openWin(url,"window123",600,300,1);
}
function addNode(name,id){
	var selectedNode = getSelectedNode();
	var controller = dojo.widget.byId("treeController");
	controller.createChild(selectedNode, 0, {title:name,objectId:id});
	
}
function delOrg(){
	var selectedNode = getSelectedNode();
	if(!selectedNode){
		alert("请选择需要删除的节点！");
	}
	var url = "org_tree.do?method=del&id="+selectedNode.objectId;
	if(openDeleteDialog(url,"请确认是否要删除机构【"+selectedNode.title+"】？")){
		//delete success,update the tree node!
		var controller = dojo.widget.byId("treeController");
		controller.removeNode(selectedNode);
	}
}
</script>
<title>机构管理</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0 marginheight="0" marginwidth="0">
<center>
      <TABLE width="778" border=0 cellPadding=0 cellSpacing=0 borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR height=35>
            <TD align=middle width=20 background=images/title_left.gif 
          bgColor=#dee7ff></TD>
            <TD align=middle width=120 background=images/title_left.gif 
          bgColor=#dee7ff><FONT color=#f7f7f7> 机构管理<font color="#FFFFFF">&nbsp;</font></FONT> </TD>
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
            <TD width="18%" align=right vAlign=center noWrap>　</TD>
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
            %>
            <a href="#" onclick="addOrg();">添加机构信息</a>
            <a href="#" onclick="delOrg();">删除选中机构</a>
            </TD>
          </TR>
          <TR>
            <TD height=28 colspan="2" align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
            <!-- 可以在这里插入分页导航条 -->
            </TD>
          </TR>
        </TBODY>
      </TABLE>
      <table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
          <!-- 列表标题栏 -->
	      <tr bgcolor="#EFF3F7" class="TableBody1">
		      <td width="100%"  align="left">
<div style="WIDTH: 100%; HEIGHT: 400px" dojoType="LayoutContainer">
		      
	  <div dojoType="ContentPane" dojoType="ContentPane" layoutAlign="left"  id="myTreeId" style="overflow:auto;width: 200px;">
		${my:orgTree(pm.datas)}		      
	  </div>
	  <div dojoType="ContentPane" cacheContent="false" layoutAlign="client" style="overflow:auto" id="contentPane"> 
	  </div>
<div>
				  
		      </td>
          </tr>
		
      </table>
      <TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0 borderColor=#ffffff style="FONT-SIZE: 10pt">
        <TBODY>
          <TR>
            <TD height=28 align=right vAlign=center noWrap background=images/list_middle.jpg>&nbsp;&nbsp;
            <!-- 可以在这里插入分页导航条 -->

    		</TD>
          </TR>
        </TBODY>
      </TABLE>
</center>

</body>

</html>
