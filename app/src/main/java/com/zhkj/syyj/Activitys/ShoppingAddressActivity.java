package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.Adapters.ShoppingAddressAdapter;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class  ShoppingAddressActivity extends AppCompatActivity implements View.OnClickListener {

    private XRecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private Context mContext;
    private ShoppingAddressAdapter shoppingAddressAdapter;
    private List<String> tasklist_item=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_address);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        tasklist_item.add("112");
        tasklist_item.add("112");
        tasklist_item.add("112");
        tasklist_item.add("112");
        tasklist_item.add("112");
        findViewById(R.id.shopping_address_tv_add).setOnClickListener(this);
        findViewById(R.id.shopping_address_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.shopping_address_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        shoppingAddressAdapter = new ShoppingAddressAdapter(this);
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
        mRecyclerView.setAdapter(shoppingAddressAdapter);
        shoppingAddressAdapter.setListAll(tasklist_item);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10)));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shopping_address_tv_add:
                startActivity(new Intent(mContext,ShoppingAddressAddActivity.class));
                break;
            case R.id.shopping_address_img_back:
                finish();
                break;
                default:
                    break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
          return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
