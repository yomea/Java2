<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<script src="/chat/js/jquery-1.8.3.js" type="text/javascript"></script>
<style type="text/css">
	.main{ position:fixed; height:100%; width:100%; background:#F00;}
	#mainBox{ width: 300px; margin:20% auto; background-color:#0F0;}
	#mainBox input,button{ margin:10px; }
	#mainBox label{ margin:0px 20px 0; }
	#tip{ position: fixed; left:50%; top:50%; display:none; background-color:red;}
</style>

<script type="text/javascript">
	$(function(){
		var $name = $("#name");
		var $password = $("#password");
		$("#tip").ajaxStart(function() {
			$(this).show();
		});
		$("#tip").ajaxStop(function() {
			$(this).html("请求成功!").hide();
		});
		$("#sumit").click(function(){
			if($.trim($name.val()) == ""){
				alert("用户名不能为空！");
				return false;
			}	
			
			if($.trim($password.val()) == ""){
				alert("密码不能为空！");
				return false;
			}
			$.ajax({
				url:"/chat/validation?name="+$name.val()+"&password="+$password.val(),
				type:"GET",
				success: function(data){
					
						alert(data);
						/* if(data.s == "1") {
							alert("jfdh");
							window.location.href="/response";
						}else {
							$name.html("");
							$password.html("");
							alert("用户名或者密码错误！");
						}
							
					
					 */
					
					},
				error: function(jqHXR){
					alert(jqHXR.status);
				}
			});
		});	
	});
</script>
</head>

<body>
    <div class="main">
    	<div id="tip">正在登陆...</div>
        <div id="mainBox">
            <form>
             	<label for="name">姓名：</label>
                <input type="text" id="name" /><br />
                <label for="password">密码：</label>
                <input type="text" id="password" />
                <button id="sumit">提交</button>
            
            </form>
            
        </div>
    </div>
</body>
</html>