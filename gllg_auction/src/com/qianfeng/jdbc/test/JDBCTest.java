package com.qianfeng.jdbc.test;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void test() {
		// JDBC 查询 大体层面 分为6个步骤
		// JDBC本身具有不稳定性 所以在运行的时候 很可能出现运行时错误 所以JDBC的代码必须要写在 TRY CATH当中
		// try cath 的代码快捷键 是 try + enter
		try {
			// 1:创建数据库链接
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// 2:实例化数据库实例 这个文件主要是用例执行SQL语句
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select * from user");
			// 3:执行查询 實例化结果集
			java.sql.ResultSet resultSet = preparedStatement.executeQuery();
			// 4:迭代结果集
			// resultset.next 这个函数 指的是 如果有一行数据 就返回一个TRUE 否则 没有数据的话 就返回 FALSE
			while (resultSet.next()) {
				// 5: 处理结果集
					System.out.println(resultSet.getString("USERNAME"));
					System.out.println(resultSet.getString("PASSWORD"));
					System.out.println(resultSet.getString("AGE"));
			}
			// 6: 关闭
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// jdbc添加
	@Test
	public void test02() {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"root", "3cwangzi");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user (username,password) values (?,?)");
			preparedStatement.setString(1, "木木不哭");
			preparedStatement.setString(2, "123456");
			// 如果是增删改 都是执行 executeUpdate 查询时执行 executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 修改
	@Test
	public void test03() {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"root", "3cwangzi");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("update user set age = ? where username = ?");
			preparedStatement.setObject(1, 29);
			preparedStatement.setObject(2, "陈思维");
			// 如果是增删改 都是执行 executeUpdate 查询时执行 executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	// 删除
	public void test04() {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"root", "3cwangzi");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("delete from user where username=?");
			preparedStatement.setObject(1, "陈思维");
			// 如果是增删改 都是执行 executeUpdate 查询时执行 executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public   void  test01(){
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"root", "3cwangzi");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("delete from user where username=?");
			preparedStatement.setObject(1, "陈思维");
			// 如果是增删改 都是执行 executeUpdate 查询时执行 executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	

}
