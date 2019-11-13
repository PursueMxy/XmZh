package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.GoodsDetailContract;
import com.zhkj.syyj.presenter.GoodsDetailPresenter;

public class GoodsDetailModel implements GoodsDetailContract.Model {

    /**
     *获取商品详情
     */
    public void PsotGoodsDetail(final GoodsDetailPresenter goodsDetailPresenter, String uid, String token, String goods_id){
        OkGo.<String>get(RequstUrlUtils.URL.GoodsInfo)
                .params("uid",uid)
                .params("token",token)
                .params("id",goods_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                   goodsDetailPresenter.SetGoodsDetail(response.body());
                    }
                });
    }
}
