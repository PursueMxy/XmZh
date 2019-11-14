package com.zhkj.syyj.presenter;

import com.lzy.okgo.OkGo;
import com.zhkj.syyj.contract.OrderTypeContract;
import com.zhkj.syyj.model.OrderTypeModel;

public class OrderTypePresenter implements OrderTypeContract.Presenter {

    public OrderTypeContract.View mView;
    public OrderTypeModel orderTypeModel;

    public OrderTypePresenter(OrderTypeContract.View view){
        this.mView=view;
        this.orderTypeModel=new OrderTypeModel();
    }

    //获取订单
    public void GetOrderType(String uid,String token,String type,int  page,int order_type){

    }
}
