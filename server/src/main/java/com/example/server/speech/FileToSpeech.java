package com.example.server.speech;

import javafx.scene.media.AudioClip;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import java.io.*;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/29
 * @其它信息:
 */
public class FileToSpeech {
    private AudioStream as;
    public void playRedio(String filePath) throws IOException {
        InputStream in = new FileInputStream(filePath);//"d:/test/AudioFile/ttsfeedback.wav"

        // Create an AudioStream object from the input stream.
        as = new AudioStream(in);
        // clip.
        AudioPlayer.player.start(as);
        //AudioPlayer.player.stop(as);
    }
}
