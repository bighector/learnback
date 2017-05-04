package com.hector.learn.netty.ch01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	
	private final int port;
	
	
	
	public EchoServer(int port) {
		this.port = port;
	}
	
	public void start() throws InterruptedException{
		EventLoopGroup group = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		try {
			b.group(group).channel(NioServerSocketChannel.class).localAddress(port)
					.childHandler(new ChannelInitializer<Channel>() {

						@Override
						protected void initChannel(Channel ch) throws Exception {
							ch.pipeline().addLast(new EchoServerHandler());
						}

					});
			ChannelFuture f = b.bind().sync();
			System.out.println(EchoServer.class.getName() + "started and listen on " + f.channel().localAddress());
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		new EchoServer(9000).start();
	}

}
