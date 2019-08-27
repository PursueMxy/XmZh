package com.zhkj.syyj.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhkj.syyj.Activitys.ShopFmSearchActivity;
import com.zhkj.syyj.Adapters.FmShopSearchAdapter;
import com.zhkj.syyj.Adapters.InformationChoiceAdapter;
import com.zhkj.syyj.Adapters.ScrollLeftAdapter;
import com.zhkj.syyj.Adapters.ScrollRightAdapter;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.Beans.ScrollBean;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private RecyclerView recLeft;
    private ScrollLeftAdapter leftAdapter;
    private Context mContext;
    private List<String> left=new ArrayList<>();;
    private ArrayList<ScrollBean> right=new ArrayList<>();
    private ArrayList<ScrollBean> right1=new ArrayList<>();
    //    右侧title在数据中所对应的position集合
    private List<Integer> tPosition = new ArrayList<>();
    private List<Integer> tPosition1 = new ArrayList<>();
    @SuppressLint("WrongConstant")
    private LinearLayoutManager linearLayoutManager;
    private ScrollRightAdapter rightAdapter;
    private LinearLayoutManager linearLayoutManager2;
    private RecyclerView recRight;
    public int first=0;
    private int tHeight;
    private static List<Products> list= new ArrayList<>();
    private LinearLayout ll_two_rec;
    private EditText edt_content;
    private TextView tv_search;
    private TextView tv_search_null;
    private int SHOPFMSEARCH_CODE=1001;


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        mContext = getContext();
        InitUI();
        return inflate;
    }

    private void InitUI() {
        //遍历左边列表,列表对应的内容等于右边的title,则设置左侧对应item高亮
        initData();
        initLeft();
        initRight();
        inflate.findViewById(R.id.fm_shop_rl_search).setOnClickListener(this);
        ll_two_rec = inflate.findViewById(R.id.fm_shop_ll_two_rec);
    }

    @SuppressLint("WrongConstant")
    private void initLeft() {
        recLeft = inflate.findViewById(R.id.fm_shop_rec_left);
        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        leftAdapter = new ScrollLeftAdapter(R.layout.list_shop_left, null);
        recLeft.setLayoutManager(linearLayoutManager);
        recLeft.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        recLeft.setAdapter(leftAdapter);
        recLeft.setAdapter(leftAdapter);
        leftAdapter.setNewData(left);

        leftAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    //点击左侧列表的相应item,右侧列表相应的title置顶显示
                    //(最后一组内容若不能填充右侧整个可见页面,则显示到右侧列表的最底端)
                    case R.id.item:
                        if (position%2==0) {
                            leftAdapter.selectItem(position);
                            rightAdapter.setNewData(right);
                        }else {
                            leftAdapter.selectItem(position);
                            rightAdapter.setNewData(right1);
                        }
                        break;
                }
            }
        });
    }

    @SuppressLint("WrongConstant")
    private void initRight() {

        recRight = inflate.findViewById(R.id.fm_shop_rec_right);
        linearLayoutManager2 = new GridLayoutManager(mContext, 3);
            rightAdapter = new ScrollRightAdapter(R.layout.list_fm_shop_right, R.layout.layout_right_title, null);
            recRight.setLayoutManager(linearLayoutManager2);
            rightAdapter.setUpFetchEnable(true);

            recRight.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.set(dpToPx(mContext, getDimens(mContext, R.dimen.dp_3))
                            , 0
                            , dpToPx(mContext, getDimens(mContext, R.dimen.dp_3))
                            , dpToPx(mContext, getDimens(mContext, R.dimen.dp_3)));
                }
            });
            recRight.setAdapter(rightAdapter);

        rightAdapter.setNewData(right);

        rightAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener(){
            @Override
            public void onLoadMoreRequested() {
               recRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rightAdapter.notifyDataSetChanged();
                        rightAdapter.loadMoreEnd();
                    }

                },2000);
            }
        },recRight);
        rightAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                recRight.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rightAdapter.setUpFetchEnable(true);
                        rightAdapter.setStartUpFetchPosition(0);
                    }
                },500);
            }
        });


    }


    private void initData() {
        left = new ArrayList<>();
        left.add("有品推荐");
        left.add("手机");
        left.add("居家");
        left.add("家电");
        left.add("服饰");
        left.add("智能");
        left.add("影音");

        right = new ArrayList<>();
        right.add(new ScrollBean(true, left.get(0)));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));
        right.add(new ScrollBean(new ScrollBean.ScrollItemBean("1111111", left.get(0))));



        right1.add(new ScrollBean(true, left.get(5)));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));
        right1.add(new ScrollBean(new ScrollBean.ScrollItemBean("6666666", left.get(5))));


        for (int i = 0; i < right.size(); i++) {
            if (right.get(i).isHeader) {
                //遍历右侧列表,判断如果是header,则将此header在右侧列表中所在的position添加到集合中
                tPosition.add(i);
            }
        }
        for (int i = 0; i < right1.size(); i++) {
            if (right1.get(i).isHeader) {
                //遍历右侧列表,判断如果是header,则将此header在右侧列表中所在的position添加到集合中
                tPosition1.add(i);
            }
        }

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
