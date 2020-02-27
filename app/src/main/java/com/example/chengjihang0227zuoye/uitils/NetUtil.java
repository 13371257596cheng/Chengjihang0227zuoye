package com.example.chengjihang0227zuoye.uitils;

import android.os.Handler;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public static NetUtil netUtil = new NetUtil();
    private NetUtil() { }
    public static NetUtil getNetUtil() {
        return netUtil;
    }
    //handler
    private Handler handler = new Handler();
    //接口
    public interface CallBack{
        //成功
        void success(String json);
        //失败
        void falied(String msg);
    }

    //加载Json数据
    public void getJson(final String path, final CallBack callBack){
        //开线程
        new Thread(){
            @Override
            public void run() {
                super.run();
                //
                try {
                    URL url = new URL(path);
                    //实例化
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    //
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        //输入流
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        StringBuilder builder = new StringBuilder();
                        //
                        while((len = inputStream.read(bytes))!=-1){
                            builder.append(new String(bytes,0,len));
                        }
                        final String json = builder.toString();
                        inputStream.close();
                        Log.d(TAG, "run: ===="+json);
                        //切换线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (callBack != null) {
                                    callBack.success(json);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void post(String url, HashMap map, final CallBack callBack){
        //TODO:。。。。。。
    }
}
