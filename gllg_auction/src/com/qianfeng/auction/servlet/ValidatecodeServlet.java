package com.qianfeng.auction.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//ȫ�Զ����ּ�����������ͼ�����
//��֤��       �ɳ���ͨ������ ʵʱȥ�������ǵĹ������ɵ�
public class ValidatecodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub ��ǩ �����ǵ�ɶ�����ǲ�֪��дɶ���е�����
		// ����ҳ��ȥ����֤��
		// ���������������
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		// ������Ӧ����
		resp.setContentType("image/jpeg");
		// ����ͼƬ�Ŀ�͸�
		int width = 100;
		int height = 30;
		// ���� ������ͼƬ ����
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// ��ȡ���� ʹ��ͼƬ������ ���û��ƶ���
		Graphics graphics = bufferedImage.getGraphics();
		// ���û�����ɫΪ��ɫ�� ���������� ����ɫΪ��ɫ
		graphics.setColor(new Color(255, 255, 0));
		graphics.fillRect(0	, 0, width, height);
        //��������
		graphics.setFont(new Font("΢���ź�", Font.BOLD, 18));
		//���ÿյ��ַ����� ������������ӹ���
		String srand="";
		  Random  rand=   new Random(); //���������
		 for(int  i=0;i<4;i++){
			  String randString=String.valueOf(rand.nextInt(10));
			  srand+=randString;
		 
		//���������ɫ
		 graphics.setColor(new Color(30+rand.nextInt(160) ,50+rand.nextInt(100),80+rand.nextInt(140)));
		 //�����������
		 graphics.drawString(randString, i*25, 15);
		 }
		 // ���ɸ�������
		 for(int i=0;i<10;i++){
			  //��������Ҫ    �������x  y����
			 int  x=rand.nextInt(width);
			 int  y=rand.nextInt(height);
			 int x1=rand.nextInt(10);
			 int  y1=rand.nextInt(10);
			 graphics.drawLine(x, y, x1, y1);
		 }
		 
		 //�����ݴ�ŵ�session������
		HttpSession session= req.getSession();
		session.setAttribute("valCode", srand);
 		//��ͼƬͨ�������������ҳ����
		ImageIO.write(bufferedImage, "jpeg", resp.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
