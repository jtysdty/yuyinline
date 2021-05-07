package com.example.server.handler;

import com.example.server.asr.AsrOneSentence;
import com.example.server.asr.AsrUtils;
import com.example.server.asr.SpeechTranscriberWithMicrophoneDemo;
import com.example.server.context.RecodeContext;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class AsrHandler extends Handler{
    @Override
    public void doHandler(RecodeContext recodeContext) throws IOException {
        try{
            String appKey = "H44rSxw8EyOL3qo0";
            String id = "LTAI5tMmQyQBi2he4QbeHdo1";
            String secret = "WmV8XDqVE98GC7Hph3X9uhn7geTROO";
            String url = "wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1";
            // 默认值：wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1。
            //String filepath = "D:/test/AudioFile/sample.wav";
            String filepath = "D:/test/AudioFile/recond3.wav";
            AsrUtils demo = new AsrUtils(appKey, id, secret, url);
            demo.process(filepath);
            String process = demo.shutdown();
            System.out.println("asr识别结果："+process);
            recodeContext.setAsrResponseText(process);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null!=getNextHandler()){
                getNextHandler().doHandler(recodeContext);
            }
        }
    }
}
