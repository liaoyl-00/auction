package com.qianfeng.auction.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.qianfeng.entity.Resource;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;

// �������������� ����inaction ϵ�еĴ���(Ȩ����)
public class UserDAO {
	public User login(String username, String password) {
		// JDBC ��ѯ ������� ��Ϊ6������
		// JDBC������в��ȶ��� ���������е�ʱ�� �ܿ��ܳ�������ʱ���� ����JDBC�Ĵ������Ҫд�� TRY CATH����
		// try cath �Ĵ����ݼ� �� try + enter
		User user = null;
		try {
			// 1:�������ݿ�����
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// 2:ʵ�������ݿ�ʵ�� ����ļ���Ҫ������ִ��SQL���
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select * from user where username = ? and password=?");
			preparedStatement.setObject(1, username);
			preparedStatement.setObject(2, password);
			// 3:ִ�в�ѯ �����������
			java.sql.ResultSet resultSet = preparedStatement.executeQuery();
			// 4:���������
			// resultset.next ������� ָ���� �����һ������ �ͷ���һ��TRUE ���� û�����ݵĻ� �ͷ��� FALSE
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("ID"));
				user.setUsername(resultSet.getString("USERNAME"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setAge(resultSet.getInt("AGE"));
			}
			// 6: �ر�
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