package com.hector.learn.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketClient {

	public static void main(String[] args) {
		Socket client = new Socket();
		
		//InetSocketAddress InetSocketAddress = new InetSocketAddress();
		SocketAddress localAddr = new InetSocketAddress("localhost",9000);
		
		try {
			client.connect(localAddr);
			System.out.println("a client step1");
			System.out.println("a client step2");
			client.connect(localAddr);
			
			client.isClosed();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
