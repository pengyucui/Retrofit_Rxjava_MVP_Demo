package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import com.cuipengyu.retrofit_rxjava_mvp_demo.RetrofitBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/25
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class Mode implements Controller.Model {

    @Override
    public void getModel(final BaseHttpEntity<RetrofitBean> entity) {
        RetrofitHelper.getService().getApi().getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DefaultObserver<RetrofitBean>() {

            @Override
            public void onSuccess(RetrofitBean data) {
                entity.onSuccess(data);
            }
            @Override
            public void onError(String error) {
                entity.onError(error);
            }
            @Override
            public void onFinish() {
            }
        });
    }
}
