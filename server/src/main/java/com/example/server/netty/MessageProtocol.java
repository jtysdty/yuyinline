package com.example.server.netty;


import lombok.Data;

//协议包
@Data
public class MessageProtocol {
    private int len; //关键
    private byte[] content;
    private String msg;

}
