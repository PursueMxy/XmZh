package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ShopChoiceAdapter extends HelperRecyclerViewAdapter<Products> {

    public ShopChoiceAdapter(Context context) {
        super(context, R.layout.list_home_shop_choice);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, Products item) {
        Products data = getData(position);
        TextView tv_price= viewHolder.getView(R.id.list_home_shop_choice_tv_price);
        TextView tv_detail = viewHolder.getView(R.id.list_home_shop_choice_tv_detail);
        ImageView choice_img = viewHolder.getView(R.id.list_home_shop_choice_img);
    }
}
