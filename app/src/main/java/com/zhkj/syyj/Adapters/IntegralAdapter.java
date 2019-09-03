package com.zhkj.syyj.Adapters;

import android.content.Context;

import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class IntegralAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public IntegralAdapter(Context context) {
        super(context, R.layout.list_integral);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
    }
}
