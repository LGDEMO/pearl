var SmsMgrTableAjax = function(){
    return{
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }

            // begin first table
            var oTable = $('#example').dataTable({
                "bJQueryUI" : true, //是否使用 jQury的UI theme
                "aLengthMenu" : [10,20, 40, 60], //更改显示记录数选项
                "oLanguage": { // 语言设置
                    "sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sZeroRecords": "抱歉， 没有找到",
                    "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                    "sInfoEmpty": "没有数据",
                    "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                    "sZeroRecords": "没有检索到数据",
                    "sSearch": "搜索:",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "前一页",
                        "sNext": "后一页",
                        "sLast": "尾页"
                    }
                }
            });

        }
    };
}();

