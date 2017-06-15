package com.hector.learn.netty;

import java.util.ArrayList;
import java.util.List;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

	public static void main(String[] args) {
		MyChannelInBoundHandlerAdapter myChannel = new MyChannelInBoundHandlerAdapter();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(workerGroup);
		b.channel(NioSocketChannel.class);
		b.handler(new ChannelInitializer<SocketChannel>(){

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(myChannel);
			}
			 
		 });
		 List<Channel> l = new ArrayList();
		 try {
			for(int i=0;i<5;i++){
				ChannelFuture f = b.connect("192.168.1.32", 8000).sync();
				Channel ch = f.channel();
				System.out.println(ch);
				l.add(ch);
				//f.channel().closeFuture().sync();
			}
			//ChannelFuture f = b.connect("192.168.1.32", 8000).sync();
			
			for(Channel c:l){
				new ExeWaitThread(c).start();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
	}

	static class ExeWaitThread extends Thread {
		private Channel ch;

		public ExeWaitThread(Channel ch) {
			this.ch = ch;
		}

		@Override
		public void run() {
			try {
				ch.closeFuture().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
