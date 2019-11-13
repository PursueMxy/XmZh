package com.zhkj.syyj.presenter;

import com.zhkj.syyj.contract.MyBalanceContract;
import com.zhkj.syyj.model.MyBalanceModel;

public class MyBalancePresenter implements MyBalanceContract.Presenter {
    public MyBalanceContract.View mView;
    public MyBalanceModel myBalanceModel;

    public MyBalancePresenter(MyBalanceContract.View view){
        this.mView=view;
        this.myBalanceModel=new MyBalanceModel();
    }

    //获取我的余额
    public void  GetBalance(String uid,String token){
        myBalanceModel.PostBalance(this,uid,token);
    }
}
