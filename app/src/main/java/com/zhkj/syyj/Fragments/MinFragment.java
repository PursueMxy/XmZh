package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ThemedSpinnerAdapter;

import com.zhkj.syyj.Activitys.CollectActivity;
import com.zhkj.syyj.Activitys.CouponActivity;
import com.zhkj.syyj.Activitys.HomeActivity;
import com.zhkj.syyj.Activitys.IntegralActivity;
import com.zhkj.syyj.Activitys.MemberActivity;
import com.zhkj.syyj.Activitys.MyBalanceActivity;
import com.zhkj.syyj.Activitys.MyOrderActivity;
import com.zhkj.syyj.Activitys.NewsActivity;
import com.zhkj.syyj.Activitys.OrderTypeActivity;
import com.zhkj.syyj.Activitys.PerSonalDataActivity;
import com.zhkj.syyj.Activitys.ShoppingAddressActivity;
import com.zhkj.syyj.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MinFragment extends Fragment implements View.OnClickListener {


    private Context mContext;
    private View inflate;

    public MinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_min, container, false);
        mContext = getContext();
        InitUI();
        return inflate;
    }

    private void InitUI() {
       inflate.findViewById(R.id.fm_min_rel_my_order).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_my_balance).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_ll_member).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_img_head).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_shopping_address).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rl_collect).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rl_coupon).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_integarl).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rl_news).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rel_obligation).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rel_tobe_shipped).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_rel_tobe_received).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_rel_orderDone).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_rel_task).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_my_integral).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fm_min_rel_my_order:
                startActivity(new Intent(mContext, MyOrderActivity.class));
                break;
            case R.id.fm_min_rel_obligation:
                Intent intent = new Intent(mContext, OrderTypeActivity.class);
                intent.putExtra("title","待付款");
                startActivity(intent);
                break;
            case R.id.fm_min_rel_tobe_shipped:
                Intent intent1 = new Intent(mContext, OrderTypeActivity.class);
                intent1.putExtra("title","待发货");
                startActivity(intent1);
                break;
            case R.id.fm_min_rel_tobe_received:
                Intent intent2 = new Intent(mContext, OrderTypeActivity.class);
                intent2.putExtra("title","待收货");
                startActivity(intent2);
                break;
            case R.id.fm_min_rel_orderDone:
                Intent intent3 = new Intent(mContext, OrderTypeActivity.class);
                intent3.putExtra("title","已完成");
                startActivity(intent3);
                break;
            case R.id.fm_min_my_balance:
                startActivity(new Intent(mContext, MyBalanceActivity.class));
                break;
            case R.id.fm_min_ll_member:
                startActivity(new Intent(mContext, MemberActivity.class));
                break;
            case R.id.fm_min_img_head:
                startActivity(new Intent(mContext, PerSonalDataActivity.class));
                break;
            case R.id.fm_min_shopping_address:
                startActivity(new Intent(mContext, ShoppingAddressActivity.class));
                break;
            case R.id.fm_min_rl_collect:
                startActivity(new Intent(mContext, CollectActivity.class));
                break;
            case R.id.fm_min_rl_coupon:
                startActivity(new Intent(mContext, CouponActivity.class));
                break;
            case R.id.fm_min_integarl:
                startActivity(new Intent(mContext, IntegralActivity.class));
                break;
            case R.id.fm_min_rl_news:
                startActivity(new Intent(mContext, NewsActivity.class));
                break;
            case R.id.fm_min_rel_task:
                Intent intent4 = new Intent(mContext, HomeActivity.class);
                intent4.putExtra("currentItems","2");
                startActivity(intent4);
                break;
            case R.id.fm_min_my_integral:
                startActivity(new Intent(mContext, IntegralActivity.class));
                break;
                default:
                    break;
        }
    }

}
