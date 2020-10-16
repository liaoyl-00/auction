package com.qianfeng.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.biz.AuctionBIZ;

public class AuctionList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AuctionBIZ auctionBIZ = new AuctionBIZ();
		java.util.List<com.qianfeng.entity.Auction> auctionList = auctionBIZ
				.getAll();
		// 把所有的拍卖放入到 请求报文中
		req.setAttribute("auctions", auctionList);
		req.getRequestDispatcher("auction_datagrid.jsp").forward(req, resp);
	}

}
