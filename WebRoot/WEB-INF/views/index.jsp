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

        <title>主页</title>
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
                        <li class="active">
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
                            <div class="container">
        <div  class="row" style="margin-right:30px">
            <div class="col-md-12">
                <div class="carousel slide" id="myCarousel" style="width:1000px;max-height:350px">
                    <!-- 轮播（Carousel）指标 -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    
                    <!-- 轮播（Carousel）项目 -->
                    <div class="carousel-inner" style="width:1000px;max-height:350px">
                        <div class="item active">
                            <img src="image/1.jpg" alt="First slide">
                        </div>
                        <div class="item">
                           <img src="image/2.jpg" alt="Second slide">
                        </div>
                        <div class="item">
                            <img src="image/3.jpg" alt="Third slide">
                        </div>
                    </div>
                    <!-- 轮播（Carousel）导航 -->
                    <a class="carousel-control left" href="#myCarousel" data-slide="prev">‹</a>
                    <a class="carousel-control right" href="#myCarousel" data-slide="next">›</a>
                </div>
                
            </div>
        </div>
    </div>
    <div class="section" style="margin-top:30px;">
        <div class="container">
            <div class="row" style="margin-left:70px;">
                <div class="col-md-3">
                    <img src="image/4.jpg" class="img-responsive">
                    <h2><a class="my_link" href="http://www.baidu.com">普金大帝</a></h2>
                    <p>
                        普金大帝和奥巴马两人闹翻了
                        <br> 然后两人很久都没有聊天了.
                        <br> 就这样
                    </p>
                </div>
                <div class="col-md-3">
                    <img src="image/5.jpg" class="img-responsive">
                    <h2><a class="my_link" href="http://www.baidu.com">和平</a></h2>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisici elit,
                        <br> sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                        <br> Ut enim ad minim veniam, quis nostrud
                    </p>
                </div>
                <div class="col-md-3">
                    <img src="image/6.jpg" class="img-responsive img-rounded">
                    <h2><a class="my_link" href="http://www.baidu.com">缺德</a></h2>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisici elit,
                        <br> sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                    </p>
                </div>
            </div>
        </div>
    </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>