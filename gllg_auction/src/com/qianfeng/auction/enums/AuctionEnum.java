package com.qianfeng.auction.enums;

public enum AuctionEnum {

	// ctrl + shift + y||x
	AUCTION_NAME_IS_NULL("auction_name_is_null", "����Ʒ������Ϊ��"), AUCTION_DATE_IS_FAIL(
			"auction_date_is_fail", "���ڲ���ȷ"), AUCTION_PRICE_IS_FAIL(
			"auction_price_is_fail", "�۸���ȷ"), AUCTION_DESC_IS_FAIL(
			"auction_desc_is_fail", "��������Ϊ��"), AUCTION_ADD_SUCCESS(
			"auction_add_success", "��ӳɹ�"), AUCTION_UPDATE_SUCESS(
			"auction_update_sucess", "�޸ĳɹ�");

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
