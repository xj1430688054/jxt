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
        <div class="layui-card-header">信息</div>
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
                    <td>学号</td>
                    <td>${member.number}</td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td>${member.name}</td>
                </tr>
                <#if member.department??>
                <tr>
                    <td>学院或系别</td>
                    <td>${member.department.name}</td>
                </tr>
                </#if>
                <#if member.className??>
                <tr>
                    <td>班级</td>
                    <td>${member.className}</td>
                </tr>
                </#if>
                <#if member.contactPhone??>
                <tr>
                    <td>联系电话</td>
                    <td>${member.contactPhone}</td>
                </tr>
                </#if>
                <#if member.contactEmail??>
                <tr>
                    <td>联系邮箱</td>
                    <td>${member.contactEmail}</td>
                </tr>
                </#if>
                <#if member.state??>
                <tr>
                    <td>是否已选择</td>
                    <td>
                    <#if member.state == 1>
                        已选择
                    <#else >
                        未选择
                    </#if>
                    </td>
                </tr>
                </#if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="x-nav">
    <button class="layui-btn"  onclick="x_admin_show('编辑','${basePath}/member/info/edit/',800,600)" href="javascript:;">
        <i class="layui-icon">&#xe642;</i>编辑
    </button>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
</body>

</html>