package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.auction.dao.RoleDAO;
import com.qianfeng.entity.User;

//进入后台操作页面     管理员  具备对其他账号进行设置的功能  
// 普通权限的账号， 只能看到自己的信息
public class ManagePage extends HttpServlet {
	RoleDAO dao = new RoleDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 根据登录的用户信息,来判断该账号角色
		HttpSession session = req.getSession(); // 从缓存中获取到user的信息
		User user = (User) session.getAttribute("user");
		// 根据user 的信息去判断角色
		User userSelect = dao.findRoleByUser(user);
		if(userSelect.getRole().getRoleName().equals("超级管理员")) {
			List<User> users = dao.findAllUser();
			req.setAttribute("users", users);
			req.setAttribute("userSelect", userSelect);
			req.getRequestDispatcher("/manageUI.jsp").forward(req, resp);
		}
//		if (roleName == null || roleName.equals("")) {
//			// 没有查询到
//			resp.sendRedirect("/index.jsp");
//		} else if (roleName.equals("超级管理员")) {
//			// 最高权限 希望具备修改其他账号的信息
//			List<User> users = dao.findAllUser();
//            //转发页面了
//			req.setAttribute("users", users);
//			req.getRequestDispatcher("/manageUI.jsp").forward(req, resp);
//		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);

	}
}
