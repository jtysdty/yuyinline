package com.example.server.handler;

import com.example.server.context.RecodeContext;
import com.example.server.speech.FileToSpeech;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/29
 * @其它信息:
 */
public class SpeechHandler extends Handler{
    @Override
    public void doHandler(RecodeContext recodeContext) throws IOException {
        try {
            FileToSpeech fileToSpeech = new FileToSpeech();
            fileToSpeech.playRedio("d:/test/AudioFile/ttsfeedback.wav");
        }finally {
            if (null!=this.nextHandler){
                this.nextHandler.doHandler(recodeContext);
            }
        }
    }
}
