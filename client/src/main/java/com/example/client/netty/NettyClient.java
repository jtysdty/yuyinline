package com.example.client.netty;

import com.example.client.RecondClass;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class NettyClient {
    private static volatile NettyClient instance;
    //当使用时才创建
    public static NettyClient  getInstance(){
        if (instance == null){
            synchronized(NettyClient.class){
                if (instance == null){
                    instance = new NettyClient();
                }
            }
        }
        return instance;
    }

        public static void  run(){
            NioEventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(group)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                ChannelPipeline pipeline = socketChannel.pipeline();
                                pipeline.addLast(new ClientNettyEncoder());
                                pipeline.addLast(new ClientNettyInHandler());
                            }
                        });
                ChannelFuture channelFuture = bootstrap.connect("127.0.0.1",7000).sync();
                ChannelFuture future = channelFuture.channel().closeFuture().sync();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                group.shutdownGracefully();
            }
        }
}
