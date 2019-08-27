package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhkj.syyj.Activitys.MemberActivity;
import com.zhkj.syyj.Activitys.MyBalanceActivity;
import com.zhkj.syyj.Activitys.MyOrderActivity;
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fm_min_rel_my_order:
                startActivity(new Intent(mContext, MyOrderActivity.class));
                break;
            case R.id.fm_min_my_balance:
                startActivity(new Intent(mContext, MyBalanceActivity.class));
                break;
            case R.id.fm_min_ll_member:
                startActivity(new Intent(mContext, MemberActivity.class));
                break;
                default:
                    break;
        }
    }
}
