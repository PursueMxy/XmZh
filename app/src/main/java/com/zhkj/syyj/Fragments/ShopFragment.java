package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Activitys.ShopFmSearchActivity;
import com.zhkj.syyj.Adapters.OnItemClickListener;
import com.zhkj.syyj.Adapters.RecyclerLeftAdapter;
import com.zhkj.syyj.Adapters.RecyclerRightAdapter;
import com.zhkj.syyj.Beans.CategoryListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private Context mContext;
    private EditText edt_content;
    private TextView tv_search;
    private TextView tv_search_null;
    private int SHOPFMSEARCH_CODE=1001;
    private String token;
    private String uid;
    private RecyclerView recycler_left;
    private RecyclerView recycler_right;
    private List<CategoryListBean.DataBean.TmenuBean> tmenu=new ArrayList<>();
    private List<CategoryListBean.DataBean> datalist=new ArrayList<>();
    private LinearLayout ll_two_rec;
    private RecyclerLeftAdapter recyclerLeftAdapter;
    private RecyclerRightAdapter recyclerRightAdapter;


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        mContext = getContext();
        SharedPreferences share = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        InitData();
        return inflate;
    }

    private void InitData() {
        OkGo.<String>get(RequstUrlUtils.URL.CategoryList)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new GsonBuilder().create();
                        CategoryListBean categoryListBean = gson.fromJson(response.body(), CategoryListBean.class);
                        if (categoryListBean.getCode()==1){
                            datalist = categoryListBean.getData();
                            recyclerLeftAdapter.refreshData(datalist);
                            recyclerLeftAdapter.notifyDataSetChanged();
                            if ( datalist.size()>0){
                                tmenu = datalist.get(0).getTmenu();
                                GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
                                recycler_right.setLayoutManager(gridLayoutManager);
                                recyclerRightAdapter = new RecyclerRightAdapter(mContext, tmenu);
                                recycler_right.setAdapter(recyclerRightAdapter);
                            }
                        }else {
                            ToastUtils.showToast(mContext,categoryListBean.getMsg());
                        }
                    }
                });
    }

    private void InitUI() {
        inflate.findViewById(R.id.fm_shop_rl_search).setOnClickListener(this);
        ll_two_rec = inflate.findViewById(R.id.fm_shop_ll_two_rec);
        recycler_left = inflate.findViewById(R.id.fm_shop_recycler_left);
        recycler_right = inflate.findViewById(R.id.fm_shop_recycler_right);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recycler_left.setLayoutManager(layoutManager);
        recyclerLeftAdapter = new RecyclerLeftAdapter(mContext, datalist);
        recycler_left.setAdapter(recyclerLeftAdapter);
        recyclerLeftAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                tmenu = datalist.get(position).getTmenu();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
                recycler_right.setLayoutManager(gridLayoutManager);
                recyclerRightAdapter = new RecyclerRightAdapter(mContext, tmenu);
                recycler_right.setAdapter(recyclerRightAdapter);
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }


    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return
     */
    public int dpToPx(Context context, float dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5f);
    }
    /**
     * 获得资源 dimens (dp)
     *
     * @param context
     * @param id      资源id
     * @return
     */
    public float getDimens(Context context, int id) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        float px = context.getResources().getDimension(id);
        return px / dm.density;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fm_shop_rl_search:
                Intent intent2 = new Intent(mContext, ShopFmSearchActivity.class);
                startActivityForResult(intent2,SHOPFMSEARCH_CODE);
                break;
                default:
                    break;
        }
    }
}
