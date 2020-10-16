package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.auction.dao.ResourceDAO;
import com.qianfeng.auction.dao.RoleDAO;
import com.qianfeng.entity.Resource;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;

public class RoleManage extends HttpServlet {

	RoleDAO roledao = new RoleDAO();
	ResourceDAO resourceDAO = new ResourceDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String method = req.getParameter("method");
		if(method.equals("findAllRoles")) {
			findAllRoles(req, resp);
		} else if (method.equals("addRoleUI")) {
				try {
					addRoleUI(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else if (method.equals("addRole")) {
			try {
				addRole(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	private void addRole(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		String roleName = req.getParameter("roleName");
		String[] resourceIds = req.getParameterValues("resource");
		roledao.addRole(roleName, resourceIds);
		try {
			resp.sendRedirect("/gllg_auction/managePage");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	private void addRoleUI(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		try {
			List<Resource> resources = resourceDAO.findAllResource();
			req.setAttribute("resources", resources);
			req.getRequestDispatcher("/addRole.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private void findAllRoles(HttpServletRequest req, HttpServletResponse resp) {
		
		List<Role> roles = roledao.findAllRole();
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);

	}

}
