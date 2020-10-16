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
     	  String  heading =req.getParameter("heading");//ͨ����ȡ�����nameֵ�ķ�ʽ ֻ���õ�  �ļ���
     	  //ϣ��    ��ͼƬ���ݵ��������ϣ�   ������� ��  ʹ�ö��������ķ�ʽ������� 
     	  System.out.println(name+"     "+password+"    "+heading);
     	  //123     123    C:\Users\Administrator\Desktop\??????jsp��??��?��?????????��??.jpg
     	  //ͨ��������ʾ�� ���Ƿ���ԭ���Ļ�ȡ���ݵķ���������������ǵĲ���
     	  //  ʹ�� Apache  FileUpload ���
     	  //---------------------------------------------
      Boolean isMuitiPart=   	   ServletFileUpload.isMultipartContent(req);  //����Ƿ�Ϊpost�ύ��ʽ��  �ϴ���ʽ�Ƿ���ȷ
     	 if(!isMuitiPart)   {// isMuitiPart  ����trueΪ�������Ϲ���
     		    return;
     	 } 
     	 else {
     		 try {
			  //����FileItemFactory  ����
     	 FileItemFactory  factory=	  new DiskFileItemFactory();
     		 //�����ļ��ϴ��Ĵ�����
     	  ServletFileUpload upload=      new ServletFileUpload(factory);
     		 //��������         ���ж������� ��  text   password   file           ������������������ΪFileItem
				List<FileItem>   items=    upload.parseRequest(req);
				//����ÿһ��  ����������
				for(FileItem  item :items){
					 String    fileName=item.getFieldName();
					 if(item.isFormField()){//true   ������ͨ�ı��ؼ�
						  //�ж��Ƿ�����ͨ�ı��ؼ�
						 String    value =item.getString();  
						 System.out.println(fileName+"     "+value);
					 }
					 else { //�����ļ������
						 String   filename=item.getFieldName();
						 System.out.println(fileName+"       "+item.getName());// C:\Users\Administrator\Desktop\aaa.png
						 //���ļ�д�� ��ָ��λ��
						 //���ļ�������        UUID.randomUUID() ���������ظ��������    ���Ը�������ÿһ��ɳ�ӷ���һ�������
					     String newFileName=UUID.randomUUID().toString()+".png";
						 item.write(new File("D://photo" ,newFileName));
						 //https://mvnrepository.com    ���ٷ���֯     ��Դ˼��
						// java.lang.ClassNotFoundException: org.apache.commons.io.output.DeferredFileOutputStream
						 //ClassNotFoundException  ����  ���쳣��˼Ϊ  ���Ҳ��� 
						 // ������ʾ���� ��·�������Ƿ��֣� �������ϵͳ�ࡣ�� ���������Զ�����     ��Ҫ������
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
