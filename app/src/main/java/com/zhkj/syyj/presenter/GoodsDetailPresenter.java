package com.zhkj.syyj.presenter;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.GoodsDetailBean;
import com.zhkj.syyj.contract.GoodsDetailContract;
import com.zhkj.syyj.model.GoodsDetailModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.sql.StatementEvent;

public class GoodsDetailPresenter implements GoodsDetailContract.Presenter {

    public GoodsDetailContract.View mView;
    public GoodsDetailModel goodsDetailModel;

    public GoodsDetailPresenter(GoodsDetailContract.View view){
        this.mView=view;
        goodsDetailModel=new GoodsDetailModel();
    }

    public void GetGoodsDetail(String uid, String token, String goods_id){
      goodsDetailModel.PsotGoodsDetail(this,uid,token,goods_id);
    }

    public void SetGoodsDetail(String content){
        parseJSONWithJSONObject(content);
    }
    private void parseJSONWithJSONObject(String jsonData){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonData);
            int code = jsonObject.getInt("code");
            String msg = jsonObject.getString("msg");
            String data = jsonObject.getString("data");
            mView.UpdateUI(code,msg,data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        }

}
