package com.qianfeng.entity;

import java.io.Serializable;

// ʲô�����ļ������ʸ� ���뵽entity�����������?
// ��Ҫ������������  
// (1) ����ORM
// (2) ����JAVABEAN�淶

// ���ǰ����ݿ�ı�����JAVA�ļ����ݾ���ORM˼��
// ʲô��ORM˼�� Ϊ��Ҫ����˼����?
// ORM ��ȫ����  �����ϵ��ӳ�� ���ĺô����� ��JAVA������Ա�ṩOOP˼��ȥ��������  ��������SQL˼��ȥ�������ݿ�
// ��ô��ȥ��װ����ļ��ŷ���ORM���˼����? ֻҪ���� ������������
// (1) ������JAVA����  ��Ҫһ��(Ҳ��һ����Ҫһ�� ���� ������������,��Ϊ��һЩ���ݵ���ƹ淶����Ŀ��_���� ���� ac_user)
// (2) ���е��ֶ���Ҳ��Ҫ��JAVA���е�����������һ��
// (3) �����ֶε����ͺ�JAVA��������ǿ���ת����

// ʲ����javaBean? JavaBEAN����JAVA�������˼
// ��ô�����ļ� �ŷ���JAVA����ı�׼     ��ô����JAVA�������Ҫ�������±�׼
// (1) ���ļ����е����� ������˽�е� (�����ͱ�֤�� ���ļ����е� ���� ���ṩֱ���޸ĵ� ���)
// (2) ���ļ������� �޲ι��캯�� (����ļ�����Ҫ֧�� �޲���ʵ����)
// (3) ����˽������ �����ṩ GET SET���� (��Ҫ�޸�����ļ������� ����Ҫ���� GET SET���� �ſ����޸� )
// (4) ���ļ���Ҫʵ�� ���л��ӿ� (ʵ�������л��ӿ�֮�� ���ļ��Ϳ��Ա� �洢���ڴ�����)
// ��ôҲ����˵ ֻҪ������ ����4�� ���ļ� �Ϳ��Գ�֮Ϊ��һ��JAVABEAN

public class User implements Serializable {
	private int id;
	private String username;
	private String password;
	private int age;
	private Role role;
	// ʵ�����޲ι��캯�� �������� ����Ҫ��д����
	// public User(){
	//
	// }
	// alt+shift+s
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", age=" + age + ", role=" + role + "]";
	}

	

	

	
	
}
