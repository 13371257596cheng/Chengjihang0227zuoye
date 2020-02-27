package com.example.chengjihang0227zuoye.contract;

import com.example.chengjihang0227zuoye.base.IBaseView;

public interface IHomePageContract {
    interface IView extends IBaseView{
        void onGetBannerSuccess(String str);
        void onGetBannerFailure(String str);

        void onGetListSuccess(String str);
        void onGetListFailure(String str);
    }
    interface IPresenter{
        void getBanner(String url);

        void getList(String url);
    }

    interface IModel{
        void getBanner(String url, IModelCallback callback);

        void getList(String url, IModelGetListCallback callback);

        interface IModelCallback{
            void onGetBannerSuccess(String str);

            void onGetBannerFailure(String str);
        }
        interface IModelGetListCallback{
            void onGetListSuccess(String str);
            void onGetListFailure(String str);
        }


    }



}
