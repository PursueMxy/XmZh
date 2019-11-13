package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.ShoppingAddressPresenter;

public interface ShoppingAddressContract {
    interface Model {
        void PostAddress(ShoppingAddressPresenter shoppingAddressPresenter, String uid, String token);
    }

    interface View {
    }

    interface Presenter {
        void  GetAddressList(String uid,String token);
        void SetAddressList(String content);
    }
}
