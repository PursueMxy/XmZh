package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.zhkj.syyj.Activitys.ShoppingAddressUpdateActivity;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class CollectAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public CollectAdapter(Context context) {
        super(context, R.layout.item_shopping_car_child);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
    }
}
