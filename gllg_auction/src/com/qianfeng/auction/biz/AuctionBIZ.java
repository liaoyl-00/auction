package com.qianfeng.auction.biz;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.qianfeng.auction.dao.AuctionDAO;
import com.qianfeng.auction.enums.AuctionEnum;
import com.qianfeng.entity.Auction;
import com.sun.org.apache.regexp.internal.recompile;

public class AuctionBIZ {
	AuctionDAO auctionDAO = new AuctionDAO();

	public java.util.List<Auction> getAll() {
		return auctionDAO.getAll();
	}

	public java.util.List<Auction> findAuctionListByPage(
			BigDecimal beginPageNumber, BigDecimal pageNumber) {
		// 计算出从第几天 开始分页
		// 分页有一个公式 这个公式就是 （页索引-1） * 页码 -- 计算从第几条数据开始 的 公式
		beginPageNumber = beginPageNumber.subtract(new BigDecimal("1"))
				.multiply(pageNumber);
		return auctionDAO.findAuctionListByPage(beginPageNumber, pageNumber);
	}

	// 想要分页 就必须要获取这张表的总条数 这个是分页的前置条件
	public BigDecimal getTotalCount() {
		// 即使没有业务逻辑 也不能直接用 控制层调用DAO层 你现在没有逻辑不代表 当前项目未来 没有业务逻辑
		return auctionDAO.getTotalCount();
	}

	public String addAuction(String auctionname, String startprice,
			String upsiteprice, String starttime, String endtime, String desc,String auctionImage) {
		if (auctionname == null || auctionname.equals("")) {
			return AuctionEnum.AUCTION_NAME_IS_NULL.getValue();
		}
		try {
			if (Integer.parseInt(startprice) <= 0) {
				return AuctionEnum.AUCTION_PRICE_IS_FAIL.getValue();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return AuctionEnum.AUCTION_PRICE_IS_FAIL.getValue();
		}
		try {
			if (Integer.parseInt(upsiteprice) <= 0) {
				return AuctionEnum.AUCTION_PRICE_IS_FAIL.getValue();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return AuctionEnum.AUCTION_PRICE_IS_FAIL.getValue();
		}
		try {
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(starttime);
		} catch (Exception e) {
			e.printStackTrace();
			return AuctionEnum.AUCTION_DATE_IS_FAIL.getValue();
		}
		try {
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endtime);
		} catch (Exception e) {
			e.printStackTrace();
			return AuctionEnum.AUCTION_DATE_IS_FAIL.getValue();
		}
		if (desc == null || desc.equals("")) {
			return AuctionEnum.AUCTION_DESC_IS_FAIL.getValue();
		}
		// 经历了9981 一难之后 能执行到这里 证明数据都是合法的 就可以正常的进行 添加了
		auctionDAO.addAuction(auctionname, startprice, upsiteprice, starttime,
				endtime, desc,auctionImage);
		return AuctionEnum.AUCTION_ADD_SUCCESS.getValue();
	}


}
