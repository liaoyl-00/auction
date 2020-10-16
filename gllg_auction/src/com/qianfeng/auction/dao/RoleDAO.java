package com.qianfeng.auction.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;

public class RoleDAO {

	public User findRoleByUser(User user) {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select   id, roleId from user  where  username=?  and  password=?");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			int roleId = 0;
			while (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				roleId = resultSet.getInt(2);
				
			}
			java.sql.PreparedStatement preparedStatement01 = connection
					.prepareStatement("select  id, roleName from  roles  where  id=?");
			preparedStatement01.setInt(1, roleId);
			ResultSet resultSet2 = preparedStatement01.executeQuery();
			Role role = new Role();
			while(resultSet2.next()){
				role.setId(resultSet2.getInt(1));
				role.setRoleName(resultSet2.getString(2));
			}
			user.setRole(role);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<User> findAllUser() {
		  try {
			  java.sql.Connection connection = java.sql.DriverManager
						.getConnection(
								"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
								"student", "521qianfeng");
				java.sql.PreparedStatement preparedStatement = connection
						.prepareStatement("select  id ,  username,password  ,age from   user");
		 ResultSet resultSet=		preparedStatement.executeQuery();
		 List<User>   users=   new ArrayList<User>();
		    while(resultSet.next()){
		    	  User  user =new User();
		    	  user.setId(resultSet.getInt(1));
		    	  user.setUsername(resultSet.getString(2));
		    	  user.setPassword(resultSet.getString(3));
		    	  user.setAge(resultSet.getInt(4));
		    	  users.add(user);
		    }
		      return  users;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Role> findAllRole() {
		try {
			  java.sql.Connection connection = java.sql.DriverManager
						.getConnection(
								"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
								"student", "521qianfeng");
				java.sql.PreparedStatement preparedStatement = connection
						.prepareStatement("select  id, roleName from roles");
		 ResultSet resultSet = preparedStatement.executeQuery();
		 List<Role> roles = new ArrayList<Role>();
		    while(resultSet.next()){
		    	  Role role = new Role();
		    	  role.setId(resultSet.getInt(1));
		    	  role.setRoleName(resultSet.getString(2));
		    	  roles.add(role);
		    }
		 return  roles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addRole(String roleName, String[] resourceIds) {
		try {
			  java.sql.Connection connection = java.sql.DriverManager
						.getConnection(
								"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
								"student", "521qianfeng");
				java.sql.PreparedStatement preparedStatement = connection
						.prepareStatement("insert into roles (roleName) values (?)");
		preparedStatement.setString(1, roleName);
		preparedStatement.execute();
		preparedStatement = connection.prepareStatement("select id from roles where roleName=?");
		String roleId = "";
		preparedStatement.setString(1, roleName);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			roleId = resultSet.getInt(1)+"";
		}
		for (int i=0; i<resourceIds.length; i++) {
			preparedStatement = connection.prepareStatement("insert into roleresouce (resourceId,roleId) values (?,?)");
			preparedStatement.setString(1, resourceIds[i]);
			preparedStatement.setString(2, roleId);
			preparedStatement.execute();
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
