package com.example.chengjihang0227zuoye.model;

import com.example.chengjihang0227zuoye.contract.IHomePageContract;
import com.example.chengjihang0227zuoye.uitils.NetUtil;
import com.example.chengjihang0227zuoye.uitils.VolleyUtils;

public class HomePageModel implements IHomePageContract.IModel {
    @Override
    public void getBanner(String url, final IModelCallback callback) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.CallBack() {
            @Override
            public void success(String json) {
                callback.onGetBannerSuccess(json);
            }

            @Override
            public void falied(String msg) {
                callback.onGetBannerFailure(msg);
            }
        });
    }

    @Override
    public void getList(String url, final IModelGetListCallback callback) {
        NetUtil.getNetUtil().getJson(url, new NetUtil.CallBack() {
            @Override
            public void success(String json) {
                callback.onGetListSuccess(json);
            }

            @Override
            public void falied(String msg) {
                callback.onGetListFailure(msg);
            }
        });
    }
}
