<!doctype html>
<html lang="en">
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
            window.location.href = '${basePath}/index/';
        }
    </script>
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">用户登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form jeesns_form" action="${basePath}/member/login" method="post" callback="_success">
        <#--<input type="hidden" name="redirectUrl" value="${redirectUrl}">-->
        <hr class="hr20" >
        <div class="form-group">
            学号
            <input type="text" name="number" class="form-control layui-input" placeholder="学号" data-type="require">
        </div>
        <hr class="hr20" >
        <div class="form-group">
            密码
            <input type="password" id="password" name="password" class="form-control layui-input" placeholder="密码" data-type="require">
        </div>
        <hr class="hr20" >
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
    <a href="${basePath}/member/register">我要注册</a>
</div>

</body>
</html>