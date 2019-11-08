package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.CategoryListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;

import java.util.ArrayList;
import java.util.List;


public class RecyclerRightAdapter extends RecyclerView.Adapter<RecyclerRightAdapter.ViewHolder> {

    public Context mContext;
    public int todayHeatNum=0;
    List<CategoryListBean.DataBean.TmenuBean> dataList=new ArrayList<>();

    public RecyclerRightAdapter(Context context, List<CategoryListBean.DataBean.TmenuBean> data){
        mContext=context;
        this.dataList=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_fm_shop_right, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+dataList.get(position).getImage()).into(holder.right_img);
        holder.right_text.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void refreshData(int heatNum){
        todayHeatNum=heatNum;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView right_img;
        TextView right_text;
        public ViewHolder(View itemView) {
            super(itemView);
             right_img = itemView.findViewById(R.id.shop_right_img);
             right_text = itemView.findViewById(R.id.right_text);
        }
    }
}
