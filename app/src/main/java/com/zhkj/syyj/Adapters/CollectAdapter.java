package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zhkj.syyj.Activitys.ShoppingAddressUpdateActivity;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class CollectAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    private CheckBox cb_child;

    public CollectAdapter(Context context) {
        super(context, R.layout.item_shopping_car_child);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, final int position, String item) {
        String data = getData(position);
        TextView tv_number = viewHolder.getView(R.id.tv_edit_buy_number);
        TextView tv_price_value = viewHolder.getView(R.id.tv_price_value);
        cb_child = viewHolder.getView(R.id.cb_child);
        cb_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("点击了","是的"+position);
            }
        });
        tv_number.setText(position+"");
        tv_price_value.setText(data);
    }
}
