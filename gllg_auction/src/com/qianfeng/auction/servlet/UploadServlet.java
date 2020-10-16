package com.qianfeng.auction.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

 
public class UploadServlet  extends  HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8947562521134502212L;


	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	//http://localhost:8080/??????????uploadServlet
    		throws ServletException, IOException {
     	  String  name=req.getParameter("username");
     	  String  password =req.getParameter("password");
     	  String  heading =req.getParameter("heading");//通过获取输入框name值的方式 只能拿到  文件名
     	  //希望    把图片传递到服务器上，   解决方案 ：  使用二进制流的方式传输过来 
     	  System.out.println(name+"     "+password+"    "+heading);
     	  //123     123    C:\Users\Administrator\Desktop\??????jspé??è?¤?????????é??.jpg
     	  //通过上述演示， 我们发现原来的获取数据的方法，不能完成我们的操作
     	  //  使用 Apache  FileUpload 组件
     	  //---------------------------------------------
      Boolean isMuitiPart=   	   ServletFileUpload.isMultipartContent(req);  //检测是否为post提交方式，  上传格式是否正确
     	 if(!isMuitiPart)   {// isMuitiPart  返回true为正常符合规则
     		    return;
     	 } 
     	 else {
     		 try {
			  //创建FileItemFactory  对象
     	 FileItemFactory  factory=	  new DiskFileItemFactory();
     		 //创建文件上传的处理器
     	  ServletFileUpload upload=      new ServletFileUpload(factory);
     		 //解析请求         表单有多个输入框 ，  text   password   file           输入框解析出来的类型为FileItem
				List<FileItem>   items=    upload.parseRequest(req);
				//遍历每一个  输入框的数据
				for(FileItem  item :items){
					 String    fileName=item.getFieldName();
					 if(item.isFormField()){//true   代表普通的表单控件
						  //判断是否是普通的表单控件
						 String    value =item.getString();  
						 System.out.println(fileName+"     "+value);
					 }
					 else { //代表文件输入框
						 String   filename=item.getFieldName();
						 System.out.println(fileName+"       "+item.getName());// C:\Users\Administrator\Desktop\aaa.png
						 //把文件写入 到指定位置
						 //对文件名处理        UUID.randomUUID() 生成永不重复的随机数    可以给地球上每一粒沙子分配一个随机数
					     String newFileName=UUID.randomUUID().toString()+".png";
						 item.write(new File("D://photo" ,newFileName));
						 //https://mvnrepository.com    民间官方组织     开源思想
						// java.lang.ClassNotFoundException: org.apache.commons.io.output.DeferredFileOutputStream
						 //ClassNotFoundException  分析  该异常意思为  类找不到 
						 // 根据提示的类 的路径，我们发现， 这个类是系统类。， 不是我们自定义类     需要依赖包
						 // 
					}
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
     		 
     		 
		}
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        doGet(req, resp);
    }
}
