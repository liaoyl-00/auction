package com.qianfeng.entity;

import java.io.Serializable;

public class Auction implements Serializable {

	private int id;
	private String auctionname;
	private int auctionStartPrice;
	private int auctionUpsitePrice;
	private java.sql.Timestamp auctionSartTime;
	private java.sql.Timestamp auctionEndTime;
	private String auctionDESC;
	private java.sql.Timestamp auctionCreateTime;
	private java.sql.Timestamp auctionUpdateTime;
	private String auctionImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuctionname() {
		return auctionname;
	}

	public void setAuctionname(String auctionname) {
		this.auctionname = auctionname;
	}

	public int getAuctionStartPrice() {
		return auctionStartPrice;
	}

	public void setAuctionStartPrice(int auctionStartPrice) {
		this.auctionStartPrice = auctionStartPrice;
	}

	public int getAuctionUpsitePrice() {
		return auctionUpsitePrice;
	}

	public void setAuctionUpsitePrice(int auctionUpsitePrice) {
		this.auctionUpsitePrice = auctionUpsitePrice;
	}

	public java.sql.Timestamp getAuctionSartTime() {
		return auctionSartTime;
	}

	public void setAuctionSartTime(java.sql.Timestamp auctionSartTime) {
		this.auctionSartTime = auctionSartTime;
	}

	public java.sql.Timestamp getAuctionEndTime() {
		return auctionEndTime;
	}

	public void setAuctionEndTime(java.sql.Timestamp auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}

	public String getAuctionDESC() {
		return auctionDESC;
	}

	public void setAuctionDESC(String auctionDESC) {
		this.auctionDESC = auctionDESC;
	}

	public java.sql.Timestamp getAuctionCreateTime() {
		return auctionCreateTime;
	}

	public void setAuctionCreateTime(java.sql.Timestamp auctionCreateTime) {
		this.auctionCreateTime = auctionCreateTime;
	}

	public java.sql.Timestamp getAuctionUpdateTime() {
		return auctionUpdateTime;
	}

	public void setAuctionUpdateTime(java.sql.Timestamp auctionUpdateTime) {
		this.auctionUpdateTime = auctionUpdateTime;
	}

	public String getAuctionImage() {
		return auctionImage;
	}

	public void setAuctionImage(String auctionImage) {
		this.auctionImage = auctionImage;
	}

	//重写toString 方法    右键页面      点击  source     点击toString（）   自动生成
	@Override
	public String toString() {
		return "Auction [id=" + id + ", auctionname=" + auctionname
				+ ", auctionStartPrice=" + auctionStartPrice
				+ ", auctionUpsitePrice=" + auctionUpsitePrice
				+ ", auctionSartTime=" + auctionSartTime + ", auctionEndTime="
				+ auctionEndTime + ", auctionDESC=" + auctionDESC
				+ ", auctionCreateTime=" + auctionCreateTime
				+ ", auctionUpdateTime=" + auctionUpdateTime
				+ ", auctionImage=" + auctionImage + "]";
	}
   
	
	
}
