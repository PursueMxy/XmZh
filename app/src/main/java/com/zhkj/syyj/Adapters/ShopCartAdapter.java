package com.zhkj.syyj.Adapters;

import android.content.Context;

import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ShopCartAdapter extends HelperRecyclerViewAdapter<Products> {

    public ShopCartAdapter(Context context) {
        super(context, R.layout.list_fm_shopcart);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, Products item) {
        Products data = getData(position);
//        TextView tv_proname = viewHolder.getView(R.id.fh_goods_tv_proname);
//        TextView tv_costprice= viewHolder.getView(R.id.fh_goods_tv_costprice);
//        tv_proname.setText(data.getProductName());
//        tv_costprice.setText(data.getCostPrice()+"");
    }
}
