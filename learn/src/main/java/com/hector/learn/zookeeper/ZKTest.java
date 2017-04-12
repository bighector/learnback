package com.hector.learn.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZKTest {

	public static void main(String[] args) {
		Object o = new Object();
		try {
			ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181",12000,new Watcher() {
				
				@Override
				public void process(WatchedEvent event) {
					KeeperState keeperState = event.getState();
					EventType eventType = event.getType();
					System.out.println("keeperState = " +keeperState +",eventType = " +eventType);
					
					System.out.println("step 1");
					System.out.println("step 2");
					System.out.println("step 3");
					System.out.println("step 4");
					System.out.println("step 5");
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			synchronized (o) {
				o.wait();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
