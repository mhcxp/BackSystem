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
        <title>金融信息发布</title>
        <link href="nav.css"
        rel="stylesheet" type="text/css">
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
                        <li class="active">
                            <a href="InfoFB_News"> 信息发布</a>
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
                        		<ul class="nav nav-tabs">
  									<li role="presentation"><a href="InfoFB_News">新闻发布</a></li>
  									<li role="presentation" class="active"><a href="InfoFB_Finance-JJ">金融业务发布</a></li>
  									<li role="presentation"><a href="InfoFB_Health">健康信息发布</a></li>
  									<li role="presentation"><a href="InfoFB_Life-JZ">生活信息发布</a></li>
								</ul>
                        	</div>
                        	<%String kind=(String)request.getAttribute("kind"); %>
                        	<div class="row" style="margin:20px">
                        		<ul class="nav nav-pills">
  									<li role="presentation" <% if(kind.equals("JJ"))out.println("class=\"active\""); %>><a href="InfoFB_Finance-JJ">基金类业务</a></li>
  									<li role="presentation" <% if(kind.equals("ZQ"))out.println("class=\"active\""); %>><a href="InfoFB_Finance-ZQ">证券类业务</a></li>
  									<li role="presentation" <% if(kind.equals("BX"))out.println("class=\"active\""); %>><a href="InfoFB_Finance-BX">保险类业务</a></li>
  									<li role="presentation" <% if(kind.equals("HJ"))out.println("class=\"active\""); %>><a href="InfoFB_Finance-HJ">黄金属类业务</a></li>
								</ul>
                        	</div>
                            <div class="row col-md-8" style="margin-top:20px">
                                <div class="col-md-12">
                                	<% if(kind.equals("JJ")){ %>
                                    <%@include file="FinJJ.txt" %>
                                    <%}else if(kind.equals("ZQ")){ %>
                                    <%@include file="FinZQ.txt" %>
                                    <%}else if(kind.equals("BX")){ %>
                                    <%@include file="FinBX.txt" %>
                                    <%}else if(kind.equals("HJ")){ %>
                                    <%@include file="FinHJ.txt" %>
                                    <%} %>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
<script type="text/javascript" language="javascript">
function validateForm()
{
	var x=document.getElementById("myForm");
	for(var i=0;i<x.length;i++)
		if (x.elements[i].value=="")
		{
  			alert("信息不完整，请继续填写");
  			return false;
  		}
  	return true;
}                            
</script>
<%String state=request.getParameter("s"); 
String k=request.getParameter("k"); 
%>
<%if(state!=null&&state.equals("y")){ %>
<script type="text/javascript" language="javascript">
		alert("发布成功");                                            
		window.location="InfoFB_Finance-<%=k%>";                            
</script>
<%}else if(state!=null&&state.equals("n")){ %>
<script type="text/javascript" language="javascript">
		alert("发布失败");                                            
		window.location="InfoFB_Finance-<%=k%>";                            
</script>
<%} %>
</html>