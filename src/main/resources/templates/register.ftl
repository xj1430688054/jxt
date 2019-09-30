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
            window.location.href = '${basePath}/member/login';
        }
    </script>
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">用户注册</div>
    <div id="darkbannerwrap"></div>
    <form class="layui-form jeesns_form" action="${basePath}/member/register" method="post" callback="_success">
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" name="name" data-type="require" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>学号
            </label>
            <div class="layui-input-inline">
                <input type="text" name="number" data-type="require" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>系别或学院名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="department.name" data-type="require" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>班级
            </label>
            <div class="layui-input-inline">
                <input type="text" name="className" data-type="require" class="layui-input">
            </div>
            <hr>
            <div>格式如 ： 1502</div>
        </div>
        <hr>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>联系邮箱
            </label>
            <div class="layui-input-inline">
                <input type="text" name="contactEmail"  data-type="require,email" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>联系电话
            </label>
            <div class="layui-input-inline">
                <input type="text" name="contactPhone" data-type="require" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" data-type="require" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>确认密码
            </label>
            <div class="layui-input-inline">
                <input type="password" name="repassword" data-type="require" data-rule="equal[password]" class=" layui-input" />
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <input class="layui-btn" value="注册" style="width:100%;" type="submit"/>
        </div>
    </form>
    <a href="${basePath}/member/login">我要登录</a>
</div>
</body>
</html>