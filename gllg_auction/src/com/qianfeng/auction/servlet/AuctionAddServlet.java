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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)// 添加的操作
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		              Map    fields=              new HashMap<String, String>();//  name  与输入框的value  成对存在关联关系
		  // 获取到页面上的所有的数据， 并且把文件存储到我们的服务器上
		Boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			FileItemFactory factory = new DiskFileItemFactory(); // 工厂模式
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求
			List<FileItem> items = upload.parseRequest(req);
			// 迭代
			for (FileItem item : items) {
				String fileName = item.getFieldName();
				if (item.isFormField()) {
					// 取到value值
					fields.put(fileName, item.getString());

				} else {
					// 上传文件的 控件
					// 把文件保存到服务器上的upload目录下
					// 从本地盘符上传了 一张图片
					String oldFileName = item.getName(); // C:\Users\Administrator\Desktop\aaa.png
					// 上传文件的后缀名
					String oldFileLast = oldFileName.substring(oldFileName
							.lastIndexOf("."));
					// 生成文件名，进行拼接
					String newFileName = UUID.randomUUID().toString()
							+ oldFileLast;

 				String fileDir = this.getServletContext().getRealPath(
 							"/upload");   //存储的真实路径
					//   不同 的平台下间隔符不一样
					// File.separator  自动生成间隔符号
 				//声明俩个路径，   一个绝对路径用来存储图片
 				//相对目录    用来页面读取图片
 				String   jueduiFilePath=fileDir+File.separator+newFileName;  //绝对路径
 				String  xiangduiFilePath="/gllg_auction/upload"+File.separator+newFileName;
				  
 				   //     /gllg_auction/upload\ab90de26-bab8-405f-ae04-fdafecc0bf79.png
					System.out.println(jueduiFilePath+"     "+xiangduiFilePath);
					item.write(new File(jueduiFilePath));//完成操作  获取到页面的文件， 并且写入到本地    
					//实际开发过程中， 图片是上传到专门的图片服务器上的
					fields.put("auctionImage", xiangduiFilePath);
				 
					
				}
			}
		  //	 System.out.println(fields);//准备好页面的数据
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
		// 添加 修改 删除 完成之后 必须要用 重定向 不要用转发 ， 因为用转发有刷新隐患
		// 转发和重定向有哪些区别？
		// 转发 会保留用户的HTTP请求
		// 重定向 不会保留用户的HTTP请求
		// 在技术这一块 你想自己坚持的技术理论 能够站得住脚 可以以 in action 系列丛书为标准 举例 struts in action
		// ,spring in action, nodejs in action
		// resp.sendRedirect("AuctionListByPage?msg="+result+"");
		// } else {
		// resp.sendRedirect("auction_add.jsp?msg="+result+"");
		// }

	}

}
