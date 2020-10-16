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

//全自动区分计算机和人类的图灵测试
//验证码       由程序通过运算 实时去根据我们的规则生成的
public class ValidatecodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub 标签 这边想记点啥，但是不知道写啥，有点忧伤
		// 朝着页面去画验证码
		// 设置浏览器不缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		// 设置响应类型
		resp.setContentType("image/jpeg");
		// 定义图片的宽和高
		int width = 100;
		int height = 30;
		// 创建 缓冲区图片 画板
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 获取画笔 使用图片缓存区 调用绘制对象
		Graphics graphics = bufferedImage.getGraphics();
		// 设置画笔颜色为黄色， 后续画矩阵， 背景色为黄色
		graphics.setColor(new Color(255, 255, 0));
		graphics.fillRect(0	, 0, width, height);
        //设置字体
		graphics.setFont(new Font("微软雅黑", Font.BOLD, 18));
		//设置空的字符串。 用来后面的连接功能
		String srand="";
		  Random  rand=   new Random(); //生成随机数
		 for(int  i=0;i<4;i++){
			  String randString=String.valueOf(rand.nextInt(10));
			  srand+=randString;
		 
		//随机生成颜色
		 graphics.setColor(new Color(30+rand.nextInt(160) ,50+rand.nextInt(100),80+rand.nextInt(140)));
		 //把随机数画入
		 graphics.drawString(randString, i*25, 15);
		 }
		 // 生成干扰线条
		 for(int i=0;i<10;i++){
			  //画线条需要    俩个点的x  y坐标
			 int  x=rand.nextInt(width);
			 int  y=rand.nextInt(height);
			 int x1=rand.nextInt(10);
			 int  y1=rand.nextInt(10);
			 graphics.drawLine(x, y, x1, y1);
		 }
		 
		 //把数据存放到session对象中
		HttpSession session= req.getSession();
		session.setAttribute("valCode", srand);
 		//把图片通过流对象输出到页面上
		ImageIO.write(bufferedImage, "jpeg", resp.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
