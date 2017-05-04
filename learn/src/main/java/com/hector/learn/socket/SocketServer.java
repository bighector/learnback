package com.hector.learn.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
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
				
				InputStream input = s.getInputStream();
////				byte[] bytes = new byte[10];
////				input.read(bytes);
////				for(byte b: bytes){
////					System.out.print(b);
////				}
////				int b ;
////				while(( b= input.read()) != -1){
////					System.out.println("b = " + b);
////				}
//				
//				DataInputStream dataInputStream = new DataInputStream(input);
//				int b ; 
//				if((b = dataInputStream.readInt()) != -1){
//					System.out.println("b = " + b);
//				}
////				dataInputStream.read(b)
////				int b = dataInputStream.readInt();
//				//System.out.println("b = " + b);
				
				byte[] bs = new byte[2];
				input.read(bs);
				System.out.println("bs = " + bs);
				for(byte b: bs){
					System.out.println("b = " + b);
				}
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
