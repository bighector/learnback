package com.hector.learn.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Runnable run = new MyRunnable(lock,condition);
		Thread t = new Thread(run);
		t.start();
		System.out.println("main thread implements 1");
		
		lock.lock();
		try{
			System.out.println("main thread implements 2");
			condition.signal();
			System.out.println("main thread implements 3");
			System.out.println("main thread implements 4");
		}finally{
			lock.unlock();
		}
		System.out.println("main thread implements 5");
		
	}
	
	
	private static class MyRunnable implements  Runnable {
		private Lock lock;
		private Condition condition;
		
		public MyRunnable(Lock lock,Condition condition) {
			this.lock = lock;
			this.condition = condition;
		}


		public void run() {
			System.out.println("thread implements 1");
			System.out.println("thread implements 2");
			lock.lock();
			try {
				condition.await();
				System.out.println("thread implements 3");
				System.out.println("thread implements 4");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}
	
}
