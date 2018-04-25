package com.cuipengyu.retrofit_rxjava_mvp_demo.mvp;

import com.cuipengyu.retrofit_rxjava_mvp_demo.RetrofitBean;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/25
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class Presenter implements Controller.presenter {
    private Controller.Model model;
    private Controller.View view;

    public Presenter(Controller.View view) {
        this.view = view;
        model = new Mode();
        view.setPresenter(this);
    }
    @Override
    public void getData() {
   model.getModel(new BaseHttpEntity<RetrofitBean>() {
       @Override
       public void onSuccess(RetrofitBean data) {
           view.setData(data);
       }
       @Override
       public void onError(String error) {
       }
       @Override
       public void onFinish() {
       }
   });
    }

    @Override
    public void start() {
          getData();
    }
}
