package com.qianfeng.entity;

import java.io.Serializable;

// 什么样的文件才有资格 放入到entity这个包下面呢?
// 它要满足两个条件  
// (1) 符合ORM
// (2) 符合JAVABEAN规范

// 我们把数据库的表抽象成JAVA文件依据就是ORM思想
// 什么是ORM思想 为何要依据思想呢?
// ORM 的全称是  对象关系型映射 它的好处就是 给JAVA开发人员提供OOP思想去操作数据  而不是用SQL思想去操作数据库
// 怎么样去封装这个文件才符合ORM这个思想呢? 只要符合 三个条件即可
// (1) 表名和JAVA类名  需要一致(也不一定非要一致 但是 基本上是这样,因为有一些数据的设计规范是项目名_表名 比如 ac_user)
// (2) 表中的字段名也需要和JAVA类中的属性名保持一致
// (3) 表中字段的类型和JAVA类的类型是可以转化的

// 什麽是javaBean? JavaBEAN就是JAVA组件的意思
// 怎么样的文件 才符合JAVA组件的标准     那么符合JAVA组件就需要满足以下标准
// (1) 该文件所有的属性 必须是私有的 (这样就保证了 该文件所有的 属性 不提供直接修改的 入口)
// (2) 该文件必须有 无参构造函数 (这个文件必须要支持 无参数实例化)
// (3) 所有私有属性 必须提供 GET SET函数 (想要修改这个文件的属性 必须要调用 GET SET函数 才可以修改 )
// (4) 该文件需要实现 序列化接口 (实现了序列化接口之后 该文件就可以被 存储到内存中了)
// 那么也就是说 只要满足了 以上4点 该文件 就可以称之为是一个JAVABEAN

public class User implements Serializable {
	private int id;
	private String username;
	private String password;
	private int age;
	private Role role;
	// 实际上无参构造函数 本来就有 不需要手写出来
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
