package com.example.server.handler;

import com.example.server.context.AbstractContext;
import com.example.server.context.IContext;
import com.example.server.context.RecodeContext;
import lombok.Data;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
@Data
public abstract class Handler {
    Handler nextHandler;
    public abstract void doHandler(RecodeContext recodeContext) throws IOException;
}
