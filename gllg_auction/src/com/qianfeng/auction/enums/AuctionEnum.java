package com.qianfeng.auction.enums;

public enum AuctionEnum {

	// ctrl + shift + y||x
	AUCTION_NAME_IS_NULL("auction_name_is_null", "拍卖品名不能为空"), AUCTION_DATE_IS_FAIL(
			"auction_date_is_fail", "日期不正确"), AUCTION_PRICE_IS_FAIL(
			"auction_price_is_fail", "价格不正确"), AUCTION_DESC_IS_FAIL(
			"auction_desc_is_fail", "描述不能为空"), AUCTION_ADD_SUCCESS(
			"auction_add_success", "添加成功"), AUCTION_UPDATE_SUCESS(
			"auction_update_sucess", "修改成功");

	private String value;
	private String desc;

	// alt + shift +S
	private AuctionEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
