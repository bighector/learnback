package com.hector.learn.thread.sleep;

public class Test {

	public static void main(String[] args) {
//		MyRunnable myRunnable = new MyRunnable();
//		Thread t1 = new Thread(myRunnable);
//		t1.start();
//		
////		t1.
////		t1.interrupt();
////		Thread.interrupted();
//		
//		try {
//			t1.sleep(10000);
//			//Thread.sleep(millis);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("main thread end");
		
		Test t = new Test();
		t.print("hello");
		Test.print("static");
		
	}
	
	//²âÊÔstatic ÊµÀıµ÷ÓÃ
	public static void print(String name){
		System.out.println("test static call instance args =" +name);
	}
}
