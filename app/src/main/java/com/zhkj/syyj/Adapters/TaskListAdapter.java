package com.zhkj.syyj.Adapters;

import android.content.Context;

import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class TaskListAdapter extends HelperRecyclerViewAdapter<String> {

    public TaskListAdapter(Context context) {
        super(context, R.layout.list_home_task);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
    }
}
