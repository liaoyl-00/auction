package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.biz.UserBIZ;
import com.qianfeng.auction.dao.UserDAO;
import com.qianfeng.auction.enums.LoginEnum;
import com.qianfeng.entity.User;

public class UpdateUserInfoUI extends HttpServlet {

	UserDAO dao = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("userId");
		if(userId != null && !userId.equals("")) {
			User user = dao.findUserById(userId);
			req.setAttribute("user", user);
			req.getRequestDispatcher("/editUserInfo.jsp").forward(req, resp);
		}
	}

	

}
