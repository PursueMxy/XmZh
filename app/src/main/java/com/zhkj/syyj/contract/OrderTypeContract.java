package com.zhkj.syyj.contract;

public interface OrderTypeContract {
    interface Model {
        void PostOrderType(String uid,String token,String type,int  page,int order_type);
    }

    interface View {
    }

    interface Presenter {
        void GetOrderType(String uid,String token,String type,int  page,int order_type);
    }
}
