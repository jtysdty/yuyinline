package com.example.server.handler;

import com.example.server.asr.SpeechTranscriberWithMicrophoneDemo;
import com.example.server.context.RecodeContext;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class AsrHandler2 extends Handler{
    @Override
    public void doHandler(RecodeContext recodeContext) throws IOException {
        try{

            String appKey = "H44rSxw8EyOL3qo0";
            String token = "60fb9a7b704b462f86050a9aeaead896";

            SpeechTranscriberWithMicrophoneDemo demo = new SpeechTranscriberWithMicrophoneDemo(appKey, token);
            demo.process(recodeContext,this);
            String result = demo.shutdown();
            System.out.println("asr识别结果："+result);
            recodeContext.setAsrResponseText(result);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null!=getNextHandler()){
                getNextHandler().doHandler(recodeContext);
            }
        }
    }
}
