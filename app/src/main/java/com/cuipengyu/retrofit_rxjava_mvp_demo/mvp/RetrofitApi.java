package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/22
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RetrofitApi {
    public static <T> T getApiService(Class<T> tClass, String BaseUrl) {
        Retrofit retrofit = new Retrofit.Builder().client(OkHttpClientHelper.getmOkHttpClient().getClient()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl(BaseUrl).build();
        return retrofit.create(tClass);
    }
}
