package com.qianfeng.auction.dao.test;

import org.junit.Test;

import com.qianfeng.auction.dao.AuctionDAO;

public class AuctionDaoTest {
  
	
	   @Test
	   public  void  testAuctionSelect(){
		      new AuctionDAO().findAuctionById("29");
		      //��Ԫ���Գɹ���     ����������ˡ� com.qianfeng.entity.Auction@a210b5b
		      //   com.qianfeng.entity.Auction@a210b5b     System.out.println(auction);
		      // ֱ�Ӵ�ӡ��������  ϵͳĬ�ϵķ��ص������·��+��ֵַ�����������ʽ
		      
		      
	   }
}
