package com.hector.learn.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9000);
			System.out.println("server start ....");
			while(true){
				Socket s = server.accept();
				System.out.println("a client accept ....");
				System.out.println(s.getRemoteSocketAddress());
				
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
