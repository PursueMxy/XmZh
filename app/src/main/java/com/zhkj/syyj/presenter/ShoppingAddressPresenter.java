package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.AddressListBean;
import com.zhkj.syyj.contract.ShoppingAddressContract;
import com.zhkj.syyj.model.ShoppingAddressModel;

import java.util.List;

public class ShoppingAddressPresenter implements ShoppingAddressContract.Presenter {
    public ShoppingAddressContract.View mView;
    public ShoppingAddressModel shoppingAddressModel;
    public ShoppingAddressPresenter(ShoppingAddressContract.View view){
        mView=view;
        shoppingAddressModel=new ShoppingAddressModel();
    }

    //获取收货地址列表
    public void  GetAddressList(String uid,String token){
     shoppingAddressModel.PostAddress(this,uid,token);
    }

    //解析收货地址列表
    public void SetAddressList(String content){
        AddressListBean addressListBean = new GsonBuilder().create().fromJson(content, AddressListBean.class);
        if (addressListBean.getCode()==1){
            List<AddressListBean.DataBean> data = addressListBean.getData();
            mView.UpdateAddressList(addressListBean.getCode(),addressListBean.getMsg(),data);
        }
    }
}
