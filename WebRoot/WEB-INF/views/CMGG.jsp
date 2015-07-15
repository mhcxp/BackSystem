<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.util.*,com.BS.domain.Message"%>
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
        <title>留言详情</title>
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
                        <li class="divider"></li>
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
                        <li class="active">
                            <a href="CSManage-1">客服管理</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-9" style="margin-left:20px">
                    <% 
                        Message msg=(Message)request.getAttribute("Message");
                     %>
                    <div class="row" style="margin-left:3px"><h2>留言详情</h2></div>
                	<div class="row" style="margin-left:3px">
                    <ul class="list-group col-md-5">
                        <li class="list-group-item">留言内容：            <%=msg.getContent()%></li>
                        <li class="list-group-item">留言客户：        <%=msg.getUserName()%></li>
                        <li class="list-group-item">留言时间：            <%=msg.getTime()%></li>
                        <li class="list-group-item">回复：            <%=msg.getReply()%></li>
                    </ul>
                    </div>
                    <div class="row col-md-6">
                    <h4>更改回复：</h4>
                    <% out.println("<form action=\"CMGGTest-"+msg.getId()+"\" method=\"post\">"); %>
                    <textarea class="form-control" rows="5" name="reply"></textarea>
                    <input style="margin-top:10px" class="my_btn" type="submit" value="确认">
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>