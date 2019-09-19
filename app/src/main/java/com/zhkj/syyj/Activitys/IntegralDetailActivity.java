package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.Adapters.IntegralDeatilAdapter;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class IntegralDetailActivity extends AppCompatActivity{

    @InjectView(R.id.integral_detail_recyclerView)
    XRecyclerView mRecyclerView;
    private Context mContext;
    private List<String> list=new ArrayList<>();
    private LinearLayoutManager mLayoutManager;
    private IntegralDeatilAdapter integralDeatilAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_detail);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
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
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        integralDeatilAdapter = new IntegralDeatilAdapter(this);
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
        mRecyclerView.setAdapter(integralDeatilAdapter);
        integralDeatilAdapter.setListAll(list);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_2)));
            }
        });
    }

    @OnClick({R.id.integral_detail_img_back,R.id.integral_dtl_btn_redeem_now})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.integral_detail_img_back:
                finish();
                break;
            case R.id.integral_dtl_btn_redeem_now:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
