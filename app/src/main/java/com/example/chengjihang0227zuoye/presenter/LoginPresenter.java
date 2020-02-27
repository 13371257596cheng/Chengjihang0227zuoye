package com.example.chengjihang0227zuoye.presenter;

import com.example.chengjihang0227zuoye.base.BasePresenter;
import com.example.chengjihang0227zuoye.base.IBaseView;
import com.example.chengjihang0227zuoye.contract.ILoginContract;
import com.example.chengjihang0227zuoye.model.LoginModel;

import java.util.HashMap;

public class LoginPresenter extends BasePresenter implements ILoginContract.ILoginPresenter {
   private ILoginContract.ILoginModel mModel;

    public LoginPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }


    @Override
    public void doLogin(String url, HashMap<String, String> map) {
        mModel.doLogin(url, map, new ILoginContract.ILoginModel.ILoginCallBack() {
            @Override
            public void onLoginSuccess(String str) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof ILoginContract.ILoginView){
                    ILoginContract.ILoginView iView = ( ILoginContract.ILoginView)iBaseView;
                    iView.onLoginSuccess(str);
                }
            }

            @Override
            public void onLoginFailure(String str) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof ILoginContract.ILoginView){
                    ILoginContract.ILoginView iView = ( ILoginContract.ILoginView)iBaseView;
                    iView.onLoginFailure(str);
                }
            }
        });
    }


    @Override
    public void initModel() {
        mModel=new LoginModel();
    }


}
