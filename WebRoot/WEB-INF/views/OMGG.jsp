<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.util.*,com.BS.domain.Order"%>
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
        <title>订单详情</title>
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
                        <li  class="active">
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
                <div class="col-sm-9" style="margin-left:10px">
                    <% 
                        Order ord=(Order)request.getAttribute("Order");
                        String[] ordStates=(String[])request.getAttribute("ordStates");
						String[] ordKinds=(String[])request.getAttribute("ordKinds");
                     %>
                    <div class="row"><h2>订单详情</h2></div>
                	<div class="row">
                    <ul class="list-group col-md-5">
                        <li class="list-group-item">订单号：            <%=ord.getOrdId()%></li>
                        <li class="list-group-item">服务编号：        <%=ord.getSerId()%></li>
                        <li class="list-group-item">服务名：            <%=ord.getOrdName()%></li>
                        <li class="list-group-item">服务分类：        <%=ordKinds[ord.getOrdKind()]%></li>
                        <li class="list-group-item">客户编号：        <%=ord.getOrdMenId()%></li>
                        <li class="list-group-item">订单金额：        <%=ord.getOrdPrice()%></li>
                        <li class="list-group-item">订单状态：        <%=ordStates[ord.getOrdState()]%></li>
                        <li class="list-group-item">订单说明：        <%=ord.getOrdInf()%></li>
                    </ul>
                    </div>
                    <%if(ord.getOrdState()==0){%>
                    <div class="row">
                    <% out.println("<form action=\"OMGGTest-"+ord.getOrdId()+"\" method=\"post\">"); %>
                    <input class="my_btn" type="submit" value="接受订单">
                    </form>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </body>

</html>