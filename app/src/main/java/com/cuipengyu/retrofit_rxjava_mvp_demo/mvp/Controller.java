package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import com.cuipengyu.retrofit_rxjava_mvp_demo.RetrofitBean;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/25
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class Controller {
    public interface presenter extends BasePresenter {
        void getData();
    }
    public interface View extends BaseView<presenter> {
        void setData(RetrofitBean RetrofitBean);
    }
    public interface Model {
        void getModel(BaseHttpEntity<RetrofitBean > entity);
    }
}
