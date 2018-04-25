package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cuipengyu.retrofit_rxjava_mvp_demo.R;
import com.cuipengyu.retrofit_rxjava_mvp_demo.RetrofitBean;

public class MvpActivity extends AppCompatActivity implements Controller.View {
    private Controller.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        new Presenter(this);
        presenter.start();
    }

    @Override
    public void setData(RetrofitBean mRetrofitBean) {
        Log.e("mRetrofitBean.getCode()",mRetrofitBean.getCode()+"");
    }

    @Override
    public void lodingShow() {

    }

    @Override
    public void lodingDissmis() {

    }

    @Override
    public void setPresenter(Controller.presenter presenter) {
        this.presenter = presenter;
    }
}
