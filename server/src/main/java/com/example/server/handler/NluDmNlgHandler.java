package com.example.server.handler;

import com.example.server.context.IContext;
import com.example.server.context.RecodeContext;
import com.example.server.nludmnlg.TuLing;

import java.io.IOException;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/28
 * @其它信息:
 */
public class NluDmNlgHandler extends Handler{
    @Override
    public void doHandler(RecodeContext recodeContext) throws IOException {
        try{
            String feedBack = TuLing.getFeedBack(recodeContext.getAsrResponseText());
            recodeContext.setNlgResponseText(feedBack);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (null!=this.nextHandler){
                this.nextHandler.doHandler(recodeContext);
            }
        }

    }
}
