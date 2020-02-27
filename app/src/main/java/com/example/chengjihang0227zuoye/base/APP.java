package com.example.chengjihang0227zuoye.base;

import android.app.Application;
import android.content.Context;

public class APP extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }
    public static Context getAppContext(){
        return mContext;
    }
}
