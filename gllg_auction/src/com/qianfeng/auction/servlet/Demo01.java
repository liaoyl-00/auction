package com.qianfeng.auction.servlet;

import java.util.HashMap;
import java.util.Random;

public class Demo01 {
   public static void main(String[] args) {
//	       for(int   i=0 ;i<100;i++){
//	    	 int x=    new Random().nextInt(10);  //  生成0-（n-1）的整数随机数
//	    	 System.out.println(x);
//	    	 
//	       }
	   
	    HashMap    map=    new HashMap<String, String>() ;
	      map.put("111", "aaaa");
	      map.put("222", "bbb");
	      System.out.println(map.get("111"));
}
}
