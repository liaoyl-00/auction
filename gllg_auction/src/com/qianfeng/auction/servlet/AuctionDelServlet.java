package com.qianfeng.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;   //   Java��Դ������֯   ��Ա �� apache  IBM   ����Ͱ�
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.dao.AuctionDAO;

//import com.sun.net.httpserver.HttpServlet;     ��com.sun.net��ͷ�İ���һ����sun��˾�Լ�������   ����
//HttpServlet     ר�������   Http���� ����������        doget     dopost
/*
     ������ʽ  �����֣�       �����ļ���       web.xml      �����߼���Ϊ����
                                           ע�ⷨ             @WebServlet("/hello")  ����Ķ���ͨ��ע�� ʵ��          ʡ��
 */
//@WebServlet("/hello")  //���������ַ      <url-pattern> ��Ч
public class AuctionDelServlet   extends  HttpServlet{
    
	   AuctionDAO   auctionDAO=new AuctionDAO();  //��ʼ��dao�� �Ķ���
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		     //  ִ��ɾ�� ��Ʒ�Ĺ���  
		String     auctionId=req.getParameter("auctionId");//��ȡ����Ʒ��Ӧ��id
		 //ִ��У��             ʵ�ʿ����Ĺ����У� ǰ��˿����Ƿ����
		 //����ʵ�ʵ��߼�  ��ǰ�˴�����������ȥУ��
		 //���е� jsp������������ȫ��  String���͵�       ��������ת��
		  int   auctionIdInt=Integer.valueOf(auctionId);
		 if(auctionIdInt<=0){
			  //����������
			      try {
					throw  new Exception("ע�⣺ ǰ������ɾ����������ֵid�������⣬���������ǵ�У�����");
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }else {
			 //id ����     ����dao�� ���ɾ���Ĳ���
			 auctionDAO.deleteAuctionById(auctionIdInt);
			 //ɾ���ɹ��� ����Ҫ��ת��  ԭ��Ʒ�б���
			  //http://localhost:8080/auction_datagrid.jsp      ��ʾ����ʾ�� 
			 //ͨ�� �ض�����ת��   ԭ����servlet����  ������ѯ���ݣ� Ȼ������ת��ҳ����
			  //�Ż� �� ɾ���ɹ���û����ʾ�� ֱ����ת��ԭ�����б��ҳ���ϣ�  ���Ƶ㣺 �����û�ɾ���ɹ�����ʾ
			 //  �ؼ�λ�� 
			 resp.sendRedirect("/gllg_auction/AuctionListByPage");
			 
		}
	  
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//  �û��������post  ����  Ĭ�ϵ��� doPost  ����       ��ϣ��д���δ�����   
	    doGet(req, resp);
	}
}
