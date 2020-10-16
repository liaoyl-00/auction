package com.qianfeng.jdbc.test;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void test() {
		// JDBC ��ѯ ������� ��Ϊ6������
		// JDBC������в��ȶ��� ���������е�ʱ�� �ܿ��ܳ�������ʱ���� ����JDBC�Ĵ������Ҫд�� TRY CATH����
		// try cath �Ĵ����ݼ� �� try + enter
		try {
			// 1:�������ݿ�����
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// 2:ʵ�������ݿ�ʵ�� ����ļ���Ҫ������ִ��SQL���
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select * from user");
			// 3:ִ�в�ѯ �����������
			java.sql.ResultSet resultSet = preparedStatement.executeQuery();
			// 4:���������
			// resultset.next ������� ָ���� �����һ������ �ͷ���һ��TRUE ���� û�����ݵĻ� �ͷ��� FALSE
			while (resultSet.next()) {
				// 5: ��������
					System.out.println(resultSet.getString("USERNAME"));
					System.out.println(resultSet.getString("PASSWORD"));
					System.out.println(resultSet.getString("AGE"));
			}
			// 6: �ر�
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// jdbc���
	@Test
	public void test02() {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"root", "3cwangzi");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user (username,password) values (?,?)");
			preparedStatement.setString(1, "ľľ����");
			preparedStatement.setString(2, "123456");
			// �������ɾ�� ����ִ�� executeUpdate ��ѯʱִ�� executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("���ʧ��");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �޸�
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
			preparedStatement.setObject(2, "��˼ά");
			// �������ɾ�� ����ִ�� executeUpdate ��ѯʱִ�� executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	// ɾ��
	public void test04() {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"root", "3cwangzi");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("delete from user where username=?");
			preparedStatement.setObject(1, "��˼ά");
			// �������ɾ�� ����ִ�� executeUpdate ��ѯʱִ�� executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ��");
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
			preparedStatement.setObject(1, "��˼ά");
			// �������ɾ�� ����ִ�� executeUpdate ��ѯʱִ�� executeQuery
			int executeCount = preparedStatement.executeUpdate();
			if (executeCount > 0) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ��");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	

}
