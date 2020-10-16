<%@page import="com.qianfeng.auction.enums.LoginEnum"%>
<%@page import="com.qianfeng.auction.util.ValidateCodeUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	// 这里你千万万千 不要手敲代码 因为手敲  不具有自动导包的功能
	// 在JSP文件中 聲明的变量 都是成员变量 (在当前文件中 都是生效的 这种变量就叫做成员变量)
	String validateCode = ValidateCodeUtil.createValidateCode();
	session.setAttribute("syscode", validateCode);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
td {
	width: 200px;
}

input {
	width: 200px;
}
</style>

<script type="text/javascript">
		window.onload=function(){
			document.querySelector('#vimg').addEventListener('click',function(){
				let now = new Date();
				this.src='http://192.168.0.151:8080/gllg_auction/ValidatecodeServlet?v='+now.getTime();
			});
		}
</script>


<script type="text/javascript">
	
<%String msg = request.getParameter("msg") == null ? "" :request.getParameter("msg");%>
	
<%
   if(msg.equals(LoginEnum.USER_LOGIN_USER_NAME_IS_NULL.getValue())) {
%>
   alert("<%=LoginEnum.USER_LOGIN_USER_NAME_IS_NULL.getDesc() %>");
<%
}
%>

<%
   if(msg.equals(LoginEnum.USER_LOGIN_USER_VALIDATE_CODE_FAIL.getValue())) {
%>
   alert("<%=LoginEnum.USER_LOGIN_USER_VALIDATE_CODE_FAIL.getDesc() %>");
<%
}
%>

<%
   if(msg.equals(LoginEnum.USER_LOGIN_USER_NAME_OR_PASSWORD_FAIL.getValue())) {
%>
   alert("<%=LoginEnum.USER_LOGIN_USER_NAME_OR_PASSWORD_FAIL.getDesc() %>");
<%
}
%>

<%
   if(msg.equals(LoginEnum.USER_LOGIN_SUCCESS.getValue())) {
%>
   alert("<%=LoginEnum.USER_LOGIN_SUCCESS.getDesc() %>");
<%
}
%>
	
</script>

</head>

<!-- <body
	style="padding-top: 100px;background-image: url('https://pt.1000phone.net/static/img/fyzh_login1.824f963.jpg');background-repeat: no-repeat;background-size: 100% 100% "> -->

<body style="padding-top: 100px; ">
	<!-- ctrl + shift + /  是注释代码-->
	<div style="float: left;">
		<form action="LoginServlet" method="post" style="margin-left: 100px">
			<h1 style="color: green; margin-top: 100px;margin-left: 100px">零零测试网</h1>
			<table style="text-align: center;">
				<tr>
					<td>用户名</td>
					<td><input name="username" placeholder="请输入用户名"/>
					</td>
				</tr>
				<tr>
					<td>密 码</td>
					<td><input name="password" type="password"placeholder="请输入密码">
					</td>
				</tr>
				<tr>
					<td> <img  src="http://5502pc85:8080/gllg_auction/ValidatecodeServlet" id="vimg"></td>
					<td><input name="validatecode" placeholder="点击图片可刷新验证码"></td>
				</tr>
				<tr>
					<td colspan="2"><button>登录</button>
					</td>
				</tr>
			</table>
	</div>

	<div style="float: left;margin-left: 100px">
		<img
			src="http://www.zhideedu.com/UploadFiles/img_0_2910430221_630635169_26.jpg"/>
	</div>
	<script type="text/javascript">
		window.onload=function(){
			document.querySelector('#vimg').addEventListener('click',function(){
				let now = new Date();
				this.src='/gllg_auction/ValidatecodeServlet?v='+now.getTime();
			});
		}
	</script>




</body>
</html>
