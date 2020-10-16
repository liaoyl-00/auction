<%@page import="com.qianfeng.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editUserInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image:  url('https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4148059623,3397518472&fm=26&gp=0.jpg');background-repeat: no-repeat;background-size:100% 100%">

    <form action="EditUserInfoServlet" method="post">
		<table align="center" width="500px" border="1px">
		<% User user = (User) request.getAttribute("user"); %>
		<tr>
			<td>用户名</td>
			<td><input name="username" value="<%=user.getUsername()%>"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input name="password" value="<%=user.getPassword()%>"/></td>
		</tr>
		<tr>
			<td>年龄</td>
			<input type="hidden" name="id" value="<%=user.getId() %>">
			<td><input name="age" value="<%=user.getAge()%>"/></td>
		</tr>
		<tr>
			<td colspan="2"><button>确认修改</button>
			</td>
		</tr>
    	</table>
    </form>
  </body>
</html>
