package com.example.chengjihang0227zuoye.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements IBaseView {
        P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mPresenter=initPresenter();

        initView();
        initData();
    }

    public P getPresenter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter=null;
        }
    }

    protected abstract P initPresenter();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();


}
