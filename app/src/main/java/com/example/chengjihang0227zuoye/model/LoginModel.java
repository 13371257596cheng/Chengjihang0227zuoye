package com.example.chengjihang0227zuoye.model;

import com.example.chengjihang0227zuoye.contract.ILoginContract;
import com.example.chengjihang0227zuoye.uitils.VolleyUtils;

import java.util.HashMap;

public class LoginModel implements ILoginContract.ILoginModel {
    @Override
    public void doLogin(String url, HashMap<String, String> map, final ILoginCallBack iLoginCallBack) {
        VolleyUtils.getInstance().doPost(url, map, new VolleyUtils.CallBack() {
            @Override
            public void success(String json) {
                iLoginCallBack.onLoginSuccess(json);
            }

            @Override
            public void falied(String msg) {
                iLoginCallBack.onLoginFailure(msg);
            }
        });

    }
}
