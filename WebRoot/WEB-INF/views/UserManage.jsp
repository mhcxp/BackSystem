<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.util.*,com.BS.domain.User"%>
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
        <title>客户资源管理</title>
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
                        <li>
                            <a href="index.html">主页</a>
                        </li>
                        <li>
                            <a href="PermissionManage-1">用户权限管理</a>
                        </li>
                        <li class="active">
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
                	<% Integer per=(Integer)request.getAttribute("per"); %>
                    <% if(per!=null&&(per.intValue()==1||per.intValue()==0)) {%>
                    <div class="row">
                        <div class="col-sm-3">
                            <h2 class="sub-header">客户列表</h2>
                        </div>
                        <div class="col-sm-9">
                            <form id="myForm" onsubmit="return validateForm()" action="UMS" class="navbar-form navbar-right" method="post">
                                <input name="name" type="text" class="form-control" placeholder="输入用户名">
                                <input type="submit" class="btn btn-primary" value="搜索">
                            </form>
                        </div>
<script type="text/javascript" language="javascript">
function validateForm()
{
	var x=document.getElementById("myForm");
	for(var i=0;i<x.length;i++)
		if (x.elements[i].value=="")
		{
  			alert("搜索内容不能为空");
  			return false;
  		}
  	return true;
}                            
</script>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>昵称</th>
                                    <th>电子邮件</th>
                                    <th>是否实名认证</th>
                                </tr>
                            </thead>
                            <tbody>
                            <% 
								List<User> list=(List<User>)request.getAttribute("list");
								int cur=(Integer)request.getAttribute("cur");
                                int pageNum=(Integer)request.getAttribute("pageNum");
								for(int i=0;i<list.size();i++)
								{
									out.println("<tr>");
									out.println("<td><a href=\"UMGG-"+list.get(i).getUsername()+"\">"+list.get(i).getUsername()+"</a></td>");
									out.println("<td>"+list.get(i).getUserNickName()+"</td>");
									out.println("<td>"+list.get(i).getUserMail()+"</td>");
									if(list.get(i).getIsName()){
										out.println("<td>是</td>");
									}else{
										out.println("<td>否</td>");
									}
									out.println("</tr>");
								}
							%>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <ul class="pagination pull-right">
                            <%if(cur==1) {%>
                        	<li class="disabled"><a href="#">&laquo;</a></li>
                        	<%}else{%>
                        	<li><a href="UserManage-<%=(cur-1)%>">&laquo;</a></li>
                        	<%} %>
                        	<%
                        		for(int i=1;i<=pageNum;i++)
                        			if(cur==i)
                        				out.println("<li class=\"active\"><a href=\"UserManage-"+i+"\">"+i+"</a></li>");
                        			else
                        				out.println("<li><a href=\"UserManage-"+i+"\">"+i+"</a></li>");
                        	 %>
                        	 <%if(cur==pageNum) {%>
                        	<li class="disabled"><a href="#">&raquo;</a></li>
                        	<%}else{%>
                        	<li><a href="UserManage-<%=(cur+1)%>">&raquo;</a></li>
                        	<%} %>
                        </ul>
                    </div>
                    <% }else{ %>
                    <h2>你没有权限使用该功能</h2>
                    <% } %>
                </div>
            </div>
        </div>
    </body>

</html>