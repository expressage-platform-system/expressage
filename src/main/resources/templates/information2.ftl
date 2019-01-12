<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>订单页面</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />

    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />


    <link href="./css/font-awesome.css" rel="stylesheet" />

    <link href="./css/adminia.css" rel="stylesheet" />
    <link href="./css/adminia-responsive.css" rel="stylesheet" />

    <link href="./css/pages/dashboard.css" rel="stylesheet" />
    <link rel="stylesheet" href="./css/pages/addperson.css">
    <link rel="stylesheet" href="css/allStyle.css">
    <link rel="stylesheet" href="./css/subPage.css">



    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
    <!--标签-->
    <div class="navbar navbar-fixed-top">

        <div class="navbar-inner">

            <div class="container navColor">

                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand fontColor" href="#">快递1</a>
                <div class="nav-collapse">
                    <ul class="nav pull-right">
                        <li class="dropdown">
                            <a href="/logout">
                                <i class="icon-signout"></i> 退出登录
                            </a>
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

                            <span class="account-name">快递1</span>
                            <span class="account-role">快递详情</span>

                        </div>
                        <!-- /account-details -->
                    </div>
                    <!-- /account-container -->

                    <hr />

                    <ul id="main-nav" class="nav nav-tabs nav-stacked">
                        <li>
                            <a href="/allExpress">
                                <i class="icon-th-large"></i> 全部订单
                            </a>
                        </li>
                        <li>
                            <a href="/allDjExpress">
                                <i class="icon-th-large"></i> 待接受订单
                            </a>
                        </li>
                        <li class="active">
                            <a href="#">
                                <i class="icon-th-large"></i> 带送达订单
                            </a>
                        </li>
                        <li>
                            <a href="/allDfExpress">
                                <i class="icon-th-large"></i> 待支付订单
                            </a>
                        </li>
                        <li>
                            <a href="/allFinishExpress">
                                <i class="icon-th-large"></i> 已完成订单
                            </a>
                        </li>
                        <li>
                            <a href="/allCancelExpress">
                                <i class="icon-th-large"></i> 取消订单
                            </a>
                        </li>

                        <li>
                            <a href="/index">
                                <i class="icon-home"></i> 返回主页
                            </a>
                        </li>
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
                            <h3>使用详情</h3>
                        </div>

                        <!-- /widget-header -->

                        <div class="widget-content">

                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>快递公司</th>
                                        <th>快递编号</th>
                                        <th>收货人</th>
                                        <th>收货人电话</th>
                                        <th>东西区</th>
                                        <th>宿舍名</th>
                                        <th>处理人</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <#assign i = (number+1)*10-10>
								    <#list express>
                                        <#items as exp>
                                    <tr>
                                        <#assign i=i+1>
                                        <td>${i}</td>
                                        <td>${exp.expCompany}</td>
                                        <td>${exp.expNum}</td>
                                        <td>${exp.consignee}</td>
                                        <td>${exp.consigneePhone}</td>
                                        <td>${exp.region}</td>
                                        <td>${exp.dorm}</td>
                                        <td>${exp.adminNum}</td>
                                        <#--<td class="action-td">-->

                                            <#--<a href="javascript:;" class="btn btn-small">-->
                                                <#--<i class="icon-remove"></i>-->
                                            <#--</a>-->
                                        <#--</td>-->


                                        <!--延续下边的表头-->
                                        <!--/延续下边的表头-->

                                    </tr>
                                        </#items>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                        <!-- /widget-content -->

                    </div>
                    <!-- /widget -->
                </div>
                <!-- /span9


<div class="sub">
    <div class="row">
        <!-- /span3 -->
            </div>
        </div>



        <!--详情内容 -->
        <div class="sub1">
            <div class="row1">
                <!-- /span3 -->
                <div class="span10">
                    <div class="widget widget-table">
                        <div class="widget-header">
                            <span class="cancelAdd" id="cancel10">x</span>
                        </div>
                        <h2>订单详情</h2>
                        <!-- /widget-header -->
                        <div class="widget-content">


                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>订单id</th>
                                        <th>快递公司</th>
                                        <th>快递编号</th>
                                        <th>收货人</th>
                                        <th>收货人电话</th>
                                        <th>东西区</th>
                                        <th>宿舍名</th>
                                        <th>楼号</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td class="groupTitle">学习</td>
                                        <td>00:00:00</td>
                                        <td>01:00:00</td>
                                        <td>10:00:00</td>
                                        <td>2018-11-18</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>

                                </tbody>
                            </table>
                            <br>



                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>本人姓名</th>
                                        <th>本人电话</th>
                                        <th>备注</th>
                                        <th>留言</th>
                                        <th>订单状态</th>
                                        <th>申请时间</th>
                                        <th>接单人</th>
                                        <th>金额</th>
                                        <th>预计送达时间</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td class="groupTitle">学习</td>
                                        <td>00:00:00</td>
                                        <td>01:00:00</td>
                                        <td>10:00:00</td>
                                        <td>2018-11-18</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>


                                        <!--延续下边的表头-->
                                        <!--/延续下边的表头-->

                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <!-- /widget-content -->

                    </div>
                    <!-- /widget -->
                </div>
            </div>
        </div>
        <!-- /详情内容 -->




    </div>
    <div class = "paging">
	<#assign pages=totalPages>
	<#assign elements=totalNum>
	<#assign no=number>
		<#if (no < 1)>
			<a href="#">上一页</a>
        <#else>
			<a href="/allDsExpress?page=${no-1}">上一页</a>
        </#if>
		<#if (no == pages-1)>
			<a href="#">下一页</a>
        <#else>
			<a href="/allDsExpress?page=${no+1}">下一页</a>
        </#if>
        <span>共${totalPages?default("0")}页，共${totalNum?default("0")}条</span>
    </div>
    <!-- /row -->

    <script>
        document.getElementById("cancel10").onclick = function () {
            document.querySelector(".sub1").style.display = "none";
        }
        document.getElementById("sub").onclick = function () {
            document.querySelector(".sub1").style.display = "block";
        }
    </script>





    <script src="./js/jquery-1.7.2.min.js"></script>
    <script src="./js/jquery.flot.js"></script>
    <script src="./js/jquery.flot.pie.js"></script>
    <script src="./js/jquery.flot.orderBars.js"></script>
    <script src="./js/jquery.flot.resize.js"></script>
    <script src="./js/bootstrap.js"></script>
    <script src="./js/addperson1.js"></script>
    <script src="./js/jquery-1.12.4.js"></script>

</body>

</html>