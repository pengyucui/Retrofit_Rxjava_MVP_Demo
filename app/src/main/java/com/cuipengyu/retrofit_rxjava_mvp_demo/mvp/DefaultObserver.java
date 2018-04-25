package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import java.net.ConnectException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/22
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ： 设置默认观察者请求回调
 */
public abstract class DefaultObserver<T> implements Observer<T> {
    private String ERROR_TOAST ="";
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ConnectException){
            ERROR_TOAST="连接超时，请稍后重试！";
            onError(ERROR_TOAST);
            onFinish();
        }else {
            onError(e.getMessage());
            onFinish();
        }
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T data);

    public abstract void onError(String error);

    public abstract void onFinish();
}
