package com.qianfeng.auction.enums;

public enum LoginEnum {

	USER_LOGIN_USER_NAME_IS_NULL("user_login_user_name_is_null", "�û���Ϊ��"), USER_LOGIN_USER_VALIDATE_CODE_FAIL(
			"user_login_user_validate_code_fail", "��֤�����"), USER_LOGIN_USER_NAME_OR_PASSWORD_FAIL(
			"user_login_user_name_or_password_fail", "�û������������"), USER_LOGIN_SUCCESS(
			"user_login_success", "��¼�ɹ�");

	private String value;
	private String desc;

	private LoginEnum(String value, String desc) {
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
