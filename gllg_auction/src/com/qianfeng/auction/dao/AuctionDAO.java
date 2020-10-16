 package com.qianfeng.auction.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.qianfeng.auction.servlet.AuctionList;
import com.qianfeng.entity.Auction;

public class AuctionDAO {

	public java.util.List<Auction> getAll() {
		List<Auction> auctionList = new ArrayList<Auction>();

		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select * from auction");
			java.sql.ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Auction auction = new Auction();
				auction.setId(resultSet.getInt("ID"));
				auction.setAuctionname(resultSet.getString("Auctionname"));
				auction.setAuctionSartTime(resultSet
						.getTimestamp("AuctionSartTime"));
				auction.setAuctionEndTime(resultSet
						.getTimestamp("AuctionEndTime"));
				auction.setAuctionStartPrice(resultSet
						.getInt("AuctionStartPrice"));
				auction.setAuctionUpsitePrice(resultSet
						.getInt("AuctionUpsitePrice"));
				auction.setAuctionDESC(resultSet.getString("AuctionDESC"));
				auction.setAuctionImage(resultSet.getString("AuctionImage"));
				auction.setAuctionSartTime(new Timestamp(System
						.currentTimeMillis()));
				auction.setAuctionUpdateTime(new Timestamp(System
						.currentTimeMillis()));
				auctionList.add(auction);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;

	}

	public java.util.List<Auction> findAuctionListByPage(
			BigDecimal beginPageNumber, BigDecimal pageNumber) {
		List<Auction> auctionList = new ArrayList<Auction>();
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// ��һ��? ��ʾ�ӵڼ��� ��ʼ��
			// �ڶ���? ��ʾ�ڴӵڼ�����ʼ���ǰ���� ������������������
			// ���� 10��15 ��ô���� ��ѯ ��10����25������
			// ���� 15, 5 ��ô���ǲ�ѯ ��15����20������
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select * from auction limit ?,?");
			preparedStatement.setObject(1, beginPageNumber);
			preparedStatement.setObject(2, pageNumber);
			java.sql.ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Auction auction = new Auction();
				auction.setId(resultSet.getInt("ID"));
				auction.setAuctionname(resultSet.getString("Auctionname"));
				auction.setAuctionSartTime(resultSet
						.getTimestamp("AuctionSartTime"));
				auction.setAuctionEndTime(resultSet
						.getTimestamp("AuctionEndTime"));
				auction.setAuctionStartPrice(resultSet
						.getInt("AuctionStartPrice"));
				auction.setAuctionUpsitePrice(resultSet
						.getInt("AuctionUpsitePrice"));
				auction.setAuctionDESC(resultSet.getString("AuctionDESC"));
				auction.setAuctionImage(resultSet.getString("AuctionImage"));
				auction.setAuctionSartTime(new Timestamp(System
						.currentTimeMillis()));
				auction.setAuctionUpdateTime(new Timestamp(System
						.currentTimeMillis()));
				auctionList.add(auction);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auctionList;
	}

	// ��Ҫ��ҳ �ͱ���Ҫ��ȡ���ű�������� ����Ƿ�ҳ��ǰ������
	public BigDecimal getTotalCount() {
		BigDecimal totalCount = new BigDecimal(0);
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// count����ۺϺ��� ������ͳ��������
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select count(*)  from auction");
			java.sql.ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// ��ȡ��һ�������ֶ�
				totalCount = resultSet.getBigDecimal(1);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	public void addAuction(String auctionname, String startprice,
			String upsiteprice, String starttime, String endtime, String desc,String auctionImage) {
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// count����ۺϺ��� ������ͳ��������
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("insert into auction (auctionname,auctionStartPrice,auctionUpsitePrice,auctionSartTime,auctionEndTime,auctionDESC,auctionCreateTime,auctionUpdateTime,auctionImage) values (?,?,?,?,?,?,?,?,?)");
			preparedStatement.setObject(1, auctionname);
			preparedStatement.setObject(2, startprice);
			preparedStatement.setObject(3, upsiteprice);
			preparedStatement.setObject(4, starttime);
			preparedStatement.setObject(5, endtime);
			preparedStatement.setObject(6, desc);
			preparedStatement.setObject(7,
					new Timestamp(System.currentTimeMillis()));
			preparedStatement.setObject(8,
					new Timestamp(System.currentTimeMillis()));
			preparedStatement.setObject(9, auctionImage);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAuctionById(int auctionIdInt) { // ����idȥ���ɾ�����������ʵ�ַ���
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("delete  from  auction where  id=?");
			preparedStatement.setObject(1, auctionIdInt);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * ����id�Ĳ�ѯ����
	 * 
	 * @param autionId
	 *            ��Ӧ����Ʒid
	 */
	public Auction findAuctionById(String autionId) {
		// ����ֵ ���⣬ ��������
		try {
			java.sql.Connection connection = java.sql.DriverManager
					.getConnection(
							"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
							"student", "521qianfeng");
			// select * from auction where id=?" * ָ�����е��� ʵ�ʿ����У�����д�����淶
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("select auctionname,auctionStartPrice,auctionUpsitePrice,auctionSartTime,auctionEndTime"
							+ ",auctionDESC,"
							+ "auctionCreateTime,auctionUpdateTime  from auction  where id=?");
			preparedStatement.setObject(1, autionId);
			ResultSet resultSet = preparedStatement.executeQuery(); // ���صĽ����
			Auction auction = new Auction(); //��ʼ������
			 while(resultSet.next()){  // ʵ��������
				 auction.setAuctionname(resultSet.getString("auctionname"));
				 auction.setAuctionStartPrice(resultSet.getInt("auctionStartPrice"));
				 auction.setAuctionUpsitePrice(resultSet.getInt("auctionUpsitePrice"));
				 auction.setAuctionSartTime(resultSet.getTimestamp("auctionSartTime"));
				 auction.setAuctionEndTime(resultSet.getTimestamp("auctionEndTime"));
				 auction.setAuctionDESC(resultSet.getString("auctionDESC"));
				 auction.setAuctionCreateTime(resultSet.getTimestamp("auctionCreateTime"));
				 auction.setAuctionUpdateTime(resultSet.getTimestamp("auctionUpdateTime"));
				 
			 }
			 //ʵ��������������                                            3:7   ���룺ע��   
			 System.out.println(auction);
			 
			  return  auction;
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return  null;
	}

	public void updateAuctionById(Auction auction) {
		    try {
		    	java.sql.Connection connection = java.sql.DriverManager
						.getConnection(
								"jdbc:mysql://cdb-kthncrwi.bj.tencentcdb.com:10159/gllg",
								"student", "521qianfeng");
		    	java.sql.PreparedStatement preparedStatement= connection
		    			.prepareStatement("update auction  set  auctionname=? , auctionStartPrice=?, auctionUpsitePrice=?, auctionDESC=? where id=?");
		    	preparedStatement.setString(1, auction.getAuctionname());
		    	preparedStatement.setInt(2, auction.getAuctionStartPrice());
		    	preparedStatement.setInt(3, auction.getAuctionUpsitePrice());
		    	preparedStatement.setString(4, auction.getAuctionDESC());
		    	preparedStatement.setInt(5, auction.getId());
		    	preparedStatement.execute();
		    	preparedStatement.close();
		    	connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	// public int method(String string) {
	// // TODO Auto-generated method stub
	// return 0;
	// }

}