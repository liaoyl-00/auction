package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.biz.AuctionBIZ;
import com.qianfeng.auction.dao.UserDAO;
import com.qianfeng.auction.util.PageVO;
import com.qianfeng.entity.Auction;
import com.qianfeng.entity.User;

// Ϊ������������datagrid��Ҫ����ҳ
// ��Ϊ��ҳ��������û�������
// ��Ϊ��ҳ����������ݵĲ�ѯ�ٶ�
public class AuctionListByPage extends HttpServlet {

	UserDAO dao = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��ȡҳ������ ���û�л�ȡ�� ��ôĬ�Ͼ��ǵ�һҳ
		String pageindex = req.getParameter("pageindex") == null ? "1" : req
				.getParameter("pageindex");
		String pagenumber = req.getParameter("pagenumber") == null ? "10" : req
				.getParameter("pagenumber");
		// ��ȡ������
		AuctionBIZ auctionBIZ = new AuctionBIZ();
		BigDecimal totalCount = auctionBIZ.getTotalCount();
		// ����ҳ������� ���в�ѯ
		List<Auction> auctionList = auctionBIZ.findAuctionListByPage(
				new BigDecimal(pageindex), new BigDecimal(pagenumber));
		// �������ͷ�ҳ���� ��ʵ����֮�� ���ǾͿ���ʵ����PAGEVO��
		PageVO<Auction> pageVO = new PageVO<Auction>();
		pageVO.setList(auctionList);
		pageVO.setPageIndex(new BigDecimal(pageindex));
		pageVO.setPageNumber(new BigDecimal(pagenumber));
		pageVO.setTotal(totalCount);
		// ���������� 11������ ����ҳҪ ��3ҳ����
		pageVO.setEndPage(totalCount.divide(new BigDecimal(pagenumber), 0,
				BigDecimal.ROUND_UP));
		// ���ѽ�ʵ�����õ� pageVO�洢����������
		// setAttrubute�� ?pageIndex=xxxx ���������к�����
		// setAttrubute��������Ϊ���������� һ��ʹ�����ַ�ʽ �洢
		// ? һ���û���Ϊ���µ����� һ���ʹ����� ?
		User user = (User) req.getSession().getAttribute("user");
		User userInfo = dao.findAllUserInfo(user);
		req.setAttribute("userInfo", userInfo);
		req.setAttribute("pageVO", pageVO);
		// ת����auction_datagrid.jsp ����ļ�
		req.getRequestDispatcher("auction_datagrid.jsp").forward(req, resp);
	}

}
