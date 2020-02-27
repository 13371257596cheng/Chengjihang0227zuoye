package com.example.chengjihang0227zuoye.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends IBaseView>{
    private WeakReference<V> mWeakReference;

    public BasePresenter(V v){
        mWeakReference = new WeakReference<>(v);
        initModel();
    }

    public abstract void initModel();

    public V getView(){
        if (mWeakReference!=null){
            return mWeakReference.get();
        }
        return null;
    }

protected void detachView(){
        if (mWeakReference!=null){
            mWeakReference.clear();
            mWeakReference=null;
        }
}


}
