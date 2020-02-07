layui.use(['form','laydate','laypage','layer','table'], function () {
    let form = layui.form
        layer = layui.layer,
        table = layui.table;
    let i=1,j=1,k=1;

    //监听指定开关
    form.on('switch(switchTest)', function(data){
        let id = $(this).data('id');
        let checked = data.elem.checked;
        console.log(id+"的值："+checked)
        if(checked){
            $("#"+id).val(1);
        }else{
            $("#"+id).val(0);
        }
    })


    $('.add-btn').click(function () {
        i++;
        addstrs1(i);
        form.render();
    });

    $('body').on("click",".btn-del",function () {
        var pre = $(this);
        // layer.confirm('确定要删除么？',{
        //     btn:['确定','取消']
        // },function () {
        //     $(pre).parent().parent().remove();
        //     layer.closeAll('dialog');
        // })
        $(pre).parent().parent().remove();
        layer.closeAll('dialog');
    });


    function getRandomNum() {
        return parseInt(Math.random()*50);
    }
    function addstrs1(i) {
        let  iNums = getRandomNum();
        let strs1;
        strs1 = '<tr>\n' +
            '                            <td>\n' +
            '                                <input type="text" name="attrName" class="layui-input">\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <select name="attrType" lay-filter="">\n' +
            '                                     <option value="VARCHAR">VARCHAR</option>\n' +
            '                                     <option value="CHAR">CHAR</option>\n' +
            '                                     <option value="TEXT">TEXT</option>\n' +
            '                                     <option value="INT">INT</option>\n' +
            '                                     <option value="BIGINT">BIGINT</option>\n' +
            '                                     <option value="DECIMAL">DECIMAL</option>\n' +
            '                                     <option value="DATETIME">DATETIME</option>' +
            '                                </select>\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <input type="text" name="minLength" class="layui-input">\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <input type="text" name="maxLength" class="layui-input">\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <input type="text" name="comment" class="layui-input">\n' +
            '                            </td>'+
            '                            <td>\n' +
            '                                <input type="checkbox" data-id="isNull_'+i+'" lay-skin="switch" ' +
            '                                   lay-filter="switchTest" lay-text="ON|OFF" checked>\n' +
            '                                <input type="hidden" id="isNull_'+i+'" name="isNull" value="1">\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <input type="checkbox" data-id="isVisit'+i+'" lay-skin="switch" ' +
            '                                   lay-filter="switchTest" lay-text="ON|OFF" checked>\n' +
            '                                <input type="hidden" id="isVisit'+i+'" name="isVisit" value="1">\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <input type="checkbox" data-id="isSort_'+i+'" lay-skin="switch" ' +
            '                                   lay-filter="switchTest" lay-text="ON|OFF" checked>\n' +
            '                                <input type="hidden" id="isSort_'+i+'" name="isSort" value="1">\n' +
            '                            </td>\n' +
            '                            <td>\n' +
            '                                <input type="checkbox" data-id="isSearch_'+i+'" lay-skin="switch" ' +
            '                                   lay-filter="switchTest" lay-text="ON|OFF" checked>\n' +
            '                                <input type="hidden" id="isSearch_'+i+'" name="isSearch" value="1">\n' +
            '                            </td>\n' +
            '                            <td style="text-align: center">' +
            // '                               <button type="button" class="layui-btn layui-btn-danger btn-del layui-btn-sm">删除</button>' +
            '                               <i class="layui-icon layui-icon-reduce-circle btn-del" style="font-size: 18px; color: #1E9FFF;"></i>' +
            '                           </td>\n' +
            '                        </tr>';
        $('.addlists').append(strs1);
    }
})