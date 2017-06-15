package com.hector.learn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		//test1();
//		int i = -1;
//		System.out.println(i%2 ==1?"ÆæÊý":"Å¼Êý");
//		System.out.println("main end");
//		
//		Date d = new Date();
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhh");
//		
//		String ss = formatter.format(d);
//		System.out.println(ss);
//		
//		Calendar ca=Calendar.getInstance();
//		ca.setTime(d);
//		ca.add(Calendar.HOUR_OF_DAY, 1);
//		
//		System.out.println(formatter.format(ca.getTime()));
		
		test3();
		
		
	}
	
	
	synchronized public static void  test1(){
		System.out.println("test1 start!");
		System.out.println("test1 step1!");
		test2(true);
		System.out.println("test1 end!");
	}
	
	public static void test2(boolean flag){
		System.out.println("test2 start1!");
		System.out.println("test2 step1!");
		System.out.println("test2 start2!");
		if(flag){
			return;
		}
		
		System.out.println("test2 start3!");
	}	
	
	public static void test3(){
		//int a = 0xabef0101;
		//int a = 0x0C;
		int a = 0xCAFE;
		
		System.out.println(a);
	}
}
