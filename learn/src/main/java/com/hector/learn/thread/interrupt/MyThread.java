package com.hector.learn.thread.interrupt;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("thread start...");
		//Ã»ÓĞÖĞ¶Ï
		if(!isInterrupted()){
			System.out.println("step1");
			System.out.println(isInterrupted());
			System.out.println("step2");
			System.out.println(isInterrupted());
			System.out.println("step3");
			System.out.println(isInterrupted());
			System.out.println("step4");
			System.out.println(isInterrupted());
			System.out.println("step5");
			System.out.println(isInterrupted());
		}
		
		System.out.println("thread end...");
	}

}
