var oa = {
	url : {
		input : function() {
			return "/orgnization/input";
		},
		add : function() {
			return "/orgnization/add";
		},
		orgsList : function(id, pid, select) {
			return "/orgnization/topOrgs?id=" + id + "&pid=" + pid + "&select=" + select;
		},
		del : function() {
			return "/orgnization/del";
		}

	},

	openNewWindow : function() {
		window.open(oa.url.input(), "_blank", {
			width : 300,
			height : 300
		});
	},

	ajaxSubmit : function() {
		var decription = $("#decriptionval").val();
		var name = $("#nameval").val();
		var sn = $("#snval").val();
		var pid = $("#setpid").val();
		

		$
				.post(
						oa.url.add(),
						{
							"name" : name,
							"decription" : decription,
							"sn" : sn,
							"pid" : pid
						},
						function(data) {
							var success = data.success;
							if (success) {
								$("#tip").html("<p>add success!</p>").show();
							} else {
								$("#tip").html("<p>add fail!</p>").show();
							}
							window
									.setTimeout(
											function() {
												$("#tip").hide();
												window.close();
												window.opener.location.href = "http://localhost:8080/orgnization/topOrgs";
											}, 1000);
						});
		return false;
	},

	accessSubOrg : function(id, pid, select) {
		window.location.href = oa.url.orgsList(id, pid, select);
	},
	
	del : function(id) {
		var url = oa.url.del();
		$.ajax({
			url : url,
			type:'POST',
			data:{"id" : id},
			dataType : "json",
			success : function(data) {
				var success = data.success;
				if(success == true) {
					$("#tip").html("delete success").show();
					window.location.reload();
				} else {
					$("#tip").html("delete fail,can't delete suporgnization").show();
				}
				window.setTimeout(function() {
					$("#tip").hide();
					
				},1000);
			},
			error : function(request) {
				alert(request);
			}
		});
	}

}