package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/22
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ： 获取okhttp
 */
public class OkHttpClientHelper {
    //写入超时
    private static final int WRITE_TIME_OUT = 30;
    //建立连接的超时时间
    private static final int CONNECT_TIME_OUT = 30;
    //读取超时
    private static final int READ_TIME_OUT = 30;
    private static OkHttpClientHelper client;
    private OkHttpClient mOkHttpClient;

    public static OkHttpClientHelper getmOkHttpClient() {
        if (client == null) return new OkHttpClientHelper();
        return client;
    }

    public OkHttpClient getClient() {
        mOkHttpClient = new OkHttpClient.Builder().writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS).connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS).readTimeout(READ_TIME_OUT, TimeUnit.SECONDS).addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                Log.e("mOkHttpClient",response.toString());
                return response;
            }
        }).build();
        return mOkHttpClient;
    }

}
