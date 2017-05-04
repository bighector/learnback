package com.hector.learn.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketClient {

	public static void main(String[] args) {
		Socket client = new Socket();
		
		//InetSocketAddress InetSocketAddress = new InetSocketAddress();
		SocketAddress localAddr = new InetSocketAddress("localhost",9000);
		
		try {
			//client.connect(localAddr);
			System.out.println("a client step1");
			System.out.println("a client step2");
			client.connect(localAddr);
			OutputStream output = client.getOutputStream();
//			//PrintStream print = new PrintStream(output);
//			int b = -2;
//			//output.write(b);
//			//print.write("hello");
////			print.print("hello");
//			DataOutputStream dataOutputStream = new DataOutputStream(output);
//			dataOutputStream.writeInt(b);
			char a = 'a';
			
			char b = 'b';
			
			
			output.write(b);
			output.write(a);
			
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
