package com.qianfeng.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.AuctionDAO;
import com.qianfeng.entity.Auction;

public class AutionUpdateServlet extends HttpServlet {
	// 声明dao层的实例化对象 依赖dao层 数据持久层 功能数据库的连接以及对数据库增删改查的功能
	AuctionDAO auctionDAO = new AuctionDAO(); // 善用alt+/ 快捷键指令 作用联想关联

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// http://localhost:8080/gllg_auction/
		// updateAutionByIdServlet?auctionId=9
		// updateAutionByIdServlet
		String autionId = req.getParameter("auctionId");
		// 数据回显 查询中返回数据的术语
		// 根据前端传递来的数据 ， 查询到该条数据
		Auction auction = auctionDAO.findAuctionById(autionId);
             //根据我们单元测试出来的结果， 返回值可能为空  
		if(auction.getAuctionname().equals("")){
			  //说明该id 对应的数据，不存在
			System.out.println("id无效");
		} 
		else {
			auction.setId(Integer.valueOf(autionId));
			
		}
		//数据初始化结束 ， 下一步跳转页面了 
		//转发   or  重定向    转发 
		req.setAttribute("auction", auction); //数据发送到页面上
		 req.getRequestDispatcher("/auction_update.jsp").forward(req, resp);
		 //  404 HTTP Status 404 - /gllg_auction/auction_update.jsp
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
