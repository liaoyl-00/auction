package com.qianfeng.auction.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.qianfeng.entity.Resource;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;

// 如果你真的想买书 就买inaction 系列的丛书(权威性)
public class UserDAO {
	public User login(String username, String password) {
		// JDBC 查询 大体层面 分为6个步骤
		// JDBC本身具有不稳定性 所以在运行的时候 很可能出现运行时错误 所以JDBC的代码必须要写在 TRY CATH当中
		// try cath 的代码快捷键 是 try + enter
		User user = null;
		try {
			// 1:创建数据库链接
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// 2:实例化数据库实例 这个文件主要是用例执行SQL语句
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select * from user where username = ? and password=?");
			preparedStatement.setObject(1, username);
			preparedStatement.setObject(2, password);
			// 3:执行查询 實例化结果集
			java.sql.ResultSet resultSet = preparedStatement.executeQuery();
			// 4:迭代结果集
			// resultset.next 这个函数 指的是 如果有一行数据 就返回一个TRUE 否则 没有数据的话 就返回 FALSE
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("ID"));
				user.setUsername(resultSet.getString("USERNAME"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setAge(resultSet.getInt("AGE"));
			}
			// 6: 关闭
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void delUserById(String userId) {
	        try {
	        	java.sql.Connection connection = java.sql.DriverManager
						.getConnection(
								"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
								"student", "521qianfeng");
	       PreparedStatement  preparedStatement=	connection.prepareStatement("delete from  user  where  id=?");
	       preparedStatement.setString(1, userId);
	       preparedStatement.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		//Cannot delete or update a parent row: a foreign key constraint fails (`gllg`.`roles`, CONSTRAINT `role_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`))
	}
	
	public User findUserById(String userId) {
        try {
        	java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
       PreparedStatement  preparedStatement = connection.prepareStatement("select  username, password ,age from   user where id=?");
       preparedStatement.setString(1, userId);
       ResultSet resultSet = preparedStatement.executeQuery();
       User user = new User();
       while (resultSet.next()) {
    	   user.setUsername(resultSet.getString(1));
    	   user.setPassword(resultSet.getString(2));
    	   user.setAge(resultSet.getInt(3));
    	   user.setId(Integer.valueOf(userId));
		}
       return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	//Cannot delete or update a parent row: a foreign key constraint fails (`gllg`.`roles`, CONSTRAINT `role_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`))
}

	public void updateUserById(User user) {
		try {
        	java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
       PreparedStatement  preparedStatement = connection.prepareStatement("update user set username=?, password=?, age=? where id=?");
       preparedStatement.setString(1, user.getUsername());
       preparedStatement.setString(2, user.getPassword());
       preparedStatement.setInt(3, user.getAge());
       preparedStatement.setInt(4, user.getId());
       preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addUser(String roleId, String username, String password,
			String age) {
		try {
        	java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
       PreparedStatement  preparedStatement = connection.prepareStatement("insert into user (roleId,username,password,age) values(?,?,?,?)");
       preparedStatement.setString(1, roleId);
       preparedStatement.setString(2, username);
       preparedStatement.setString(3, password);
       preparedStatement.setString(4, age);
       preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public User findAllUserInfo(User user) {
		try {
        	java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
       PreparedStatement  preparedStatement = connection.prepareStatement("select roleId from user where username=? and password=?");
       preparedStatement.setString(1, user.getUsername());
       preparedStatement.setString(2, user.getPassword());
       ResultSet resultSet = preparedStatement.executeQuery();
       String roleid = "";
       while (resultSet.next()) {
    	   roleid = resultSet.getString(1);
       }
       
       ArrayList<String> resourceIds = new ArrayList<String>();
       preparedStatement = connection.prepareStatement("select resourceId from roleresouce where roleid=?");
       preparedStatement.setString(1, roleid);
       resultSet = preparedStatement.executeQuery();
       while (resultSet.next()) {
    	   resourceIds.add(resultSet.getString(1));
       }
       
       ArrayList<Resource> resources = new ArrayList<Resource>();
       for(int i=0; i<resourceIds.size(); i++) {
    	   preparedStatement = connection.prepareStatement("select resourceName,resourcePath from resource where id=?");
    	   preparedStatement.setString(1, resourceIds.get(i));
    	   resultSet = preparedStatement.executeQuery();
    	   while (resultSet.next()) {
    		   Resource resource = new Resource();
        	   resource.setId(Integer.valueOf(resourceIds.get(i)));
        	   resource.setResourceName(resultSet.getString(1));
        	   resource.setResourcePath(resultSet.getString(2));
        	   resources.add(resource);
           }
       }
       
       Role role = new Role();
       role.setResource(resources);
       role.setId(Integer.valueOf(roleid));
       user.setRole(role);
       return user;
       
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}