package com.qianfeng.auction.test;

import java.util.Random;

import com.qianfeng.entity.Ake;
import com.qianfeng.entity.YaSe;

public class StartGame {

	public static void main(String[] args) {
		// ʵ���� (��ʼ������˼ ��˵��һ����� new) ��ɪ �� ���� ������Ӣ��
		YaSe yaSe = new YaSe();
		yaSe.setHeroName("��ɪ");
		yaSe.setAttckNumber(100);
		yaSe.setblood(1000);
		Ake ake = new Ake();
		ake.setHeroName("����");
		ake.setAttckNumber(200);
		ake.setblood(500);
		while (true) {
			// ���������2 �Ļ� �ҵ�����ؾ��� 0 �� 1
			int temp = new Random().nextInt(2);
			if (temp == 0) {
				// ͨ���������д��� ���Ժܶ�����ֳ��� ����ʹ�� �̳���ʵ����JAVA�ж�̬���������
				yaSe.attck(ake);
				if (ake.getblood() <= 0) {
					yaSe.successMSG();
					break;
				}
			}
			if (temp == 1) {
				ake.attck(yaSe);
				if (yaSe.getblood() <= 0) {
					ake.successMSG();
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
