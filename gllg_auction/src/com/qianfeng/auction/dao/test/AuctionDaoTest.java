package com.qianfeng.auction.dao.test;

import org.junit.Test;

import com.qianfeng.auction.dao.AuctionDAO;

public class AuctionDaoTest {
  
	
	   @Test
	   public  void  testAuctionSelect(){
		      new AuctionDAO().findAuctionById("29");
		      //单元测试成功了     并且有输出了。 com.qianfeng.entity.Auction@a210b5b
		      //   com.qianfeng.entity.Auction@a210b5b     System.out.println(auction);
		      // 直接打印对象名，  系统默认的返回的是类的路径+地址值的算术表达形式
		      
		      
	   }
}
