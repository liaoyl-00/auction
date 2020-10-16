package com.qianfeng.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.AuctionDAO;
import com.qianfeng.entity.Auction;

public class AutionUpdateServlet extends HttpServlet {
	// ����dao���ʵ�������� ����dao�� ���ݳ־ò� �������ݿ�������Լ������ݿ���ɾ�Ĳ�Ĺ���
	AuctionDAO auctionDAO = new AuctionDAO(); // ����alt+/ ��ݼ�ָ�� �����������

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// http://localhost:8080/gllg_auction/
		// updateAutionByIdServlet?auctionId=9
		// updateAutionByIdServlet
		String autionId = req.getParameter("auctionId");
		// ���ݻ��� ��ѯ�з������ݵ�����
		// ����ǰ�˴����������� �� ��ѯ����������
		Auction auction = auctionDAO.findAuctionById(autionId);
             //�������ǵ�Ԫ���Գ����Ľ���� ����ֵ����Ϊ��  
		if(auction.getAuctionname().equals("")){
			  //˵����id ��Ӧ�����ݣ�������
			System.out.println("id��Ч");
		} 
		else {
			auction.setId(Integer.valueOf(autionId));
			
		}
		//���ݳ�ʼ������ �� ��һ����תҳ���� 
		//ת��   or  �ض���    ת�� 
		req.setAttribute("auction", auction); //���ݷ��͵�ҳ����
		 req.getRequestDispatcher("/auction_update.jsp").forward(req, resp);
		 //  404 HTTP Status 404 - /gllg_auction/auction_update.jsp
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
