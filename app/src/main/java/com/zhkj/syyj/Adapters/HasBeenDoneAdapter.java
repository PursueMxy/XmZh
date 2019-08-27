package com.zhkj.syyj.Adapters;

import android.content.Context;

import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class HasBeenDoneAdapter extends HelperRecyclerViewAdapter<String> {

    public HasBeenDoneAdapter(Context context) {
        super(context, R.layout.list_has_been_done);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
    }
}
