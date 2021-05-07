package com.example.server.netty;

import com.example.server.context.RecodeContext;
import com.example.server.factory.AbstractHandlerFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.var;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class ServiceNettyInHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol) throws Exception {

        File file = new File("d:/test/AudioFile/recond3.wav");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel channel = fileOutputStream.getChannel();
        int len = messageProtocol.getLen();
        byte[] content = messageProtocol.getContent();

        ByteBuffer byteBuffer = ByteBuffer.wrap(content);

        try{
            channel.write(byteBuffer);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
        }

        //String type = "all";
        String type = "asr_x_tts";

        RecodeContext recodeContext = new RecodeContext();
        recodeContext.setAsrInputData(content);
        recodeContext.setAsrInputLen(len);
        AbstractHandlerFactory.getFactory(type).doHandler(recodeContext);
    }

}
