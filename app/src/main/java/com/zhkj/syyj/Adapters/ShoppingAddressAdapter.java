package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zhkj.syyj.Activitys.ShoppingAddressUpdateActivity;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ShoppingAddressAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public ShoppingAddressAdapter(Context context) {
        super(context, R.layout.list_shopping_address);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        viewHolder.getView(R.id.list_shopping_address_tv_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShoppingAddressUpdateActivity.class);
                context.startActivity(intent);
            }
        });
        viewHolder.getView(R.id.list_shopping_address_tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       TextView tv_address= viewHolder.getView(R.id.list_shopping_address_tv_address);
       TextView tv_name = viewHolder.getView(R.id.list_shopping_address_tv_name);
       TextView tv_default= viewHolder.getView(R.id.list_shopping_address_tv_default);
        CheckBox cb_default = viewHolder.getView(R.id.list_shopping_address_cb_default);
    }
}
