package com.hector.learn.thread.interrupt;

public class Test {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		
		
		thread.interrupt();
		boolean interrupt = thread.interrupted();
		thread.interrupt();
		thread.interrupt();
	}

}
