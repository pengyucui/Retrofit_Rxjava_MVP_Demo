package com.cuipengyu.retrofit_rxjava_mvp_demo.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cuipengyu.retrofit_rxjava_mvp_demo.R;
import com.cuipengyu.retrofit_rxjava_mvp_demo.RetrofitBean;
import com.cuipengyu.retrofit_rxjava_mvp_demo.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cuipengyu.retrofit_rxjava_mvp_demo.constans.baseUrl;
import static com.cuipengyu.retrofit_rxjava_mvp_demo.constans.mNewline;

public class RetrofitActivity extends AppCompatActivity {
private StringBuffer buffer=new StringBuffer();
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        textView=findViewById(R.id.retrofit_tv);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service=retrofit.create(RetrofitService.class);

        service.getData1().enqueue(new Callback<RetrofitBean>() {
            @Override
            public void onResponse(Call<RetrofitBean> call, Response<RetrofitBean> response) {
                buffer.append("response--getData："+mNewline+response.toString()+mNewline);
                textView.setText(buffer);
            }
            @Override
            public void onFailure(Call<RetrofitBean> call, Throwable t) {
            }
        });
        service.getPath1("vertical").enqueue(new Callback<RetrofitBean>() {
            @Override
            public void onResponse(Call<RetrofitBean> call, Response<RetrofitBean> response) {
                buffer.append("response--getPath："+mNewline+response.toString()+mNewline);
                textView.setText(buffer);
            }

            @Override
            public void onFailure(Call<RetrofitBean> call, Throwable t) {
            }
        });
        service.getQuery1(0,"hot").enqueue(new Callback<RetrofitBean>() {
            @Override
            public void onResponse(Call<RetrofitBean> call, Response<RetrofitBean> response) {
                buffer.append("response--getQuery："+mNewline+response.toString()+mNewline);
                textView.setText(buffer);
            }

            @Override
            public void onFailure(Call<RetrofitBean> call, Throwable t) {
            }
        });
        service.getUrl1("v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot").enqueue(new Callback<RetrofitBean>() {
            @Override
            public void onResponse(Call<RetrofitBean> call, Response<RetrofitBean> response) {
                buffer.append("response--getUrl："+mNewline+response.toString()+mNewline);
                textView.setText(buffer);
            }
            @Override
            public void onFailure(Call<RetrofitBean> call, Throwable t) {
            }
        });
    }
}
