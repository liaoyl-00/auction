<%@page import="com.qianfeng.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'manageUI.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function addUser(){
		location.href="/gllg_auction/addUserUIServlet";
	}
</script>

</head>

<body
	style="background-image:  url('https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=208966222,518031508&fm=26&gp=0.jpg');background-repeat: no-repeat;background-size:100% 100%">
	<center>
	<% User loginUser = (User)request.getAttribute("userSelect");%>
		<h1>后台管理页面</h1>
	</center>
	<table align="center" width="500px" border="1px">
		<tr><td colspan="4"><input type="button" onclick="addUser()" value="添加账号信息">
		尊敬的<%=loginUser.getRole().getRoleName() %> : <%=loginUser.getUsername() %> 
		<a href="/gllg_auction/index.jsp">注销</a>
		</td></tr>
		<tr>
			<td colspan="4">
			角色操作： 	<a href="/gllg_auction/roleManage?method=addRoleUI">添加角色</a>
					<a href="/gllg_auction/roleManage?method=findAllRoles">显示所有角色</a>
			</td>
		</tr>
		<tr>
			<td colspan="4">
			资源操作：
				<a href="/gllg_auction/addResourceUI.jsp">添加资源</a>
				<a href="/gllg_auction/ResourceManage?method=listResource">显示资源列表</a>
			</td>
		</tr>
		<tr>
			<td>账号名</td>
			<td>密码</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		<!--  Type mismatch: cannot convert from element type Object to User -->
		 <%   List  users=  (ArrayList<User>)request.getAttribute("users");  %>
		 
		<%
			int temp = 0;
			for (User   user : (ArrayList<User>)users) {
				temp++;
		%>
		<tr>
			<td><%=user.getUsername()  %></td>
			<td><%=user.getPassword()  %></td>
			<td><%=user.getAge()  %></td>
			<td><a href="/gllg_auction/delUserInfo?userId=<%=user.getId() %>">回收账号</a>
				<a href="/gllg_auction/updateUserInfoUI?userId=<%=user.getId() %>">修改账号密码</a>
			</td>
		</tr>
		<% } %>
		
	</table>
</body>
</html>
