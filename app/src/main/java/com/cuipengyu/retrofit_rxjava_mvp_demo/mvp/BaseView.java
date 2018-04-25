package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/25
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public interface BaseView<T> {
    void lodingShow();

    void lodingDissmis();

    void setPresenter(T presenter);
}
