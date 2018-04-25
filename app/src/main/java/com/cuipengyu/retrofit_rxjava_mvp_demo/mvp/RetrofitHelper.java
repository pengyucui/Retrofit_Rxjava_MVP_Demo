package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import com.cuipengyu.retrofit_rxjava_mvp_demo.RetrofitService;
import com.cuipengyu.retrofit_rxjava_mvp_demo.constans;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/22
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RetrofitHelper {
    private static RetrofitHelper mHelper;
    private String BASE_URL = "";
    private RetrofitHelper() {
        BASE_URL = constans.baseUrl;
    }
    public static RetrofitHelper getService() {
        if (mHelper == null) mHelper = new RetrofitHelper();
        return mHelper;
    }

    public RetrofitService getApi() {
        return RetrofitApi.getApiService(RetrofitService.class, BASE_URL);
    }
}



