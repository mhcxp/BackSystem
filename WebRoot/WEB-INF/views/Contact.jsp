<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="lib/jquery.min.js"></script>
        <script type="text/javascript" src="lib/bootstrap-3.3.5/js/bootstrap.min.js"></script>
        <link href="lib/font-awesome/css/font-awesome.css"
        rel="stylesheet" type="text/css">
        <link href="lib/bootstrap-3.3.5/css/bootstrap.css"
        rel="stylesheet" type="text/css">
        <link href="nav.css"
        rel="stylesheet" type="text/css">

        <title>联系我们</title>
    </head>
    
    <body style="overflow-x: hidden;">
        <div class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span>金惠家后台管理系统</span></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-expanded="false">${username} <i class="fa fa-caret-down"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="UserInfo">资料</a>
                                </li>
                                <li>
                                    <a href="Login">注销</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="Contact">联系我们</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div id="Menu" class="col-sm-2 sidebar">
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a href="index">主页</a>
                        </li>
                        <li>
                            <a href="PermissionManage-1">用户权限管理</a>
                        </li>
                        <li>
                            <a href="UserManage-1">客户资源管理</a>
                        </li>
                        <li>
                            <a href="OrderManage-1">订单管理</a>
                        </li>
                        <li>
                            <a href="InfoFB_News">信息发布</a>
                        </li>
                        <li>
                            <a href="CSManage-1">客服管理</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-9">
                    <div class="section">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <h1 class="text-center">Team</h1>
                                    <p class="text-center">我们是一个有创造力的团队</p>
                                </div>
                            </div>
                            <div class="row" style="margin-top:10px;maring-bottom:10px;margin-right:20px">
                                <div class="col-md-2">
                                    <img src="image/user_placeholder.png"
                                    class="img-circle img-responsive">
                                </div>
                                <div class="col-md-2">
                                    <h3 class="text-left">王天宇</h3>
                                    <p class="text-left">Lorem ipsum dolor sit amet</p>
                                </div>
                                <div class="col-md-2">
                                    <img src="image/user_placeholder.png"
                                    class="img-circle img-responsive">
                                </div>
                                <div class="col-md-2">
                                    <h3 class="text-left">朱志朋</h3>
                                    <p class="text-left">Lorem ipsum dolor sit amet</p>
                                </div>
                                <div class="col-md-2">
                                    <img src="image/user_placeholder.png"
                                    class="img-circle img-responsive">
                                </div>
                                <div class="col-md-2">
                                    <h3 class="text-left">汪令野</h3>
                                    <p class="text-left">Lorem ipsum dolor sit amet</p>
                                </div>
                            </div>
                            <div class="row" style="margin-top:10px;maring-bottom:10px;margin-right:20px">
                                <div class="col-md-2">
                                    <img src="image/user_placeholder.png"
                                    class="img-circle img-responsive">
                                </div>
                                <div class="col-md-2">
                                    <h3 class="text-left">刘喆雄</h3>
                                    <p class="text-left">Lorem ipsum dolor sit amet</p>
                                </div>
                                <div class="col-md-2">
                                    <img src="image/user_placeholder.png"
                                    class="img-circle img-responsive">
                                </div>
                                <div class="col-md-2">
                                    <h3 class="text-left">楚明君</h3>
                                    <p class="text-left">Lorem ipsum dolor sit amet</p>
                                </div>
                                <div class="col-md-2">
                                    <img src="image/user_placeholder.png"
                                    class="img-circle img-responsive">
                                </div>
                                <div class="col-md-2">
                                    <h3 class="text-left">吴少珍</h3>
                                    <p class="text-left">Lorem ipsum dolor sit amet</p>
                                </div>
                            </div>
                            <div class="row" style="margin-top:10px;maring-bottom:10px;margin-right:20px">
                                <div class="col-md-2">
                                    <img src="image/user_placeholder.png"
                                    class="img-circle img-responsive">
                                </div>
                                <div class="col-md-2">
                                    <h3 class="text-left">徐易亨</h3>
                                    <p class="text-left">Lorem ipsum dolor sit amet</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>