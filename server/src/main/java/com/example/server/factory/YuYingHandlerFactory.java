package com.example.server.factory;

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
public class YuYingHandlerFactory extends AbstractHandlerFactory {

    private Handler invoker;

    private static volatile YuYingHandlerFactory instance;
    private YuYingHandlerFactory(){
        AsrHandler asrHandler = new AsrHandler();
        NluHandler nluHandler = new NluHandler();
        DmHandler dmHandler = new DmHandler();
        NlgHandler nlgHandler = new NlgHandler();
        TtsHandler ttsHandler = new TtsHandler();
        nlgHandler.setNextHandler(ttsHandler);
        dmHandler.setNextHandler(nlgHandler);
        nluHandler.setNextHandler(dmHandler);
        asrHandler.setNextHandler(nluHandler);
        invoker = asrHandler;
    };
    //当使用时才创建
    public static YuYingHandlerFactory  getInstance(){
        if (instance == null){
            synchronized(YuYingHandlerFactory.class){
                if (instance == null){
                    instance = new YuYingHandlerFactory();
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
