package com.zhkj.syyj.presenter;

import com.zhkj.syyj.contract.ShoppingAddressAddContract;
import com.zhkj.syyj.contract.ShoppingAddressContract;
import com.zhkj.syyj.model.ShoppingAddressModel;

public class ShoppingAddressAddPresenter implements ShoppingAddressAddContract.Presenter {
    private ShoppingAddressContract.View mView;
    private ShoppingAddressModel model;
    public ShoppingAddressAddPresenter(ShoppingAddressContract.View view){
        this.mView=view;
        this.model=new ShoppingAddressModel();
    }
}
