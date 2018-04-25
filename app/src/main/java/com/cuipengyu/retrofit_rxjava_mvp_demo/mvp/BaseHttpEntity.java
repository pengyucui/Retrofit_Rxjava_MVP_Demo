package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/24
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public interface BaseHttpEntity<T> {
    void onSuccess(T data);

    void onError(String error);

    void onFinish();
}
