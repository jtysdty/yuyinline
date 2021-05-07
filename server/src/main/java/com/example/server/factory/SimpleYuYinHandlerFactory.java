package com.example.server.factory;

import com.example.server.context.AbstractContext;
import com.example.server.context.IContext;
import com.example.server.context.RecodeContext;
import com.example.server.handler.*;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class SimpleYuYinHandlerFactory extends AbstractHandlerFactory{
    private Handler invoker;

    private static volatile SimpleYuYinHandlerFactory instance;
    private SimpleYuYinHandlerFactory(){
        AsrHandler asrHandler = new AsrHandler();
        NluDmNlgHandler nluDmNlgHandler = new NluDmNlgHandler();
        TtsHandler ttsHandler = new TtsHandler();
        SpeechHandler speechHandler = new SpeechHandler();
        ttsHandler.setNextHandler(speechHandler);
        nluDmNlgHandler.setNextHandler(ttsHandler);
        asrHandler.setNextHandler(nluDmNlgHandler);
        invoker = asrHandler;
    };
    //当使用时才创建
    public static SimpleYuYinHandlerFactory  getInstance(){
        if (instance == null){
            synchronized(SimpleYuYinHandlerFactory.class){
                if (instance == null){
                    instance = new SimpleYuYinHandlerFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public void doHandler(RecodeContext recodeContext) throws IOException {
        invoker.doHandler(recodeContext);
    }
}
