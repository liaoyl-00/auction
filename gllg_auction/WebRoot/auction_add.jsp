<%@page import="com.qianfeng.auction.enums.AuctionEnum"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'auction_add.jsp' starting page</title>

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
	border: 1px solid green;
}
</style>
<%
	String msg = request.getParameter("msg") == null ? "" : request
			.getParameter("msg");
%>
<script type="text/javascript">
<%
   if(msg.equals(AuctionEnum.AUCTION_NAME_IS_NULL.getValue())){
 %>
   alert("<%=AuctionEnum.AUCTION_NAME_IS_NULL.getDesc()%>");
<%
   }
%>

<%
   if(msg.equals(AuctionEnum.AUCTION_DATE_IS_FAIL.getValue())){
 %>
   alert("<%=AuctionEnum.AUCTION_DATE_IS_FAIL.getDesc()%>");
<%
   }
%>

<%
   if(msg.equals(AuctionEnum.AUCTION_PRICE_IS_FAIL.getValue())){
 %>
   alert("<%=AuctionEnum.AUCTION_PRICE_IS_FAIL.getDesc()%>");
<%
   }
%>

<%
   if(msg.equals(AuctionEnum.AUCTION_DESC_IS_FAIL.getValue())){
 %>
   alert("<%=AuctionEnum.AUCTION_DESC_IS_FAIL.getDesc()%>");
<%
   }
%>
</script>
</head>

<body
	style="background-image:  url('https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4148059623,3397518472&fm=26&gp=0.jpg');background-repeat: no-repeat;background-size:100% 100%">

	<form action="AuctionAddServlet" method="post"    enctype="multipart/form-data"
		style="margin-top: 200px">
		<center>
			<h1>拍卖品添加</h1>
		</center>
		<table align="center"
			style="text-align: center;border: 1px solid green;" cellspacing="0px">
			<tr>
				<td>拍卖品名</td>
				<td><input name="auctionname">
				</td>
			</tr>
			<tr>
				<td>起始价</td>
				<td><input name="auctionstartprice">
				</td>
			</tr>
			<tr>
				<td>低价</td>
				<td><input name="auctionupsiteprice">
				</td>
			</tr>
			<tr>
				<td>起拍时间</td>
				<td><input name="auctionsarttime">
				</td>
			</tr>
			<tr>
				<td>结束时间</td>
				<td><input name="auctionendtime">
				</td>
			</tr>
			<tr>
			     <td>拍卖品图片</td>
			      <td><input   type="file"     name="pic" ></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea rows="" cols="" name="auctiondesc"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><button style="margin-left: 200px;">添加</button>
				</td>
			</tr>
		</table>

	</form>


</body>
</html>
