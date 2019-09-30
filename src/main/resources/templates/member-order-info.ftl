<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${basePath}/css/font.css">
    <link rel="stylesheet" href="${basePath}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}/js/jquery.form.js"></script>
    <script type="text/javascript" src="${basePath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${basePath}/js/xadmin.js"></script>
    <script type="text/javascript" src="${basePath}/js/jeesns.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="x-body layui-anim layui-anim-up">
    <div class="layui-card">
        <div class="layui-card-header">选择信息</div>
        <div class="layui-card-body">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>信息</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>题目名称</td>
                    <td>${order.memberOrder.item.name}</td>
                </tr>
                <tr>
                    <td>分类名称</td>
                    <td>${order.memberOrder.category.name}</td>
                </tr>
                <tr>
                    <td>教师名称</td>
                    <td>${order.memberOrder.teacher.name}</td>
                </tr>
                <tr>
                    <td>订单类型</td>
                    <td>
                    <#if order.type = 0>
                        个人
                    <#elseif order.type = 1>
                        团队
                    </#if>
                    </td>
                </tr>
                <#if order.type = 0>
                <tr>
                    <td>学生学号</td>
                    <td>${order.memberOrder.member.number}</td>
                </tr>
                <tr>
                    <td>学生名称</td>
                    <td>${order.memberOrder.member.name}</td>
                </tr>
                <tr>
                    <td>学生班级</td>
                    <td>${order.memberOrder.member.className}</td>
                </tr>
                <tr>
                    <td>学生联系电话</td>
                    <td>${order.memberOrder.member.contactPhone}</td>
                </tr>
                <tr>
                    <td>学生联系邮箱</td>
                    <td>${order.memberOrder.member.contactEmail}</td>
                </tr>
                <#elseif order.type = 1>

                </#if>
                <tr>
                    <td>创建时间</td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<xblock>
    <#if canDel == 0>
        <button class="layui-btn layui-btn-danger" onclick="member_del(this,'${order.id}')" href="javascript:;">删除</button>
    <#else >
    <button class="layui-btn layui-btn-disabled"  href="javascript:;"></i>删除</button>
    </#if>
</xblock>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            var url = "${basePath}/member/order/delete/"+id;
            jeesns.jeesnsAjax(url,"GET",null,null);
            $(obj).parents("tr").remove();
        });
    }

</script>
</body>

</html>