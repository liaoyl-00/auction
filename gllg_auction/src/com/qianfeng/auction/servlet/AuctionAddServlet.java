package com.qianfeng.auction.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qianfeng.auction.biz.AuctionBIZ;
import com.qianfeng.auction.enums.AuctionEnum;

public class AuctionAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)// ��ӵĲ���
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		              Map    fields=              new HashMap<String, String>();//  name  ��������value  �ɶԴ��ڹ�����ϵ
		  // ��ȡ��ҳ���ϵ����е����ݣ� ���Ұ��ļ��洢�����ǵķ�������
		Boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			FileItemFactory factory = new DiskFileItemFactory(); // ����ģʽ
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ��������
			List<FileItem> items = upload.parseRequest(req);
			// ����
			for (FileItem item : items) {
				String fileName = item.getFieldName();
				if (item.isFormField()) {
					// ȡ��valueֵ
					fields.put(fileName, item.getString());

				} else {
					// �ϴ��ļ��� �ؼ�
					// ���ļ����浽�������ϵ�uploadĿ¼��
					// �ӱ����̷��ϴ��� һ��ͼƬ
					String oldFileName = item.getName(); // C:\Users\Administrator\Desktop\aaa.png
					// �ϴ��ļ��ĺ�׺��
					String oldFileLast = oldFileName.substring(oldFileName
							.lastIndexOf("."));
					// �����ļ���������ƴ��
					String newFileName = UUID.randomUUID().toString()
							+ oldFileLast;

 				String fileDir = this.getServletContext().getRealPath(
 							"/upload");   //�洢����ʵ·��
					//   ��ͬ ��ƽ̨�¼������һ��
					// File.separator  �Զ����ɼ������
 				//��������·����   һ������·�������洢ͼƬ
 				//���Ŀ¼    ����ҳ���ȡͼƬ
 				String   jueduiFilePath=fileDir+File.separator+newFileName;  //����·��
 				String  xiangduiFilePath="/gllg_auction/upload"+File.separator+newFileName;
				  
 				   //     /gllg_auction/upload\ab90de26-bab8-405f-ae04-fdafecc0bf79.png
					System.out.println(jueduiFilePath+"     "+xiangduiFilePath);
					item.write(new File(jueduiFilePath));//��ɲ���  ��ȡ��ҳ����ļ��� ����д�뵽����    
					//ʵ�ʿ��������У� ͼƬ���ϴ���ר�ŵ�ͼƬ�������ϵ�
					fields.put("auctionImage", xiangduiFilePath);
				 
					
				}
			}
		  //	 System.out.println(fields);//׼����ҳ�������
			String  result=    new AuctionBIZ().addAuction(fields.get("auctionname")+"", fields.get("auctionstartprice")+"",
			    		fields.get("auctionupsiteprice")+"", fields.get("auctionsarttime")+"", 
			    		fields.get("auctionendtime")+"", fields.get("auctiondesc")+"",fields.get("auctionImage")+"");
			
		  if (result.equals(AuctionEnum.AUCTION_ADD_SUCCESS.getValue())) {
			 
			  resp.sendRedirect("AuctionListByPage?msg="+result+"");
			  } else {
			  resp.sendRedirect("auction_add.jsp?msg="+result+"");
		  }
		} catch (Exception e) {

		}

		 
		// AuctionBIZ auctionBIZ = new AuctionBIZ();
		// String result = auctionBIZ.addAuction(auctionname, auctionstartprice,
		// auctionupsiteprice, auctionsarttime, auctionendtime,
		// auctiondesc);
		// if (result.equals(AuctionEnum.AUCTION_ADD_SUCCESS.getValue())) {
		// ��� �޸� ɾ�� ���֮�� ����Ҫ�� �ض��� ��Ҫ��ת�� �� ��Ϊ��ת����ˢ������
		// ת�����ض�������Щ����
		// ת�� �ᱣ���û���HTTP����
		// �ض��� ���ᱣ���û���HTTP����
		// �ڼ�����һ�� �����Լ���ֵļ������� �ܹ�վ��ס�� ������ in action ϵ�д���Ϊ��׼ ���� struts in action
		// ,spring in action, nodejs in action
		// resp.sendRedirect("AuctionListByPage?msg="+result+"");
		// } else {
		// resp.sendRedirect("auction_add.jsp?msg="+result+"");
		// }

	}

}
