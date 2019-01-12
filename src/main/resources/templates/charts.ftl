<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>数据图表</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />

    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />


    <link href="./css/font-awesome.css" rel="stylesheet" />

    <link href="./css/adminia.css" rel="stylesheet" />
    <link href="./css/adminia-responsive.css" rel="stylesheet" />
    <link rel="stylesheet" href="./css/charts.css">


    <link href="./css/jquery.visualize.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/allStyle.css">


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>

    <div class="navbar navbar-fixed-top">

        <div class="navbar-inner">

            <div class="container">

                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">公司名字</a>
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
            <!-- /container -->

        </div>
        <!-- /navbar-inner -->
        <!--添加导航条下边的小条-->
        <div class="navBarBottom"></div>
        <!--/添加导航条下边的小条-->

    </div>
    <!-- /navbar -->




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

                        <li>
                            <a href="/index">
                                <i class="icon-home"></i> 人员表
                            </a>
                        </li>
                        <li>
                            <a href="/allExpress">
                                <i class="icon-th-large"></i> 快递信息
                            </a>
                        </li>
                        <li class="active">
                            <a href="#">
                                <i class="icon-bar-chart"></i> 统计图表
                            </a>
                        </li>
                        <li>
                            <a href="/logout">
                                <i class="icon-lock"></i> 退出当前账户
                            </a>
                        </li>

                    </ul>
                    <hr />
                    <!--<div class="sidebar-extra">-->
                    <!--<p>智联天下-系统管理平台是很棒的一个平台...</p>-->
                    <!--</div> &lt;!&ndash; .sidebar-extra &ndash;&gt;-->
                    <br />
                </div>
                <!-- /span3 -->



                <div class="span9">

                    <h1 class="page-title">
                        <i class="icon-signal"></i> 图表数据
                    </h1>





                    <!--折线图-->
                    <div class="widget">
                        <div class="widget-header">
                            <h3>折线图</h3>
                        </div>
                        <!-- /widget-header -->
                        <div id="main"></div>
                    </div>
                    <!--/折线图-->

                    <!--饼状图-->
                    <!--<div class="widget">-->
                    <!--<div class="widget-header">-->
                    <!--<h3>饼状图</h3>-->
                    <!--</div> &lt;!&ndash; /widget-header &ndash;&gt;-->
                    <!--<div class="widget-content">-->
                    <!--<div id="pie-chart" class="chart-holder"></div> &lt;!&ndash; /donut-chart &ndash;&gt;-->

                    <!--</div> &lt;!&ndash; /widget-content &ndash;&gt;-->

                    <!--</div> &lt;!&ndash; /widget &ndash;&gt;-->
                    <div class="widget">
                        <div class="widget-header">
                            <h3>饼图</h3>
                        </div>
                        <!-- /widget-header -->
                        <div id="main2"></div>
                    </div>
                    <!--/饼状图-->

                </div>
                <!-- /span9 -->


            </div>
            <!-- /row -->

        </div>
        <!-- /container -->

    </div>
    <!-- /content -->

    <script src="./js/jquery-1.7.2.min.js"></script>
    <script src="./js/excanvas.min.js"></script>
    <script src="./js/jquery.flot.js"></script>
    <script src="./js/jquery.flot.pie.js"></script>
    <script src="./js/jquery.flot.orderBars.js"></script>
    <script src="./js/jquery.flot.resize.js"></script>
    <script src="./js/echarts-all.js"></script>
    <script src="./js/bootstrap.js"></script>
    <script src="./js/charts/bar.js"></script>
    <script src="./js/charts/area.js"></script>
    <script src="./js/charts/line.js"></script>
    <script src="./js/charts/pie.js"></script>
    <script src="./js/charts.js"></script>



</body>

</html>