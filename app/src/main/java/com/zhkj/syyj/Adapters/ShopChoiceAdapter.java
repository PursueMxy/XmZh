package com.zhkj.syyj.Adapters;

import android.content.Context;
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
    }
}
