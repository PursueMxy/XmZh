package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.GoodsDetailBean;
import com.zhkj.syyj.presenter.GoodsDetailPresenter;

public interface GoodsDetailContract {
    interface Model {
        void PsotGoodsDetail(GoodsDetailPresenter goodsDetailPresenter, String uid, String token, String goods_id);
    }

    interface View {
        void UpdateUI(int code, String msg, String data);
    }

    interface Presenter {
        void GetGoodsDetail(String uid, String token, String goods_id);
        void SetGoodsDetail(String content);
    }
}
