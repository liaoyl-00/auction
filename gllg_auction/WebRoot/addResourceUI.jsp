<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addResourceUI.jsp' starting page</title>
    
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
  		<h1>添加资源</h1>
  	</center>
  	<form action="/gllg_auction/ResourceManage?method=addResource" method="post">
  		<table width="400px" border="1px" align="center">
  		<tr>
			<td>资源名</td>
			<td><input name="resourceName" /></td>
		</tr>
		<tr>
			<td>资源路径</td>
			<td><input name="resourcePath" /></td>
		</tr>
		<tr>
			<td colspan="2"><button>确认添加</button>
			</td>
		</tr>
  		</table>
  	
  	</form>
  </body>
</html>
