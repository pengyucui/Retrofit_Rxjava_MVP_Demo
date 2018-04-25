package com.cuipengyu.retrofit_rxjava_mvp_demo.Rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cuipengyu.retrofit_rxjava_mvp_demo.R;
import com.cuipengyu.retrofit_rxjava_mvp_demo.constans;

import java.util.Vector;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxjavaActivity extends AppCompatActivity {
    StringBuffer buffer;
    StringBuffer buffer2;
    TextView textView;
    private StringBuffer buffer3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        textView = findViewById(R.id.rxjava_tv);

    }

    public void onRxjav(View view) {
        switch (view.getId()) {
            case R.id.rxjava_btn_1:
                btn1();
                buffer = null;
                break;
            case R.id.rxjava_btn_2:
                btn2();
                buffer = null;
                break;

        }
    }


    public void btn1() {
        buffer = new StringBuffer();
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                //ObservableEmitter是用来发送事件 onNext、onError、onComplete
                emitter.onNext(1);
                emitter.onNext(2);
                //onComplete 阻止onNext事件继续接收事件，发送没有影响
                emitter.onComplete();
                emitter.onNext(3);
                emitter.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                buffer.append("onNext：" + integer + constans.mNewline);
                textView.setText(buffer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void btn2() {
        buffer2 = new StringBuffer();
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e("Observable_Thread", Thread.currentThread().getName() + "");
                buffer2.append("Observable线程：" + Thread.currentThread().getName() + constans.mNewline);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);

            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e("Observer_onNext", Thread.currentThread().getName() + "");
                buffer2.append("onNext：" + integer + "线程：" + Thread.currentThread().getName() + constans.mNewline);
                textView.setText(buffer2);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void btn3() {
    }

}
