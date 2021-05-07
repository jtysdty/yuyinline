package com.example.client;

import com.example.client.netty.NettyClient;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class ClientMain {

    public static void main(String[] args) {
        //1.调用服务完成录音;录音结束时，调用netty传输数据
        RecondClass rc = RecondClass.getInstance();
    }


}
