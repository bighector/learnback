package com.hector.learn.netty.ch01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf byteBuf = (ByteBuf) msg;
		byte[] req = new byte[byteBuf.readableBytes()];
		for(byte r:req){
			System.out.println("req byte = " +r);
		}
		
		System.out.println("req = "+req);
		byteBuf.readBytes(req);
		String body = new String(req,"UTF-8");
		
		System.out.println("receive body : " + body);
		System.out.println("server received: " + msg.toString());
		//ctx.write(msg);
		//ctx.writeAndFlush(msg);
		ctx.flush();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}
