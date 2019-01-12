<!DOCTYPE html>
<html lang="ch-ZH">

<head>
    <meta charset="utf-8" />
    <title>快递管理系统</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />

    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />


    <link href="./css/font-awesome.css" rel="stylesheet" />

    <link href="./css/adminia.css" rel="stylesheet" />
    <link href="./css/adminia-responsive.css" rel="stylesheet" />

    <link href="./css/pages/login.css" rel="stylesheet" />
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

                <a class="brand" href="./">快递管理系统</a>

                <div class="nav-collapse">

                    <ul class="nav pull-right">

                        <!-- <li class="">

                            <a href="./code/reg.html"><i class="icon-chevron-left"></i> 点击注册</a>
                        </li> -->
                    </ul>

                </div>
                <!-- /nav-collapse -->

            </div>
            <!-- /container -->

        </div>
        <!-- /navbar-inner -->


    </div>
    <!-- /navbar -->


    <div id="login-container">


        <div id="login-header">

            <h3>登录</h3>

        </div>
        <!-- /login-header -->

        <div id="login-content" class="clearfix">

            <form action="/login" method="post">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="username">账号</label>
                        <div class="controls">
                            <input type="text" name="username" class="" id="username" placeholder="账号" autofocus />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="password">密码</label>
                        <div class="controls">
                            <input type="password" name="password" class="" id="password" placeholder="密码" />
                        </div>
                    </div>
                </fieldset>

                <div id="remember-me" class="pull-left">
                    <input type="checkbox" name="remember" id="remember" />
                    <label id="remember-label" for="remember">记住我</label>
                </div>

                <div class="pull-right">
                    <button type="submit" class="btn btn-warning btn-large" id="logInBtn">登录</button>
                </div>
            </form>

        </div>
        <!-- /login-content -->


        <div id="login-extra">

            <!-- <p>没有账号？ <a href="./code/reg.html"> > 去注册</a></p> -->

            <p>忘记密码？ <a href="#"> > 点击找回</a></p>

        </div>
        <!-- /login-extra -->

    </div>
    <!-- /login-wrapper -->



    <script src="./js/jquery-1.7.2.min.js"></script>
    <script src="./js/bootstrap.js"></script>
    <script src="./js/donotIn.js"></script>
    <script src="./js/checkNull.js"></script>

</body>

</html>