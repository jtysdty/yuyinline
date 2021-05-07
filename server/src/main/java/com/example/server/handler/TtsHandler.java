package com.example.server.handler;

import com.example.server.context.IContext;
import com.example.server.context.RecodeContext;
import com.example.server.tts.AliTextToSpeech;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class TtsHandler extends Handler{
    @Override
    public void doHandler(RecodeContext recodeContext) throws IOException {
        try {
            String appKey = "H44rSxw8EyOL3qo0";
            String id = "LTAI5tMmQyQBi2he4QbeHdo1";
            String secret = "WmV8XDqVE98GC7Hph3X9uhn7geTROO";
            String url = "wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1";
            //默认值：wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1
            AliTextToSpeech demo = new AliTextToSpeech(appKey, id, secret, url);
            demo.process(recodeContext.getNlgResponseText());
            demo.shutdown();
        } finally {
            if (null!=this.nextHandler){
                this.nextHandler.doHandler(recodeContext);
            }
        }
    }
}
