<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        <h3>文件上传</h3>        <!--  不显示于地址栏都用post提交方法 -->
         <!--  enctype="application/x-www-form-urlencoded"    form 表单默认自带的格式 
            只要 涉及到上传文件  必须把表单类型修改成   enctype="multipart/form-data
         -->
        <form action="/gllg_auction/uploadServlet"  method="post"    enctype="multipart/form-data">
           账号： <input   type="text"   name="username"> <br>
     密码：  <input   type="password"   name="password"><br>
     头像：  <input    type="file"  name="heading"> <br>
         <input type="submit"   value="注册">
        </form>
  </body>
</html>
