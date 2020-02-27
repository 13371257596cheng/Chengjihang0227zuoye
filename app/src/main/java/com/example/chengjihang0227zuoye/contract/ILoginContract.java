package com.example.chengjihang0227zuoye.contract;

import com.example.chengjihang0227zuoye.base.IBaseView;

import java.util.HashMap;

public interface ILoginContract {
    interface ILoginView extends IBaseView{
        void onLoginSuccess(String str);
        void onLoginFailure(String str);
    }
    interface ILoginPresenter{
        void doLogin(String url, HashMap<String, String> map);
    }
    interface ILoginModel{
        void doLogin(String url, HashMap<String,String> map,ILoginCallBack iLoginCallBack);
        interface  ILoginCallBack{
            void onLoginSuccess(String str);
            void onLoginFailure(String str);
        }
    }

}
