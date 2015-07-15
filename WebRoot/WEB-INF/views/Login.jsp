<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.util.*"%>
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
        <title>用户登录</title>
        <link href="nav.css"
        rel="stylesheet" type="text/css">
    </head>
    
    <body>
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
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <h1>用户登录</h1>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <form class="form-horizontal" role="form" action="LoginTest" method="POST">
                            <div class="form-group">
                                <div class="col-sm-1">
                                    <label for="username" class="control-label">用户名</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="username" placeholder="UserName">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-1">
                                    <label for="password" class="control-label">密码</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="password" class="form-control" name="password" placeholder="Password">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-1">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="remember">记住我</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-1">
                                    <input class="my_btn" type="submit" value="登录" />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <% 
					String username=(String)request.getAttribute("username");
				 %>
				<%	if (username!=null&&username.equals("error")) { %>
      				<div class="alert alert-danger col-md-5">登录失败</div>
				<% } %>
            </div>
        </div>
    </body>

</html>