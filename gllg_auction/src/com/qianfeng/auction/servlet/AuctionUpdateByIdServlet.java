package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.AuctionDAO;
import com.qianfeng.entity.Auction;

//  url  AuctionUpdateByIdServlet
public class AuctionUpdateByIdServlet extends HttpServlet {
     AuctionDAO   dao =new AuctionDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");//设置编码
		//页面乱码情况出现分析  
		 //  01.  从页面获取到我们的程序这边出问题了   
		// System.out.println("修改操作请i求，接受成功");
		// 01.获取页面数据，
		//02. 控制台能正常显示， 从页面获取的数据没有问题，   dao层。 从程序中往数据库中存储出问题了
		Auction auction = new Auction();
		auction.setId(Integer.valueOf(req.getParameter("id")));
        auction.setAuctionname(req.getParameter("auctionname"));
        System.out.println(auction.getAuctionname());
        auction.setAuctionStartPrice(Integer.valueOf(req.getParameter("auctionstartprice")));
        auction.setAuctionUpsitePrice(Integer.valueOf(req.getParameter("auctionupsiteprice")));
        //setAuctionSartTime(Timestamp auctionSartTime)  时间类型Timestamp    ，页面返回的时间类型为 String  字符串
          //问题 是      时间类型   从  String    ---->   Timestamp
        auction.setAuctionDESC(req.getParameter("auctiondesc"));   
		// 02.调用dao层 完成数据的更新 update auction set auctionname ="蛮王" where id=?
		// update 表名 set 列名称 =数据 where 条件
        dao.updateAuctionById(auction);
        
        resp.sendRedirect("/gllg_auction/AuctionListByPage");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
