package com.cuipengyu.retrofit_rxjava_mvp_demo;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/25
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public interface RetrofitService {
//    http://service.picasso.adesk.com/v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot
    @GET("v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot")
    Call<RetrofitBean> getData1();
    @GET("v1/{vertical}/vertical?limit=30&skip=180&adult=false&first=0&order=hot")
    Call<RetrofitBean> getPath1(@Path("vertical") String vertical);

    @GET("v1/vertical/vertical?limit=30&skip=180&adult=false")
    Call<RetrofitBean> getQuery1(@Query("first") int first,@Query("order") String hot);
    @GET()
    Call<RetrofitBean> getUrl1(@Url String url);

    @GET("v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot")
    Observable<RetrofitBean> getData();
    @GET("v1/{vertical}/vertical?limit=30&skip=180&adult=false&first=0&order=hot")
    Observable<RetrofitBean> getPath(@Path("vertical") String vertical);

    @GET("v1/vertical/vertical?limit=30&skip=180&adult=false")
    Observable<RetrofitBean> getQuery(@Query("first") int first,@Query("order") String hot);
    @GET()
    Observable<RetrofitBean> getUrl(@Url String url);
}
