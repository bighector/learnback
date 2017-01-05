package com.hector.learn.thread.sleep;

public class Test {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		t1.start();
		
		try {
			t1.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main thread end");
	}

}
