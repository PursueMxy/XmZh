package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.Adapters.ShoppingAddressAdapter;
import com.zhkj.syyj.Beans.AddressListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.contract.ShoppingAddressContract;
import com.zhkj.syyj.presenter.ShoppingAddressPresenter;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class  ShoppingAddressActivity extends AppCompatActivity implements View.OnClickListener, ShoppingAddressContract.View {

    private XRecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private Context mContext;
    private ShoppingAddressAdapter shoppingAddressAdapter;
    private List<AddressListBean.DataBean> tasklist_item=new ArrayList<>();
    private ShoppingAddressPresenter shoppingAddressPresenter;
    private String uid;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_address);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        InitUI();
        shoppingAddressPresenter = new ShoppingAddressPresenter(this);
        shoppingAddressPresenter.GetAddressList(uid,token);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        shoppingAddressPresenter.GetAddressList(uid,token);
    }

    private void InitUI() {
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

    //获取收货列表
    public void UpdateAddressList(int code,String msg,List<AddressListBean.DataBean> data){
        this.tasklist_item=data;
        shoppingAddressAdapter.setListAll(data);
        mRecyclerView.setAdapter(shoppingAddressAdapter);
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public String Token(){
        return token;
    }
    public String Uid(){
        return uid;
    }
}
