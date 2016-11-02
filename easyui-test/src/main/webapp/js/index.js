/**
 * 更多详细内容请查阅easyui的官方文档
 */
// 继承自textbox
$(document).ready(function() {
	
	var flag = false;
	
	$('#login').dialog({
		title : '登陆窗口',
		width : 400,
		height : 300,
		modal : true,
		buttons : '#btn',
		closable : false

	});

	$('#username').validatebox({

		required : true,
		validType : 'length[2,5]',
		type : 'text'

	});

	$('#password').validatebox({

		required : true,
		validType : 'length[2,10]',
		type : 'password'

	});

	if (!$('#username').validatebox('isValid')) {
		$('#username').focus();
	} else if (!$('#password').validatebox('isValid')) {
		$('#password').focus();
	}

	$('#submit').linkbutton({
		width : 100,
	});

	$(document).keyup(function(e) {
		if (e.keyCode == 13) {
			if(!flag) {
				$('#submit').trigger("click");
				flag = true;
			}
			
		}
	});

	$('#submit').on('click', function() {
		if (!$('#username').validatebox('isValid')) {
			$('#username').focus();
		} else if (!$('#password').validatebox('isValid')) {
			$('#password').focus();
		} else {
			$.ajax({
				url : '/login',
				type : 'POST',
				data : {
					username : $('#username').val(),
					password : $('#password').val()
				},
				beforeSend : function() {
					$.messager.progress('close');
					$.messager.progress({
						width : 300,
						text : 'login...'

					});
				},
				success : function(data, response, status) {
					$.messager.progress('close');
					if (data.success) {
						location.href = "/jsp/main.jsp";
					} else {
						$.messager.alert('warning', '用户名或者密码错误', "warning", function() {
							flag = false;
						});
						$('#password').select();
						
					}
				}

			});
		}
	});

});
