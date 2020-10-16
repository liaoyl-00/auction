package com.qianfeng.auction.test;

import java.util.Random;

import com.qianfeng.entity.Ake;
import com.qianfeng.entity.YaSe;

public class StartGame {

	public static void main(String[] args) {
		// 实例化 (初始化的意思 再说白一点就是 new) 亚瑟 和 阿珂 这两个英雄
		YaSe yaSe = new YaSe();
		yaSe.setHeroName("亚瑟");
		yaSe.setAttckNumber(100);
		yaSe.setblood(1000);
		Ake ake = new Ake();
		ake.setHeroName("阿珂");
		ake.setAttckNumber(200);
		ake.setblood(500);
		while (true) {
			// 如果这里是2 的话 我的随机池就是 0 和 1
			int temp = new Random().nextInt(2);
			if (temp == 0) {
				// 通过下面这行代码 可以很多的体现出来 我们使用 继承来实现了JAVA中多态的这个概念
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
