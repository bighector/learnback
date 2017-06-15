package com.hector.learn.netty;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class Server {

	public static void main(String[] args) {
		Channel channel = null;
		NioEventLoopGroup bossGroup  = new NioEventLoopGroup(); 
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
		
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>(){

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
//				ch.pipeline().addLast(new StringDecoder());
//				ch.pipeline().addLast(new StringEncoder());
				ch.pipeline().addLast("HttpServerCodec",new HttpServerCodec());
//				ch.pipeline().addLast(new HttpRequestDecoder());
//				
				ch.pipeline().addLast(new HttpObjectAggregator(1024*1024));
				//ch.pipeline().addLast(new HttpResponseEncoder());
				
				ch.pipeline().addLast(new MyChannelInBoundHandlerAdapter());
			}
			
		})
		.option(ChannelOption.SO_BACKLOG, 128)
		.childOption(ChannelOption.SO_KEEPALIVE, true);
		
		try {
			ChannelFuture f = b.bind(8000).sync();
			channel = f.channel();
			channel.closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
