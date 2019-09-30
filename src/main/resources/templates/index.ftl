<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>jxt 0.0.1</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="${basePath}/css/font.css">
	<link rel="stylesheet" href="${basePath}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${basePath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${basePath}/js/xadmin.js"></script>

</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="/index">jxt 0.0.1</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
            <#if loginMember??>
              <li class="layui-nav-item">
                <a href="javascript:;">${loginMember.name}</a>
                <dl class="layui-nav-child"> <!-- 二级菜单 -->
                  <dd><a onclick="x_admin_show('个人信息','/member/info')">个人信息</a></dd>
                  <dd><a href="/member/logout">退出</a></dd>
                </dl>
              </li>
            <#elseif LOGIN_ADMIN??>
            <li class="layui-nav-item">
                <a href="javascript:;">管理员：${LOGIN_ADMIN.name}</a>
                <dl class="layui-nav-child"> <!-- 二级菜单 -->
                    <dd><a href="/admin/logout">退出</a></dd>
                </dl>
            </li>
            <#else >
            <li class="layui-nav-item">
                <a href="javascript:;">用户/管理员登录</a>
                <dl class="layui-nav-child"> <!-- 二级菜单 -->
                    <dd><a href="/member/login">用户登录</a></dd>
                    <dd><a href="/admin/login">管理员登录</a></dd>
                </dl>
            </li>
            </#if>

          <li class="layui-nav-item to-index"><a href="/"></a></li>
        </ul>

    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
            <#if LOGIN_ADMIN??>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>编辑信息</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${basePath}/config/index">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>配置信息</cite>

                        </a>
                    </li >
                    <li>
                        <a _href="${basePath}/teacher/index">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>教师信息</cite>
                            
                        </a>
                    </li >
                    <li>
                        <a _href="${basePath}/department/index">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>系别信息</cite>

                        </a>
                    </li >
                    <li>
                        <a _href="${basePath}/category/index">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>分类信息</cite>
                            
                        </a>
                    </li>
					<li>
                        <a _href="${basePath}/item/index">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>条目信息</cite>
                            
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>查看信息</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/member/index">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生信息</cite>
                        </a>
                    </li >
                </ul>
				<#--<ul class="sub-menu">-->
                    <#--<li>-->
                        <#--<a _href="...">-->
                            <#--<i class="iconfont">&#xe6a7;</i>-->
                            <#--<cite>团队信息</cite>-->
                        <#--</a>-->
                    <#--</li >-->
                <#--</ul>-->
				<ul class="sub-menu">
                    <li>
                        <a _href="/order/index">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>选择信息</cite>
                        </a>
                    </li >
                </ul>
            </li>
            </#if>
            <#if loginMember??>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>学生模块</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/member/item">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>选择条目</cite>
                        </a>
                    </li >
                </ul>
				<ul class="sub-menu">
                    <li>
                        <a _href="/member/info">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>个人信息</cite>
                        </a>
                    </li >
                </ul>
				<ul class="sub-menu">
                    <li>
                        <a _href="/member/order">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>查看选择</cite>
                        </a>
                    </li >
                </ul>
            </li>
            </#if>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='${basePath}/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">Design by Lucas</div>  
    </div>
    <!-- 底部结束 -->
</body>
</html>