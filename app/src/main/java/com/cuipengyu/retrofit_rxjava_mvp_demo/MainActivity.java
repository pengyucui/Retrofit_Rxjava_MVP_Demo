package com.cuipengyu.retrofit_rxjava_mvp_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cuipengyu.retrofit_rxjava_mvp_demo.Rxjava.RxjavaActivity;
import com.cuipengyu.retrofit_rxjava_mvp_demo.mvp.MvpActivity;
import com.cuipengyu.retrofit_rxjava_mvp_demo.retrofit.RetrofitActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.retrofit_btn:
                Intent RetrofitActivity = new Intent(this, RetrofitActivity.class);
                startActivity(RetrofitActivity);
                break;
            case R.id.rxjava_btn:
                Intent RxjavaActivity = new Intent(this, RxjavaActivity.class);
                startActivity(RxjavaActivity);
                break;
            case R.id.mvp_btn:
                Intent mvpActivity = new Intent(this, MvpActivity.class);
                startActivity(mvpActivity);
                break;
        }
    }
}
