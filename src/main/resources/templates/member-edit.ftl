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
    <form class="layui-form jeesns_form"
          <#if LOGIN_ADMIN??>
            action="${basePath}/member/edit/${member.id}"
          <#elseif loginMember??>
            action="${basePath}/member/info/edit/${member.id}"
          </#if>
          method="post" >
        <div class="layui-form-item">
            <label class="layui-form-label">
                成员ID
            </label>
            <h1>${member.id}</h1>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                学号
            </label>
            <h1>${member.number}</h1>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>系别或学院名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="departmemt.name" data-type="require"
                       <#if member.department??>
                        value="${member.department.name}"
                       </#if>
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>班级
            </label>
            <div class="layui-input-inline">
                <input type="text" name="className" data-type="require" value="${member.className}" class="layui-input">
            </div>
            格式如 ： 1502
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>联系邮箱
            </label>
            <div class="layui-input-inline">
                <input type="text" name="contactEmail"  data-type="require,email" value="${member.contactEmail}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>联系电话
            </label>
            <div class="layui-input-inline">
                <input type="text" name="contactPhone" data-type="require"  value="${member.contactPhone}"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" data-type="require"  value="${member.password}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <input class="layui-btn" value="编辑" style="width:100%;" type="submit"/>
        </div>
    </form>
</div>
</body>

</html>