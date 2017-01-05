package com.hector.learn.thread.sleep;

public class MyRunnable implements Runnable {

	public void run() {
		System.out.println("子线程 step1");
		System.out.println("子线程 step2");
		System.out.println("子线程 step3");
		System.out.println("子线程 step4");
		System.out.println("子线程 step5");
	}

}
