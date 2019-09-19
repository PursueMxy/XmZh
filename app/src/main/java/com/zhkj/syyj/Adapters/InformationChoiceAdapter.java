package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class InformationChoiceAdapter extends HelperRecyclerViewAdapter<Products> {

    public InformationChoiceAdapter(Context context) {
        super(context, R.layout.list_information_choice);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, Products item) {
        Products data = getData(position);
        TextView tv_title = viewHolder.getView(R.id.list_information_choice_tv_title);
        TextView tv_time= viewHolder.getView(R.id.list_information_choice_tv_time);
        TextView tv_content = viewHolder.getView(R.id.list_information_choice_tv_content);
    }
}
