package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.biz.UserBIZ;
import com.qianfeng.auction.enums.LoginEnum;
import com.qianfeng.entity.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		req.getSession().setAttribute("user", user);
		String validatecode = req.getParameter("validatecode");// 从页面获取到的用户录入的验证码
		// 与session中存储的验证码比对
		String syscode = (String) req.getSession().getAttribute("valCode");
		UserBIZ userBIZ = new UserBIZ();
		String result = userBIZ
				.login(username, password, syscode, validatecode);

		if (result.equals(LoginEnum.USER_LOGIN_SUCCESS.getValue())) {
			req.getRequestDispatcher("AuctionListByPage").forward(req, resp);
			req.getSession().setAttribute("user", user);
		} else {
			req.getRequestDispatcher("index.jsp?msg=" + result + "").forward(
					req, resp);
		}
	}

}
