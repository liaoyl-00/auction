package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.UserDAO;
import com.qianfeng.entity.User;

public class EditUserInfoServlet extends HttpServlet {

	UserDAO dao = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String age = req.getParameter("age");
		
		User user = new User();
		user.setAge(Integer.valueOf(age));
		user.setId(Integer.valueOf(id));
		user.setUsername(username);
		user.setPassword(password);
		dao.updateUserById(user);
		resp.sendRedirect("/gllg_auction/managePage");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
