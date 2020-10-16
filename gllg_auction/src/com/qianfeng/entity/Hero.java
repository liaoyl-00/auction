package com.qianfeng.entity;

public class Hero {
	private String heroName;
	private int attckNumber;
	private int blood;
	
	
	
	public Hero() {
	}

	public Hero(String heroName, int attckNumber, int blood) {
		this.heroName = heroName;
		this.attckNumber = attckNumber;
		this.blood = blood;
	}

	public void attck(Hero toHero) {
		// 扣除被攻击者的血量
		// this 指的是當前文件
		toHero.setblood(toHero.getblood() - this.getAttckNumber());
		System.out.println(this.getHeroName() + "发起了攻击,并且对"
				+ toHero.getHeroName() + "造成了" + this.getAttckNumber() + "点伤害,"
				+ toHero.getHeroName() + "还剩下" + toHero.getblood() + "血量");
	}
	
	// get set 封装 必须使用快捷键 alt + shift + s
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public int getAttckNumber() {
		return attckNumber;
	}
	public void setAttckNumber(int attckNumber) {
		this.attckNumber = attckNumber;
	}
	public int getblood() {
		return blood;
	}
	public void setblood(int blood) {
		this.blood = blood;
	}


}
