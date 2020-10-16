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
		// ������ӵڼ��� ��ʼ��ҳ
		// ��ҳ��һ����ʽ �����ʽ���� ��ҳ����-1�� * ҳ�� -- ����ӵڼ������ݿ�ʼ �� ��ʽ
		beginPageNumber = beginPageNumber.subtract(new BigDecimal("1"))
				.multiply(pageNumber);
		return auctionDAO.findAuctionListByPage(beginPageNumber, pageNumber);
	}

	// ��Ҫ��ҳ �ͱ���Ҫ��ȡ���ű�������� ����Ƿ�ҳ��ǰ������
	public BigDecimal getTotalCount() {
		// ��ʹû��ҵ���߼� Ҳ����ֱ���� ���Ʋ����DAO�� ������û���߼������� ��ǰ��Ŀδ�� û��ҵ���߼�
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
		// ������9981 һ��֮�� ��ִ�е����� ֤�����ݶ��ǺϷ��� �Ϳ��������Ľ��� �����
		auctionDAO.addAuction(auctionname, startprice, upsiteprice, starttime,
				endtime, desc,auctionImage);
		return AuctionEnum.AUCTION_ADD_SUCCESS.getValue();
	}


}
