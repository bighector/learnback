package com.hector.learn.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class DefualtWatcher implements Watcher {

	@Override
	public void process(WatchedEvent event) {
		KeeperState keeperState = event.getState();
		EventType  eventType = event.getType();
		
//		keeperState
	}

}
