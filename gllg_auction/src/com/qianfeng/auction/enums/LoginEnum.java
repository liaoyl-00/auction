package com.qianfeng.auction.enums;

public enum LoginEnum {

	USER_LOGIN_USER_NAME_IS_NULL("user_login_user_name_is_null", "用户名为空"), USER_LOGIN_USER_VALIDATE_CODE_FAIL(
			"user_login_user_validate_code_fail", "验证码错误"), USER_LOGIN_USER_NAME_OR_PASSWORD_FAIL(
			"user_login_user_name_or_password_fail", "用户名或密码错误"), USER_LOGIN_SUCCESS(
			"user_login_success", "登录成功");

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
