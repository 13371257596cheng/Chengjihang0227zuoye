package com.example.chengjihang0227zuoye.uitils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chengjihang0227zuoye.base.APP;

import java.util.HashMap;


public class VolleyUtils {
    RequestQueue mQueue;

    private VolleyUtils(){
        mQueue= Volley.newRequestQueue(APP.getAppContext());
    }

    public static class SingInstance{
        public static final VolleyUtils INSTANCE=new VolleyUtils();
    }

    public static VolleyUtils getInstance() {
        return SingInstance.INSTANCE;
    }
    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.success(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.falied(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }

    public void doPost(String url, HashMap<String, String> map, final CallBack callBack){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.success(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.falied(error.getMessage());
            }
        });
        mQueue.add(stringRequest);



    }


    public interface CallBack{
        void success(String json);
        void falied(String msg);
    }



}
