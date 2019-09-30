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
    <script type="text/javascript" src="${basePath}/js/extendPagination.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>条目编辑</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input type="text" name="username" autocomplete="off" class="layui-input">
            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加条目','${basePath}/item/add',800,600)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${count} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>条目ID</th>
            <th>名称</th>
            <th>分类</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list result.data as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>
                <#if item.categories??>
                     <#list item.categories as category>
                         <#if category.state == 1>
                            <div class="layui-table-cell laytable-cell-1-0-6">
                                <button class="layui-btn layui-btn-xs">
                                    ${category.name}(已选取)</button>
                            </div>
                         <#else >
                            <div class="layui-table-cell laytable-cell-1-0-6">
                                <button class="layui-btn layui-btn-primary layui-btn-xs">
                                    ${category.name}</button>
                            </div>
                         </#if>

                     </#list>
                <#else >
                    无
                </#if>
            </td>
            <td class="td-manage">
                <button class="layui-btn layui-btn layui-btn-xs"  onclick="x_admin_show('编辑','${basePath}/item/edit/${item.id}',800,600)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>编辑
                </button>
                <button class="layui-btn-danger layui-btn layui-btn-xs" onclick="member_del(this,'${item.id}')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>删除
                </button>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
    <div class="page">
        <ul class="pagination"
            url="${basePath}/item/index/"
            currentPage="${result.page.pageNo}"
            pageCount="${result.page.totalPage}">
        </ul>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $(".pagination").jeesns_page("jeesnsPageForm");
    });
</script>
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
            var url = "${basePath}/item/delete/"+id;
            jeesns.jeesnsAjax(url,"GET",null,null);
            $(obj).parents("tr").remove();
        });
    }

</script>
</body>

</html>