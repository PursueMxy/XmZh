package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.zhkj.syyj.Adapters.IntegralAdapter;
import com.zhkj.syyj.Adapters.IntergralTopAdapter;
import com.zhkj.syyj.Adapters.OnItemClickListener;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class IntegralActivity extends AppCompatActivity {

    private RecyclerView top_recyclerView;
    private List<String> list=new ArrayList<>();
    private IntergralTopAdapter intergralTopAdapter;
    private Context mContext;
    private XRecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private IntegralAdapter integralAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        list.add("分类1");
        list.add("分类2");
        list.add("分类3");
        list.add("分类4");
        list.add("分类5");
        list.add("分类6");
        list.add("分类7");
        list.add("分类8");
        list.add("分类9");
        list.add("分类10");
        top_recyclerView = findViewById(R.id.integral_top_recyclerView);
        intergralTopAdapter = new IntergralTopAdapter(this, list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        top_recyclerView.setLayoutManager(manager);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        top_recyclerView.setNestedScrollingEnabled(false);
        top_recyclerView.setAdapter(intergralTopAdapter);
        intergralTopAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.showToast(mContext,position+"条");
            }
        });
        mRecyclerView = findViewById(R.id.integral_recycleView_item);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new GridLayoutManager(mContext,2);
        integralAdapter = new IntegralAdapter(this);
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
        mRecyclerView.setAdapter(integralAdapter );
        integralAdapter.setListAll(list);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_15)));
            }
        });
    }
}