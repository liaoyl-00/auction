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
		// �۳��������ߵ�Ѫ��
		// this ָ���Ǯ�ǰ�ļ�
		toHero.setblood(toHero.getblood() - this.getAttckNumber());
		System.out.println(this.getHeroName() + "�����˹���,���Ҷ�"
				+ toHero.getHeroName() + "�����" + this.getAttckNumber() + "���˺�,"
				+ toHero.getHeroName() + "��ʣ��" + toHero.getblood() + "Ѫ��");
	}
	
	// get set ��װ ����ʹ�ÿ�ݼ� alt + shift + s
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
