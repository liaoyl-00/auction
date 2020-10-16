<%@page import="com.qianfeng.entity.Role"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户信息</title>
    
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
  	<center>
  		<h1>添加用户信息</h1>
  	</center>
  	<% List<Role> roles = (List<Role>)request.getAttribute("roles"); %>
  	<form action="addUserServlet" method="post">
  		<table width="400px" border="1px" align="center">
  		<tr>
			<td>用户名</td>
			<td><input name="username" /></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input name="password" /></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input name="age" /></td>
		</tr>
		<tr>
		<td>角色</td>
		<td>
			<select name="role">
			<%
				for(int i = 0; i < roles.size(); i++) {
			%>
			<option value="<%=roles.get(i).getId()%>"><%=roles.get(i).getRoleName() %></option>
			<%
				} 
			%>
			</select>
		</td>
		</tr>
		<tr>
			<td colspan="2"><button>确认添加</button>
			</td>
		</tr>
  		</table>
  	
  	</form>
    
  </body>
</html>
