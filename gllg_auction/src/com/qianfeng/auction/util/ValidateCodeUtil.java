package com.qianfeng.auction.util;

import java.util.Random;

public class ValidateCodeUtil {

	// ֻҪ��UTIL(������)�����������ļ� ,���еĺ��������Ǿ�̬���ε�
	public static String createValidateCode() {
		String validateCode = "1234567890qwertyuioplkjhgfdsazxcvbnm";
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			// charAt ָ�ĸ����ַ���������λ�� ���ض�Ӧ��ֵ
			temp.append(validateCode.charAt(new Random().nextInt(validateCode
					.length())));
		}
		return temp.toString();
	}

	public static void main(String[] args) {
		System.out.println(createValidateCode());
	}

}
