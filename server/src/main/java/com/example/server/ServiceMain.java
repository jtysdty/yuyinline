package com.example.server;

import com.example.server.netty.NettyServer;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class ServiceMain {
    public static void main(String[] args) {
        NettyServer server = new NettyServer();
        server.run();
    }
}
