package com.hector.learn;

public class Test {

	public static void main(String[] args) {
		test1();
		
		System.out.println("main end");
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
}
