package com.dyx.ndfap.library;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * project name：Network-Diagnosis-For-Android-Project
 * class describe：服务器状态工具类
 * create person：dayongxin
 * create time：16/7/27 下午4:59
 * alter person：dayongxin
 * alter time：16/7/27 下午4:59
 * alter remark：
 */
public class ServerStateUtil {
    private Context context;
    private String url;
    private String result = "";


    public ServerStateUtil(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    public void getServerStateMsg() {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result = "";
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result = error.getMessage();
            }
        });
        queue.add(request);
    }

    public String getResult() {
        return result;
    }
}
