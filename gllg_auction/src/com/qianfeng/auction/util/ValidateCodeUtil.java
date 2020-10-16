package com.qianfeng.auction.util;

import java.util.Random;

public class ValidateCodeUtil {

	// 只要是UTIL(工具栏)这个包下面的文件 ,所有的函数必须是静态修饰的
	public static String createValidateCode() {
		String validateCode = "1234567890qwertyuioplkjhgfdsazxcvbnm";
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			// charAt 指的根据字符串索引的位置 返回对应的值
			temp.append(validateCode.charAt(new Random().nextInt(validateCode
					.length())));
		}
		return temp.toString();
	}

	public static void main(String[] args) {
		System.out.println(createValidateCode());
	}

}
