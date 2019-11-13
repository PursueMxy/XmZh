package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.MyBalancePresenter;

public interface MyBalanceContract {
    interface Model {
        void  PostBalance(MyBalancePresenter myBalancePresenter, String uid, String token);
    }

    interface View {
    }

    interface Presenter {
        void  GetBalance(String uid,String token);
    }
}
