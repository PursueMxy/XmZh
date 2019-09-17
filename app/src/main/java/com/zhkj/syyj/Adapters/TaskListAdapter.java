package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.zhkj.syyj.Activitys.ForwardActivity;
import com.zhkj.syyj.Activitys.ReMindActivity;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class TaskListAdapter extends HelperRecyclerViewAdapter<String> {
     private Context mContext;
    public TaskListAdapter(Context context) {
        super(context, R.layout.list_home_task);
        this.mContext=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        viewHolder.getView(R.id.list_home_task_btn_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ForwardActivity.class));
            }
        });
        viewHolder.getView(R.id.list_home_task_btn_setReMind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ReMindActivity.class));
            }
        });
    }
}
