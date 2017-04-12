package com.hector.learn.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableAndFuture {

	public static void main(String[] args) {
		List l = new ArrayList();
		
		ExecutorService pools =  Executors.newCachedThreadPool();
		Callable<Integer> callable = new Callable<Integer>() {

			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
			
		};
		
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		
		
		FutureTask<String> t = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return null;
			}
		});
		
		Thread thread = new Thread(t);
		thread.start();
		
		l.add(t);
		try {
			t.get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		
		//future.run();
		
		//new Thread(future).start();
		pools.submit(future);
		 
//		pools.subm
		try {
			Thread.sleep(5000);
			Integer result = future.get();
			//future.get(timeout, unit)
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
