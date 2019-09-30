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
    <script>
        var _success = function () {
            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);
        }
    </script>
</head>

<body>
<div class="x-body layui-anim layui-anim-up">
    <form class="layui-form jeesns_form" action="${basePath}/member/order/add" method="post" callback="">
        <div lass="layui-form-item layui-form-text">
            <label class="layui-form-label">
                <span class="x-red">*</span>条目名称
            </label>
            <div >
                <h1>${item.name}</h1>
            </div>
        </div>
        <hr>
        <div lass="layui-form-item layui-form-text">
            <label class="layui-form-label">
                <span class="x-red">*</span>分类名称
            </label>
            <div >
                <h1>${category.name}</h1>
            </div>
        </div>
        <hr>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">
                选择分类：
            </label>
            <div class="layui-input-inline">
                <select name="memberOrder.teacher.id" >
                     <#list category.teachers as teacher>
                         <option  value="${teacher.id}">${teacher.name}</option>
                     </#list>
                </select>
            </div>
        </div>
        <hr>
        <input type="hidden" name="type" value="0">
         <#--value="${loginMember.name}"-->
        <input type="hidden" name="memberOrder.member.id" value="${loginMember.id}">
        <input type="hidden" name="memberOrder.item.id" value="${item.id}">
        <input type="hidden" name="memberOrder.category.id" value="${category.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <input class="layui-btn" value="增加" style="width:100%;" type="submit"/>
        </div>
    </form>
</div>
</body>

</html>