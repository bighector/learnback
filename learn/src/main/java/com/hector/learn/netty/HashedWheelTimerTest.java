package com.hector.learn.netty;

import java.util.concurrent.TimeUnit;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

public class HashedWheelTimerTest {
	public static void main(String[] args) {
		final Timer timer = new HashedWheelTimer();
		TimerTask task1 = new TimerTask(){

			@Override
			public void run(Timeout arg0) throws Exception {
				System.out.println("task1 execute!");
			}
			
		};
//		timer.newTimeout(new TimerTask(){
//			@Override
//			public void run(Timeout arg0) throws Exception {
//				System.out.println("task1 execute!");
//			}
//		} , 5, TimeUnit.SECONDS);
		timer.newTimeout(task1, 5, TimeUnit.SECONDS);
		timer.newTimeout(task1, 5, TimeUnit.SECONDS);
		
	}
}
