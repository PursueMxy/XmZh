package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhkj.syyj.Activitys.ForwardActivity;
import com.zhkj.syyj.Activitys.GoodsDetailActivity;
import com.zhkj.syyj.Activitys.HomeActivity;
import com.zhkj.syyj.Activitys.InformationChoiceActivity;
import com.zhkj.syyj.Activitys.InformationChoiceDetailActivity;
import com.zhkj.syyj.Activitys.ReMindActivity;
import com.zhkj.syyj.Adapters.ShopChoiceAdapter;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

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
    private View home_top;


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

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    private void InitUI() {
        home_top = getLayoutInflater().inflate(R.layout.fm_home_top, null);
        home_top.findViewById(R.id.fmhome_tv_information_choice).setOnClickListener(this);
        home_top.findViewById(R.id.fmhome_rl_information_choice).setOnClickListener(this);
        NoScrollListView task_list = home_top.findViewById(R.id.home_task_list);
        task_list.setAdapter(new TaskAdapter());
        final Products products = new Products("1");
        final Products products2 = new Products("2");
        final Products products3 = new Products("3");
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
        mRecyclerView.addHeaderView(home_top);
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
                list.add(products);
                list.add(products2);
                list.add(products3);
                //加载更多
                shopChoiceAdapter.addItemsToLast(list);
                shopChoiceAdapter.notifyDataSetChanged();
                mRecyclerView.setNoMore(true);//数据加载完成
                mRecyclerView.loadMoreComplete();//加载动画完成
            }
        });
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_13))
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_5)));
            }
        });
        shopChoiceAdapter.setListAll(list);
        mRecyclerView.setAdapter(shopChoiceAdapter);
        shopChoiceAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                startActivity(new Intent(mContext, GoodsDetailActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fmhome_tv_information_choice:
                startActivity(new Intent(mContext, InformationChoiceActivity.class));
                break;
            case R.id.fmhome_rl_information_choice:
                startActivity(new Intent(mContext, InformationChoiceDetailActivity.class));
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
            inflate.findViewById(R.id.list_home_task_btn_forward).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(mContext, ForwardActivity.class));
                }
            });
            inflate.findViewById(R.id.list_home_task_btn_setReMind).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(mContext, ReMindActivity.class));
                }
            });
            return inflate;
        }
    }
}
