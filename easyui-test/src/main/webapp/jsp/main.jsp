<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:false,noheader:true"
		style="height: 60px; background: #666;">
		<div id="logo">后台管理系统</div>
		<div id="options">
			<span>欢迎${ user.username }登陆管理系统</span><a href="/login?action=logout">退出</a>
		</div>
	</div>
	<div data-options="region:'south',split:false,noheader:true"
		style="height: 35px; line-height: 30px">
		<div style="text-align: center; font-weight: bold">&copy;2016-2017
			made by hong</div>
	</div>
	<div data-options="region:'west',title:'导航菜单',split:true"
		style="width: 100px;">
			<ul id="tree"></ul>
		</div>
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
			<div id="tabs">
				<div title="主页"></div>
			</div>
		</div>
</body>
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
</html>