
//重写alert
window.alert = function(msg, callback){
	parent.layer.alert(msg,{
        skin: 'layui-layer-lan'
        ,closeBtn: 0
        ,anim: 4 //动画类型
	},function(index){
		parent.layer.close(index);
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
};

//重写confirm式样框
window.confirm = function(msg, callback){
	parent.layer.confirm(msg, {btn: ['确定','取消']},
	function(){//确定事件
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
};

//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }

    var selectedIDs = grid.getGridParam("selarrrow");
    if(selectedIDs.length > 1){
    	alert("只能选择一条记录");
    	return ;
    }

    return selectedIDs[0];
}

//选择多条记录
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    return grid.getGridParam("selarrrow");
}

// 遍历nav
function tabNav(){
	$(".warrant_nav ul li").each(function(index){
		$(this).click(function(){
			$(".warrant_nav ul li").removeClass("warrant_active");
			$(this).addClass("warrant_active");
			$(".warrant_main .tree_left").eq(index).show().siblings(".tree_left").stop().hide();
		})
	})
}