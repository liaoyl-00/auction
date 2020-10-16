package com.qianfeng.auction.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qianfeng.entity.Resource;



public class ResourceDAO {

	public void saveResource(String resourceName, String resourcePath) {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("insert into resource (resourceName,resourcePath) values (?,?)");
			preparedStatement.setString(1, resourceName);
			preparedStatement.setString(2, resourcePath);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Resource> findAllResource() {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select id,resourceName,resourcePath from resource");
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Resource> resources = new ArrayList<Resource>();
			while(resultSet.next()) {
				Resource resource = new Resource();
				resource.setId(resultSet.getInt(1));
				resource.setResourceName(resultSet.getString(2));
				resource.setResourcePath(resultSet.getString(3));
				resources.add(resource);
			}
			return resources;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
