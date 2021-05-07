package com.example.server;

import com.example.server.asr.SpeechTranscriberWithMicrophoneDemo;
import com.example.server.context.RecodeContext;
import com.example.server.factory.AbstractHandlerFactory;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/5/7
 * @其它信息:
 */
public class ServiceMain2 {
    public static void main(String[] args) throws IOException {
        RecodeContext recodeContext = new RecodeContext();
        //String type = "all";
        String type = "asr_x_tts";
        AbstractHandlerFactory.getFactory(type).doHandler(recodeContext);

    }
}
