package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.ResourceDAO;
import com.qianfeng.entity.Role;

public class ResourceManage extends HttpServlet {

	ResourceDAO dao = new ResourceDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String method = req.getParameter("method");
		if(method.equals("addResource")) {
			try {
				addResource(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		resp.sendRedirect("/gllg_auction/managePage");
		} else if(method.equals("listResource")) {
			listResource(req, resp);
		}
		
	}

	private void listResource(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void addResource(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		String resourceName = req.getParameter("resourceName");
		String resourcePath = req.getParameter("resourcePath");
		dao.saveResource(resourceName, resourcePath);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);

	}
}
