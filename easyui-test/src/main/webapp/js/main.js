$(function() {
	$("#tabs").tabs({
		border : false,
		fit : true

	});

	$('#tree').tree({
		url : "/login?action=tree",
		lines : true,
		onSelect : function(node) {
			if (node.state == "open") {
				$('#tabs').tabs('add',{
					title: node.text,
					selected: true,
					url:node.url
					
					
				});
			}

		}
	});

});