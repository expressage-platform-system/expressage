<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>人员表</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />

    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />

    <link href="./css/font-awesome.css" rel="stylesheet" />

    <link href="./css/adminia.css" rel="stylesheet" />
    <link href="./css/adminia-responsive.css" rel="stylesheet" />
    <link href="./css/pages/dashboard.css" rel="stylesheet" />
    <link rel="stylesheet" href="./css/pages/addperson.css" />
    <link rel="stylesheet" href="css/allStyle.css" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
    <!--标签-->
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span> <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">公司名字</a>
                <div class="nav-collapse">
                    <ul class="nav pull-right">
                        <li class="dropdown" id="testLi">
                            <a href="/logout"> <i class="icon-signout"></i> 退出登录 </a>
                        </li>
                    </ul>
                </div>
                <!-- /nav-collapse -->
            </div>
            <!-- /container -->
        </div>
        <!-- /navbar-inner -->
        <div class = "navBarBottom"></div>

    </div>
    <!-- /navbar -->

    <!--展示的表格-->
    <div id="content">
        <div class="container">
            <div class="row">
                <div class="span3">
                    <div class="account-container">
                        <div class="account-details">
                            <span class="account-name">账户名字</span>
                            <span class="account-role">管理员</span>
                        </div>
                        <!-- /account-details -->
                    </div>
                    <!-- /account-container -->

                    <hr />

                    <ul id="main-nav" class="nav nav-tabs nav-stacked">
                        <li class="active">
                            <a href="#/"> <i class="icon-home"></i> 人员表 </a>
                        </li>
                        <li>
                            <a href="/allExpress">
                                <i class="icon-th-large"></i> 快递信息
                            </a>
                        </li>
                        <#--<li>-->
                            <#--<a href="/chart">-->
                                <#--<i class="icon-bar-chart"></i> 统计图表-->
                            <#--</a>-->
                        <#--</li>-->
                        <li>
                            <a href="/logout">
                                <i class="icon-lock"></i> 退出当前账户
                            </a>
                        </li>
                    </ul>
                    <hr />

                    <br />
                </div>
                <!-- /span3 -->
                <div class="span9">
                    <div class="widget widget-table">
                        <div class="widget-header">
                            <i class="icon-th-list"></i>
                            <h3>员工数据</h3>
                        </div>
                        <!-- /widget-header -->

                        <div class="widget-content">
                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>员工姓名</th>
                                        <th>员工账号</th>
                                        <th>密码</th>
                                        <th>电话</th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <#assign i = (number+1)*10-10>
								    <#list userList>
                                    <#items as user>
                                    <tr>
                                        <#assign i=i+1>
                                        <td>${i}</td>
                                        <td>${user.adminName}</td>
                                        <td>${user.adminNum}</td>
                                        <td>${user.adminPasswd}</td>
                                        <td>${user.adminPhone}</td>
                                        <td class="action-td">
                                            <a href="javascript:;" class="btn btn-small btn-warning pencil">
                                                <i class="icon-pencil"></i>
                                            </a>
                                            <a href="/deleteUser/${user.adminNum}" class="btn btn-small" id="0">
                                                <i class="icon-remove"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    </#items>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                        <!-- /widget-content -->
                        <button class="btn btn-warning btn-large" id="addBtn">
                            添加
                        </button>
                    </div>
                    <!-- /widget -->
                </div>
                <!-- /span9 -->

                <!--添加成员页面-->
                <div class="addPersonBackground" id="addPersonBackground">
                    <div class="addPerson" id="addPerson">
                        <h5>详细信息</h5>
                        <form action="/addUser" method="post" id="addForm" class="addForm" onSubmit="return inputNull(this)">
                            <input type="text" name="adminName" placeholder="姓名" autofocus />
                            <input type="text" name="adminNum" placeholder="员工账号" id="personNumber"/>
                            <input type="text" name="adminPhone" placeholder="员工电话" />
                            <input type="submit" value="提交" id="newPerson" class="btn btn-warning btn-large" />
                        </form>
                        <span class="cancelAdd" id="cancelAdd">x</span>
                    </div>
                </div>
                <!--/添加成员页面-->

                <!--修改成员页面-->

                <div class="addPersonBackground" id="modifyPersonBackground">
                    <div class="addPerson" id="modifyPerson">
                        <h5 id="modifyHeaderInner">修改页面</h5>
                        <form action="#" method="post" id="addForm1" class="addForm">
                            <input type="text" name="adminPasswd" placeholder="员工密码" id="userPasswd" />
                            <input type="button" value="修改" id="modifyBtn0" class="btn btn-warning btn-large" />
                        </form>
                        <span class="cancelAdd" id="cancelAdd1">x</span>
                    </div>
                </div>

                <!--/修改成员页面-->
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /content -->
    <div class = "paging">
        <p style="padding-bottom: 30px">${error!}</p>
	<#assign pages=totalPages>
	<#assign elements=totalNum>
	<#assign no=number>
		<#if (no < 1)>
			<a href="#">上一页</a>
        <#else>
			<a href="/index?page=${no-1}">上一页</a>
        </#if>
		<#if (no == pages-1)>
			<a href="#">下一页</a>
        <#else>
			<a href="/index?page=${no+1}">下一页</a>
        </#if>
        <span>共${totalPages?default("0")}页，共${totalNum?default("0")}条</span>
    </div>

    <script src="./js/jquery-1.7.2.min.js"></script>
    <script src="./js/jquery.flot.js"></script>
    <script src="./js/jquery.flot.pie.js"></script>
    <script src="./js/jquery.flot.orderBars.js"></script>
    <script src="./js/jquery.flot.resize.js"></script>
    <script src="./js/bootstrap.js"></script>
    <script src="./js/addperson.js"></script>
    <script src="js/modify.js"></script>
    <script src="js/checkNull.js"></script>
    <script src = "js/addnew.js"></script>
</body>

</html>