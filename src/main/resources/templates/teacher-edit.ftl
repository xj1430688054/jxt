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
    <form class="layui-form jeesns_form" action="${basePath}/teacher/edit/${teacher.id}" method="post" >
        <div class="layui-form-item">
            <label class="layui-form-label">
                教师ID
            </label>
            <h1>${teacher.id}</h1>
        </div>
		
		<div class="layui-form-item">
            <label class="layui-form-label">
                姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" name="name" data-type="require" value="${teacher.name}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                容量
            </label>
            <div class="layui-input-inline">
                <input type="text" name="capacity" data-type="require" value="${teacher.capacity}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">
                选择分类：
            </label>
            <table  class="layui-table layui-input-block">
                <tr>
                    <td>
                        <div class="layui-input-block">
                            <#list result.data as category>
                            <input name="cidArr"  type="checkbox" value="${category.id}" title="${category.name}">
                            </#list>
                        </div>
                    </td>
                </tr>
            </table>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">
                描述
            </label>
            <div class="layui-input-block">
                <textarea value="${teacher.content}" placeholder="${teacher.content}" id="content" name="content" class="layui-textarea"></textarea>
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