<%@page import="com.qianfeng.auction.enums.AuctionEnum"%>
<%@page import="com.qianfeng.auction.util.PageVO"%>
<%@page import="com.qianfeng.entity.User"%>
<%@page import="com.qianfeng.entity.Auction"%>
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

<title>My JSP 'auction_datagrid.jsp' starting page</title>

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
	border: 1px solid red;
	width: 150px;
}
</style>

<script type="text/javascript">
<%String msg = request.getParameter("msg") == null ? "" : request
			.getParameter("msg");%>
<%if(msg.equals(AuctionEnum.AUCTION_ADD_SUCCESS.getValue())){%>
   alert("<%=AuctionEnum.AUCTION_ADD_SUCCESS.getDesc()%>");
<%}%>
	
</script>

<script type="text/javascript">
	function auctionAdd() {
		location.href = "auction_add.jsp";
	}
	
</script>

<script type="text/javascript">
	  function  auctionDel(auctionId){ //该函数是用来执行商品的删除功能   需要对传递来的参数进行校验
	  //接口，   基于约定 实现
	   // alert("来了")   判断 方法是否注册成功
	   //在项目中，删除一般是比较敏感的操作， 我们出于用户体验， 最好能给出相应的提示信息
	   // 批量删除       删库跑路操作    rm  -rf
	   
	   //js中 弹窗确定 组件    返回值为true/false
	    var  delConfirm=      window.confirm("是否确定删除？");
	   // alert(delConfirm);
	    if(delConfirm){//用户确认删除 
	        //分析：  执行删除操作         sql    delete   from xxx   where  id=?
	            location.href="http://5502pc85:8080/gllg_auction/AuctionDelServlet?auctionId="+auctionId ;//数据准备好， 执行servlet 接受操作
	     }
	    
	  }
	
</script>
<script type="text/javascript">
    function  updateAutionByIdServlet (auctionId) {
		    //执行 修改请求， 首先执行查询的操作
		    location.href="http://5502pc85:8080/gllg_auction/updateAutionByIdServlet?auctionId="+auctionId ;
	}   
</script>
</head>



<body
	style="background-image:  url('https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3651571102,666258604&fm=26&gp=0.jpg');background-repeat: no-repeat;background-size:100% 100%">
	<center>
		<h1>拍卖品列表</h1>
	</center>
	<a  href="http://5502pc85:8080/gllg_auction/managePage" >进入后台管理页面</a>
	<a href="/gllg_auction/AuctionQuit?type=quit">退出登录</a>
	<table align="center" cellspacing="0" style="text-align: center;">
		<tr style="background-color: gray;">
			<td>拍卖品名</td>
			<td>起始价</td>
			<td>底价</td>
			<td>起拍时间</td>
			<td>结束时间</td>
			<td>拍卖品描述</td>
			<td>拍卖品图片</td>
			<td>操作</td>
		</tr>
		<%
			/* 	List<Auction> auctions = (List<Auction>) request
					.getAttribute("auctions"); */
			PageVO pageVO = (PageVO) request.getAttribute("pageVO");
		%>
		
		<%
			User user = (User) request.getAttribute("userInfo");
		%>
<!-- 		<%=user %> -->
		<%
			int temp = 0;
			for (Auction auction : (List<Auction>) pageVO.getList()) {
				temp++;
		%>
		<%
			if (temp % 2 == 0) {
		%>
		<tr style="background-color:green;">
			<td><%=auction.getAuctionname()%></td>
			<td><%=auction.getAuctionStartPrice()%></td>
			<td><%=auction.getAuctionUpsitePrice()%></td>
			<td><%=auction.getAuctionSartTime()%></td>
			<td><%=auction.getAuctionEndTime()%></td>
			<td><%=auction.getAuctionDESC()%></td>
			<td><img   style="width: 100px ;height: 50px"  src="<%=auction.getAuctionImage()%>"></img>
		 
			</td>
			<td>
<!-- 			<td><button onclick="auctionAdd()">添加</button> -->
			<!-- 修改操作，  需要把当前修改的这条数据的所有的信息， 查询出来       线上办公    oa系统 -->
<!-- 				<button   onclick="updateAutionByIdServlet(<%=auction.getId()%>)">修改</button>   -->
<!-- 				<button   onclick="auctionDel (<%=auction.getId() %>)" >删除</button> -->
				<%
					for(int i=0; i<user.getRole().getResource().size(); i++) {
				%>
				<a href="<%=user.getRole().getResource().get(i).getResourcePath()%>?auctionId=<%=auction.getId()%>">
					<%=user.getRole().getResource().get(i).getResourceName() %></a>
				<%
				} 
				%>
			</td>
			
		</tr>
		<%
			} else {
		%>
		<tr>
			<td><%=auction.getAuctionname()%></td>
			<td><%=auction.getAuctionStartPrice()%></td>
			<td><%=auction.getAuctionUpsitePrice()%></td>
			<td><%=auction.getAuctionSartTime()%></td>
			<td><%=auction.getAuctionEndTime()%></td>
			<td><%=auction.getAuctionDESC()%></td>
			<td><img   style="width: 100px ;height: 50px"  src="<%=auction.getAuctionImage()%>"></img>
			</td>
			<td><button onclick="auctionAdd()">添加</button>
				<button onclick="updateAutionByIdServlet(<%=auction.getId()%>)">修改</button> 
				<button onclick="auctionDel(<%=auction.getId() %>)">删除</button>
			</td>
		</tr>
		<%
			}
			}
		%>
		<tr>
			<td colspan="9">
				<%
					for (int i = 1; i <= pageVO.getEndPage().intValue(); i++) {
						if (i == pageVO.getPageIndex().intValue()) {
				%> <a style="color: red;" href="AuctionListByPage?pageindex=<%=i%>"><%=i%></a>
				<%
					} else {
				%> <a href="AuctionListByPage?pageindex=<%=i%>"><%=i%></a> <%
 	}
 	}
 %>
			</td>
		</tr>
	</table>

</body>
</html>
