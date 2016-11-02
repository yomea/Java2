var seckill = {
	// 封装秒杀相关的ajax的url
	URL : {
		now : function() {
			return "/seckill/time/now";
		},
		exposer : function(seckillId) {
			return "/seckill/" + seckillId + "/exposer";
		},
		execution : function(seckillId, md5) {
			return "/seckill/" + seckillId + "/" + md5 + "/execution";
		}
	},

	handlerSeckillKill : function(seckillId, node) {
		// 执行秒杀逻辑
		node
				.hide()
				.html(
						"<button class='btn btn-primary btn-lg' id='killBtn'>开始秒杀</button>");
		$.post(seckill.URL.exposer(seckillId), function(result) {
			if(result && result["success"]) {
				var exposer = result["data"];
				if(exposer['exposed']) {
					var md5 = exposer['md5'];
					var killUrl = seckill.URL.execution(seckillId, md5);
					console.log("killUrl = " + killUrl);
					$("#killBtn").one("click", function() {
						//bootstrap的css样式,先禁用按钮
						$(this).addClass("disabled");
						//发送秒杀请求，执行秒杀
						$.post(killUrl, function(result) {
							if(result && result['success']) {
								var killResult = result["data"];
								var state = killResult["state"];
								var info = killResult["info"];
								//显示秒杀结果
								node.html("<span class='label label-success'>"+ info +"</span>");
							} else {
								console.log("result = " + result);
							}
						});
					});
					node.show();
				} else {
					//可能存在客户端时间的差异，需要判断，再计时
					var now = exposer["now"];
					var start = exposer["start"];
					var end = exposer["end"];
					seckill.countdown(seckillId, now, start, end);
				}
			}
		});

	},

	validatePhone : function(phone) {
		if (phone && phone.length == 11 && !isNaN(phone)) {
			return true;
		} else {
			return false;
		}
	},

	countdown : function(seckillId, nowTime, startTime, endTime) {
		var seckillBox = $("#seckill-box");
		// 时间判断
		if (nowTime > endTime) {
			// 秒杀结束
			seckillBox.html("秒杀结束!");
		} else if (nowTime < startTime) {
			// 秒杀未开始
			var killTime = new Date(startTime + 1000);
			seckillBox.countdown(killTime, function(event) {
				// 控制时间的格式
				var format = event.strftime("秒杀倒计时：%D天 %H时 %M分 %S秒");
				seckillBox.html(format);
				// 绑定秒杀倒计时完成后的操作
			}).on("finish.countdown", function() {
				// 控制秒杀逻辑，执行秒杀
				seckill.handlerSeckillKill(seckillId, seckillBox);
			});
		} else {
			// 秒杀开始
			seckill.handlerSeckillKill(seckillId, seckillBox);
		}
	},

	// 封装秒杀相关的详情页
	detail : {

		init : function(params) {
			// 手机验证等交互信息
			var killPhone = $.cookie("killPhone");
			if (!seckill.validatePhone(killPhone)) {
				var killPhoneModal = $('#killPhoneModal');

				killPhoneModal.modal({
					show : true, // 显示弹出层
					backdrop : 'static', // 禁止位置关闭
					keyboard : false
				// 关闭键盘事件
				});
				$("#killPhoneBtn")
						.click(
								function() {
									var inputPhone = $("#killPhoneKey").val();
									if (seckill.validatePhone(inputPhone)) {
										$.cookie("killPhone", inputPhone, {
											expires : 7,
											path : "/seckill"
										});
										window.location.reload();
									} else {
										$("#killPhoneMessage")
												.hide()
												.html(
														"<label class='label label-danger'>手机号错误！</label>")
												.show(300);
									}
								});

			} else {
				var startTime = params['startTime'];
				var endTime = params['endTime'];
				var seckillId = params['seckillId'];
				$.get(seckill.URL.now(), function(result) {
					if (result && result["success"]) {
						var nowTime = result["data"];
						seckill.countdown(seckillId, nowTime, startTime,
								endTime);
					} else {
						console.log(result);
					}
				});
			}

		}

	}

}