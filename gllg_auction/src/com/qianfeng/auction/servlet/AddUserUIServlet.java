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
import com.qianfeng.entity.User;

public class AddUserUIServlet extends HttpServlet {

	RoleDAO dao = new RoleDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		List<Role> roles = dao.findAllRole();
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("/addUser.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
