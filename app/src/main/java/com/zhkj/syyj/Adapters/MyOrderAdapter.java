package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhkj.syyj.Activitys.OrderDetailActivity;
import com.zhkj.syyj.Beans.OrderBean;
import com.zhkj.syyj.Beans.OrderListBean;
import com.zhkj.syyj.Beans.ShoppingCarDataBean;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyOrderAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private List<OrderListBean.DataBean> data;
    private boolean isSelectAll = false;
    private double total_price;

    public MyOrderAdapter(Context context) {
        this.context = context;

    }

    /**
     * 自定义设置数据方法；
     * 通过notifyDataSetChanged()刷新数据，可保持当前位置
     *
     * @param data 需要刷新的数据
     */
    public void setData(List<OrderListBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        if (data != null && data.size() > 0) {
            return data.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (data.get(groupPosition).getOrder_goods() != null && data.get(groupPosition).getOrder_goods() .size() > 0) {
            return data.get(groupPosition).getOrder_goods() .size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getOrder_goods() .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.myorder_item_top, null);

            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("点击事件",groupPosition+"");
                context.startActivity(new Intent(context,OrderDetailActivity.class));
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.myorder_item_detail, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        final OrderListBean.DataBean datasBean = data.get(groupPosition);
        if (childPosition==(datasBean.getOrder_goods().size()-1)){
            childViewHolder.myorder_item_bottom_rl.setVisibility(View.VISIBLE);
        }else {
            childViewHolder.myorder_item_bottom_rl.setVisibility(View.GONE);
        }
        int receive_btn = datasBean.getReceive_btn();
        int pay_btn = datasBean.getPay_btn();
        int pay_status = datasBean.getPay_status();
        int cancel_btn = datasBean.getCancel_btn();
        int shipping_btn = datasBean.getShipping_btn();
        int shipping_status = datasBean.getShipping_status();
        int comment_btn = datasBean.getComment_btn();
        if (pay_btn==1&& cancel_btn == 1){
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_obligation.setVisibility(View.VISIBLE);
        }else if (receive_btn == 0 && pay_btn==0){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.VISIBLE);
        }else if (comment_btn == 1){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.VISIBLE);
        }else if (groupPosition==4){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.VISIBLE);
        }else {
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewHolder {
        GroupViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    static class ChildViewHolder {
        @InjectView(R.id.list_fm_shopcart_img)
        ImageView list_fm_shopcart_img;
        @InjectView(R.id.myorder_item_bottom_rl)
         RelativeLayout myorder_item_bottom_rl;
        @InjectView(R.id.item_shopping_ll_obligation)
        LinearLayout ll_obligation;
        @InjectView(R.id.item_shopping_ll_cancel_order)
        LinearLayout ll_cancel_order;
        @InjectView(R.id.item_shopping_ll_tobe_received)
        LinearLayout ll_tobe_received;
        @InjectView(R.id.item_shopping_ll_orderDone)
        LinearLayout ll_orderDone;
        ChildViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
