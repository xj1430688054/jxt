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
<div class="x-body">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>修改配置信息</legend>
    </fieldset>
    <form class="layui-form jeesns_form" action="${basePath}/config/edit" method="post" >
        <div class="layui-form-item">
            <label class="layui-form-label">学生选择条目 ：</label>
            <div class="layui-input-block">
                <input type="radio" name="IS_OPEN_CHOOSE" value="0" title="开启" <#if IS_OPEN_CHOOSE == "0">checked</#if> >
                <input type="radio" name="IS_OPEN_CHOOSE" value="1" title="关闭" <#if IS_OPEN_CHOOSE == "1">checked</#if> >
            </div>
        </div>
        <hr>
        <div class="layui-form-item">
            <label class="layui-form-label">团队功能 ：</label>
            <div class="layui-input-block">
                <input type="radio" name="IS_OPEN_GROUP" value="0" title="开启" <#if IS_OPEN_GROUP == "0">checked</#if> >
                <input type="radio" name="IS_OPEN_GROUP" value="1" title="关闭" <#if IS_OPEN_GROUP == "1">checked</#if> >
            </div>
        </div>
        <hr>
        <div class="layui-form-item">
            <label class="layui-form-label">开放学生注册 ：</label>
            <div class="layui-input-block">
                <input type="radio" name="IS_OPEN_REGISTER" value="0" title="开启" <#if IS_OPEN_REGISTER == "0">checked</#if> >
                <input type="radio" name="IS_OPEN_REGISTER" value="1" title="关闭" <#if IS_OPEN_REGISTER == "1">checked</#if> >
            </div>
        </div>
        <hr>
        <div class="layui-form-item">
            <label class="layui-form-label">学生删除订单 ：</label>
            <div class="layui-input-block">
                <input type="radio" name="MEMBER_ORDER_DELETE" value="0" title="开启" <#if MEMBER_ORDER_DELETE == "0">checked</#if> >
                <input type="radio" name="MEMBER_ORDER_DELETE" value="1" title="关闭" <#if MEMBER_ORDER_DELETE == "1">checked</#if> >
            </div>
        </div>
        <hr>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <input class="layui-btn" value="修改" type="submit"/>
        </div>
    </form>
</div>
</body>

</html>