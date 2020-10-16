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

//�����̨����ҳ��     ����Ա  �߱��������˺Ž������õĹ���  
// ��ͨȨ�޵��˺ţ� ֻ�ܿ����Լ�����Ϣ
public class ManagePage extends HttpServlet {
	RoleDAO dao = new RoleDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ���ݵ�¼���û���Ϣ,���жϸ��˺Ž�ɫ
		HttpSession session = req.getSession(); // �ӻ����л�ȡ��user����Ϣ
		User user = (User) session.getAttribute("user");
		// ����user ����Ϣȥ�жϽ�ɫ
		User userSelect = dao.findRoleByUser(user);
		if(userSelect.getRole().getRoleName().equals("��������Ա")) {
			List<User> users = dao.findAllUser();
			req.setAttribute("users", users);
			req.setAttribute("userSelect", userSelect);
			req.getRequestDispatcher("/manageUI.jsp").forward(req, resp);
		}
//		if (roleName == null || roleName.equals("")) {
//			// û�в�ѯ��
//			resp.sendRedirect("/index.jsp");
//		} else if (roleName.equals("��������Ա")) {
//			// ���Ȩ�� ϣ���߱��޸������˺ŵ���Ϣ
//			List<User> users = dao.findAllUser();
//            //ת��ҳ����
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
