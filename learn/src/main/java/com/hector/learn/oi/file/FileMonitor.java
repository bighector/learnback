package com.hector.learn.oi.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileMonitor {

	public static void main(String[] args) {
		 try {
			WatchService watchService=FileSystems.getDefault().newWatchService();
			
			Paths.get("d:/file").register(watchService,   
	                StandardWatchEventKinds.ENTRY_CREATE,  
	                StandardWatchEventKinds.ENTRY_DELETE,  
	                StandardWatchEventKinds.ENTRY_MODIFY); 
			while(true){
				try {
					WatchKey key=watchService.take();
					for(WatchEvent<?> event:key.pollEvents()) {
						System.out.println(event.context()+"发生了"+event.kind()+"事件");
						System.out.println(event.context()+"发生了"+event.kind()+"事件");
					}
					
					if(!key.reset()){
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
