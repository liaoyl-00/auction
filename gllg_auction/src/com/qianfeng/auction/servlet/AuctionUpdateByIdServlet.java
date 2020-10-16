package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.AuctionDAO;
import com.qianfeng.entity.Auction;

//  url  AuctionUpdateByIdServlet
public class AuctionUpdateByIdServlet extends HttpServlet {
     AuctionDAO   dao =new AuctionDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");//���ñ���
		//ҳ������������ַ���  
		 //  01.  ��ҳ���ȡ�����ǵĳ�����߳�������   
		// System.out.println("�޸Ĳ�����i�󣬽��ܳɹ�");
		// 01.��ȡҳ�����ݣ�
		//02. ����̨��������ʾ�� ��ҳ���ȡ������û�����⣬   dao�㡣 �ӳ����������ݿ��д洢��������
		Auction auction = new Auction();
		auction.setId(Integer.valueOf(req.getParameter("id")));
        auction.setAuctionname(req.getParameter("auctionname"));
        System.out.println(auction.getAuctionname());
        auction.setAuctionStartPrice(Integer.valueOf(req.getParameter("auctionstartprice")));
        auction.setAuctionUpsitePrice(Integer.valueOf(req.getParameter("auctionupsiteprice")));
        //setAuctionSartTime(Timestamp auctionSartTime)  ʱ������Timestamp    ��ҳ�淵�ص�ʱ������Ϊ String  �ַ���
          //���� ��      ʱ������   ��  String    ---->   Timestamp
        auction.setAuctionDESC(req.getParameter("auctiondesc"));   
		// 02.����dao�� ������ݵĸ��� update auction set auctionname ="����" where id=?
		// update ���� set ������ =���� where ����
        dao.updateAuctionById(auction);
        
        resp.sendRedirect("/gllg_auction/AuctionListByPage");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
