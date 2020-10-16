package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.RoleDAO;
import com.qianfeng.auction.dao.UserDAO;
import com.qianfeng.entity.Role;

public class AddUserServlet extends HttpServlet {

	UserDAO dao = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String roleId = req.getParameter("role");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String age = req.getParameter("age");
		dao.addUser(roleId, username, password, age);
		resp.sendRedirect("/gllg_auction/managePage");
		//req.getRequestDispatcher("/manageUI.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
