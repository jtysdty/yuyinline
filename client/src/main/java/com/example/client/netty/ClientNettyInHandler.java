package com.example.client.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import io.netty.buffer.ByteBuf;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class ClientNettyInHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol byteBuffer) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //通道建立后，将record发送过去
        //Thread.sleep(3*1000);

        File file = new File("D:/test/AudioFile/recond.wav");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel channel = inputStream.getChannel();
        //ByteBuf bytebuf = Unpooled.buffer((int)file.length());
        //channel.read(bytebuf.nioBuffer());
        ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
        channel.read(buffer);
        //获取连接通道，传入数据
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(buffer.capacity());
        messageProtocol.setContent(buffer.array());
        Channel channel1 = ctx.channel();
        channel1.writeAndFlush(messageProtocol);

    }
}
