//短信管理表格
var SmsMgrTableAjax=function () {
    return {
        //main function to initiate the module
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }

            // begin first table
            var oTable = $('#smstable').dataTable({
                "sDom": "<'row'<'col-md-6 col-sm-12'l><'col-md-12 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",
                "bProcessing": true,
                "bServerSide": true,
                "bPaginate": true,
                "bFilter": false,
                "bAutoWidth": false,
                "bLengthChange": false,
                "aaSorting": [[5, "desc"]],
                "sAjaxSource": "../sms/info",
                "fnServerData": retrieveData,
                "iDisplayLength": 10,
                "sPaginationType": "bootstrap",
                "aoColumns": [
                    { "mData": "name"},
                    { "mData": "org.name"},
                    { "mData": "surplus"},
                    { "mData": "sended"},
                    { "mData": "lastrchgnum"},
                    { "mData": "lastrchgtime",
                        "mRender" : function(data, display,full) {
                            if (full.lastrchgtime) {
                                return full.lastrchgtime;
                            } else {
                                return '';
                            }
                        }
                    },
                    { "mData": "lastsendtime",
                        "mRender":function(data, display,full){
                            if(full.lastsendtime){
                                return full.lastsendtime;
                            }else{
                                return  '暂无发送记录';
                            }
                        }
                    },
                    {
                        "mData": null,
                        "sDefaultContent":$("#rchg").html()+"|"+$("#rchghis").html()+"|"+$("#edit").html()+"|"+$("#delete").html()
                    }
                ],
                "aoColumnDefs": [
                    { "bSortable": false, "aTargets": [1,7] },
                ],
                "oLanguage": {
                    "sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sZeroRecords": "没有检索到数据",
                    "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                    "sInfoEmtpy": "没有数据",
                    "sProcessing": '<i class="fa fa-coffee"></i>&nbsp;正在加载数据...',
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "前一页",
                        "sNext": "后一页",
                        "sLast": "尾页"
                    }
                }
            });

            //数据获取函数
            function retrieveData( sSource, aoData, fnCallback, oSettings ) {
                aoData.push( { "name": "pageNumber", "value": Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ) } );
                aoData.push( { "name": $("#scontent").attr("name"), "value": $("#scontent").val() });
                aoData.push( { "name":"search_lft","value": $('#lft').val() });
                aoData.push( { "name":"search_rgt","value": $('#rgt').val() });
                $.ajax( {
                    "dataType": 'json',
                    "type": "POST",
                    "contentType": "application/json",
                    "url": sSource,
                    "data": JSON.stringify(aoData),
                    "cache": false,
                    "success" : function(response) {
                        if(response != null && response.aaData != null){
                            var list = response.aaData;
                            for(var i=0;i<list.length;i++){
                                list[i].DT_RowId = list[i].id;
                            }
                            fnCallback(response);
                        }else{
                            alert(response.desp);
                        }
                    }
                } );
            }

            $("#stitle").change( function () {
                $("#scontent").attr("name",$(this).val());
            } );

            $("#sbutton").click( function () {
                oTable.fnDraw();
            } );

            //取消
            $('#templettable a.cancel').live('click', function (e) {
                e.preventDefault();
            });

            //删除
            $('#smstable a.delete').live('click', function (e) {
                e.preventDefault();
                if (confirm("确定要删除吗 ?") == false) {
                    return;
                }
                var nRow = $(this).parents('tr')[0];
                var data = "id=" + nRow.id;
                delData(oTable, nRow, data);

            });

            //删除
            function delData( oTable, nRow, data ) {
                $.ajax( {
                    "dataType": 'json',
                    "type": "POST",
                    "url": "../sms/info/delete",
                    "data": data,
                    "cache": false,
                    "success" : function(response) {
                        if(response != null && response.ret == '0'){
                            oTable.fnDeleteRow(nRow);
                        }else{
                            alert(response.desp);
                        }
                    }
                } );
            }

            //编辑
            $('#smstable a.edit').live('click', function (e) {
                e.preventDefault();
                var nRow = $(this).parents('tr')[0];
                var data = "id=" + nRow.id;
                getSms(data);
                $('#modal_editsms').modal('show');
            });
            function getSms(data){
                $.ajax( {
                    "dataType": 'json',
                    "type": "POST",
                    "url": "../sms/info/getOneSms",
                    "data": data,
                    "cache": false,
                    "success" : function(response) {
                        if(response != null){
                            $("#editid").val(response.id);
                            $("#editname").val(response.name);
                            $('#editallorg').combotree("setValue",response.org.id);
                            $('#editoverdraft').val(response.overdraft);
                            $('#edit_account_id').val(response.account_id);
                            $('#edit_account_key').val(response.account_key);
                        }else{
                            alert('获取数据失败');
                        }
                    }
                } );
            }

            //充值
            $('#smstable a.rchg').live('click', function (e) {
                e.preventDefault();
                var nRow = $(this).parents('tr')[0];
                var data = "id=" + nRow.id;
                getRchgSms(data);
                $('#modal_rchgsms').modal('show');
            });

            function getRchgSms(data){
                $.ajax( {
                    "dataType": 'json',
                    "type": "POST",
                    "url": "../sms/info/getOneSms",
                    "data": data,
                    "cache": false,
                    "success" : function(response) {
                        if(response != null){
                            $("#rchgid").val(response.id);
                            $("#rchgname").val(response.name);
                            $('#surplus').val(response.surplus);
                            $('#sended').val(response.sended);
                        }else{
                            alert('获取数据失败');
                        }
                    }
                } );
            }

            //充值记录
            $('#smstable a.rchghis').live('click', function (e) {
                e.preventDefault();
                var nRow = $(this).parents('tr')[0];
                createRchgHisDatable(nRow.id);
                $('#modal_rchglog').modal('show');
            });


            //充值记录表格
            function createRchgHisDatable(id){
                var oTable = $('#rchglogtable').dataTable({
                    "sDom": "<'row'<'col-md-6 col-sm-12'l><'col-md-12 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",
                    "bDestroy":true,
                    "bProcessing": true,
                    "bServerSide": true,
                    "bPaginate": true,
                    "bFilter": false,
                    "bAutoWidth": false,
                    "bLengthChange": false,
                    "aaSorting": [[2, "desc"]],
                    "sAjaxSource": "../sms/info/findRchglog",
                    "fnServerData": retrieveData,
                    "iDisplayLength": 4,
                    "sPaginationType": "bootstrap",
                    "aoColumns": [
                        { "mData": "smsmgr.name"},
                        { "mData": "rchgnum"},
                        { "mData": "rchgtime",
                            "mRender" : function(data, display,full) {
                                if (full.rchgtime) {
                                    return full.rchgtime;
                                } else {
                                    return '';
                                }
                            }
                        },
                        { "mData": "account"}
                    ],
                    "aoColumnDefs": [{ "bSortable": false, "aTargets": [0]},],
                    "oLanguage": {
                        "sLengthMenu": "每页显示 _MENU_ 条记录",
                        "sZeroRecords": "没有检索到数据",
                        "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                        "sInfoEmtpy": "没有数据",
                        "sProcessing": '<i class="fa fa-coffee"></i>&nbsp;正在加载数据...',
                        "oPaginate": {
                            "sFirst": "首页",
                            "sPrevious": "前一页",
                            "sNext": "后一页",
                            "sLast": "尾页"
                        }
                    }
                });

                //数据获取函数
                function retrieveData( sSource, aoData, fnCallback, oSettings ) {
                    aoData.push( { "name": "pageNumber", "value": Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ) } );
                    aoData.push( { "name": "search_EQ@smsmgr_id", "value": id });
                    $.ajax( {
                        "dataType": 'json',
                        "type": "POST",
                        "contentType": "application/json",
                        "url": sSource,
                        "data": JSON.stringify(aoData),
                        "cache": false,
                        "success" : function(response) {
                            console.log(response);
                            if(response != null && response.aaData != null){
                                var list = response.aaData;
                                for(var i=0;i<list.length;i++){
                                    list[i].DT_RowId = list[i].id;
                                }
                                fnCallback(response);
                            }else{
                                alert(response.desp);
                            }
                        }
                    } );
                }
            }
        }
    };
}();
