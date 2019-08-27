package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhkj.syyj.Activitys.HomeActivity;
import com.zhkj.syyj.Activitys.InformationChoiceActivity;
import com.zhkj.syyj.Adapters.ShopChoiceAdapter;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private Context mContext;
    private XRecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private ShopChoiceAdapter shopChoiceAdapter;
    private static List<Products> list= new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = getContext();
        InitUI();
        return inflate;
    }

    private void InitUI() {
        inflate.findViewById(R.id.fmhome_tv_information_choice).setOnClickListener(this);
        NoScrollListView task_list = inflate.findViewById(R.id.home_task_list);
        task_list.setAdapter(new TaskAdapter());
        Products products = new Products("1");
        Products products2 = new Products("2");
        Products products3 = new Products("3");
        list.add(products);
        list.add(products2);
        list.add(products3);
        list.add(products);
        list.add(products2);
        list.add(products3);
        list.add(products);
        list.add(products2);
        list.add(products3);
        mRecyclerView = inflate.findViewById(R.id.fmhome_XRecyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager =new GridLayoutManager(mContext, 2);
        shopChoiceAdapter = new ShopChoiceAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        shopChoiceAdapter.setListAll(list);

        mRecyclerView.setAdapter(shopChoiceAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fmhome_tv_information_choice:
                startActivity(new Intent(mContext, InformationChoiceActivity.class));
                break;
                default:
                    break;
        }
    }

    public class TaskAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = getLayoutInflater().inflate(R.layout.list_home_task, null);
            return inflate;
        }
    }
}
