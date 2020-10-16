package com.qianfeng.auction.biz;

import com.qianfeng.auction.dao.UserDAO;
import com.qianfeng.auction.enums.LoginEnum;
import com.qianfeng.entity.User;

public class UserBIZ {

	UserDAO userDAO = new UserDAO();

	public String login(String username, String password, String syscode,
			String validatecode) {
		if (username == null || username.equals("")) {
			return LoginEnum.USER_LOGIN_USER_NAME_IS_NULL.getValue();
		}
		if (syscode == null || syscode.equals("") || validatecode == null
				|| validatecode.equals("")) {
			return LoginEnum.USER_LOGIN_USER_VALIDATE_CODE_FAIL.getValue();
		}
		if (!validatecode.equals(syscode)) {
			return LoginEnum.USER_LOGIN_USER_VALIDATE_CODE_FAIL.getValue();
		}
		User user = userDAO.login(username, password);
		if (user == null) {
			return LoginEnum.USER_LOGIN_USER_NAME_OR_PASSWORD_FAIL.getValue();
		}
		return LoginEnum.USER_LOGIN_SUCCESS.getValue();
	}

}
