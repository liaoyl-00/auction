package com.qianfeng.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.qianfeng.auction.dao.UserDAO;
// url delUserInfo
public class DelUserInfoServlet   extends  HttpServlet{
        UserDAO   dao =new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	     String  userId=req.getParameter("userId");
	     dao.delUserById(userId);
	     
	     resp.sendRedirect("/gllg_auction/managePage");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	  doGet(req, resp);}
}
