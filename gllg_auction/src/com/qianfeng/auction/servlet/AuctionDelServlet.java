package com.qianfeng.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;   //   Java开源社区组织   成员 ： apache  IBM   阿里巴巴
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.AuctionDAO;

//import com.sun.net.httpserver.HttpServlet;     已com.sun.net开头的包，一般是sun公司自己开发的   不用
//HttpServlet     专门针对于   Http请求 来开发的类        doget     dopost
/*
     开发方式  分俩种：       配置文件法       web.xml      条理逻辑更为清晰
                                           注解法             @WebServlet("/hello")  在类的顶部通过注解 实现          省事
 */
//@WebServlet("/hello")  //配置请求地址      <url-pattern> 等效
public class AuctionDelServlet   extends  HttpServlet{
    
	   AuctionDAO   auctionDAO=new AuctionDAO();  //初始化dao层 的对象
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		     //  执行删除 商品的功能  
		String     auctionId=req.getParameter("auctionId");//获取到商品对应的id
		 //执行校验             实际开发的过程中， 前后端可能是分离的
		 //根据实际的逻辑  对前端传递来的数据去校验
		 //所有的 jsp传递来的数据全是  String类型的       进行类型转换
		  int   auctionIdInt=Integer.valueOf(auctionId);
		 if(auctionIdInt<=0){
			  //数据有问题
			      try {
					throw  new Exception("注意： 前端数据删除操作返回值id存在问题，不符合我们的校验规则");
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }else {
			 //id 正常     调用dao层 完成删除的操作
			 auctionDAO.deleteAuctionById(auctionIdInt);
			 //删除成功后 ，需要跳转到  原商品列表下
			  //http://localhost:8080/auction_datagrid.jsp      演示错误示例 
			 //通过 重定向跳转到   原来的servlet请求，  继续查询数据， 然后再跳转到页面上
			  //优化 ： 删除成功后，没有提示， 直接跳转到原来的列表的页面上，  完善点： 给出用户删除成功的提示
			 //  关键位置 
			 resp.sendRedirect("/gllg_auction/AuctionListByPage");
			 
		}
	  
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//  用户发起的是post  请求，  默认调用 doPost  方法       不希望写俩次处理方法   
	    doGet(req, resp);
	}
}
