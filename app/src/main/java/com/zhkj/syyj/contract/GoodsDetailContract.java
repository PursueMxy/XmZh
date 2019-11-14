package com.zhkj.syyj.contract;

import com.zhkj.syyj.Beans.GoodsDetailBean;
import com.zhkj.syyj.presenter.GoodsDetailPresenter;
import com.zhkj.syyj.presenter.GoodsListPresenter;

public interface GoodsDetailContract {
    interface Model {
        void PsotGoodsDetail(GoodsDetailPresenter goodsDetailPresenter, String uid, String token, String goods_id);
        void PostCardAdd(GoodsDetailPresenter goodsDetailPresenter, String uid, String token, String goods_id, String item_id, String goods_num);
        void PostCardAdd2(GoodsDetailPresenter goodsDetailPresenter,String uid,String token,String goods_id,String item_id,String goods_num,String action);
    }

    interface View {
        void UpdateUI(int code, String msg, String data);
        void  UpdateCartAdd(int code,String msg);
        void UpdateCartBuy(int code,String msg,String content);
    }

    interface Presenter {
        void GetGoodsDetail(String uid, String token, String goods_id);
        void SetGoodsDetail(String content);
        void  GetCartAdd(String uid,String token,String goods_id,String item_id,String goods_num);
        void  GetCartAdd2(String uid,String token,String goods_id,String item_id,String goods_num,String action);
    }
}
