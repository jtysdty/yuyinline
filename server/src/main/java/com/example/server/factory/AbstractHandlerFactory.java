package com.example.server.factory;

import com.example.server.context.AbstractContext;
import com.example.server.context.IContext;
import com.example.server.context.RecodeContext;
import com.example.server.handler.*;

import javax.swing.*;
import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public abstract class AbstractHandlerFactory {

     public static AbstractHandlerFactory getFactory(String ServiceType){
          if ("all".equals(ServiceType)){
               return YuYingHandlerFactory.getInstance();
          }else if ("asr_x_tts".equals(ServiceType)){
               return SimpleYuYinHandlerFactory.getInstance();
          }else {
               return YuYingHandlerFactory.getInstance();//默认设置
          }
     }
     public abstract void doHandler(RecodeContext recodeContext) throws IOException;

}
