package com.example.server.nludmnlg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @描述:
 * @创建人: 曹操
 * @创建时间: 2021/4/29
 * @其它信息:
 */
public class TuLing {
    public static String getFeedBack(String input) throws IOException{

        String APIKEY = "自己的apikey";

        String question = input;//这是上传给云机器人的问题
        //String INFO = URLEncoder.encode("北京今日天气", "utf-8");
        String INFO = URLEncoder.encode(question, "utf-8");
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        System.out.println("图灵机器人返回：======="+sb);
        JSONObject o = JSON.parseObject(sb.toString());
        return o.getString("text");
    }

}
