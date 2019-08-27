package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.zhkj.syyj.Adapters.HasBeenDoneAdapter;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {


    private View inflate;
    private TabLayout task_tablelayout;
    private List<String> titles=new ArrayList<>();
    private ViewPager task_viewpager;

    private List<Fragment> fragments=new ArrayList<>();
    private RadioGroup task_radioGroup;
    private RadioButton ckbtn_task;
    private RadioButton ckbtn_done;
    private XRecyclerView mRecyclerView;
    private List<String> tasklist_item=new ArrayList<>();
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private HasBeenDoneAdapter hasBeenDoneAdapter;

    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_task, container, false);
        mContext = getContext();
        tasklist_item.add("112");
        tasklist_item.add("112");
        tasklist_item.add("112");
        tasklist_item.add("112");
        tasklist_item.add("112");
        InitUI();
        return inflate;
    }

    private void InitUI() {
        titles.add("任务1");
        titles.add("任务2");
        titles.add("任务3");
        titles.add("任务4");
        titles.add("任务5");
        titles.add("任务6");
        titles.add("任务7");
        fragments.add(new TaskListFragment());
        fragments.add(new TaskListFragment());
        fragments.add(new TaskListFragment());
        fragments.add(new TaskListFragment());
        fragments.add(new TaskListFragment());
        fragments.add(new TaskListFragment());
        fragments.add(new TaskListFragment());
        task_tablelayout = inflate.findViewById(R.id.fm_task_tablelayout);
        task_viewpager = inflate.findViewById(R.id.fm_task_viewpager);
        MyAdapter adapter=new MyAdapter(getFragmentManager());
        task_viewpager.setAdapter(adapter);
        task_tablelayout.setupWithViewPager(task_viewpager);
        task_radioGroup =  inflate.findViewById(R.id.fm_task_radioGroup);
        ckbtn_task =  inflate.findViewById(R.id.fm_task_ckbtn_task);
        ckbtn_done =  inflate.findViewById(R.id.fm_task_ckbtn_done);
        mRecyclerView = inflate.findViewById(R.id.fm_task_recyclerView);
        mLayoutManager = new LinearLayoutManager(mContext);
        hasBeenDoneAdapter = new HasBeenDoneAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
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
        hasBeenDoneAdapter.setListAll(tasklist_item);
        mRecyclerView.setAdapter(hasBeenDoneAdapter);
        task_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.e("checkedId",checkedId+"");
                switch (checkedId){
                    case R.id.fm_task_ckbtn_task:
                        mRecyclerView.setVisibility(View.GONE);
                        task_tablelayout.setVisibility(View.VISIBLE);
                        task_viewpager.setVisibility(View.VISIBLE);
                        ckbtn_done.setBackground(getResources().getDrawable(R.drawable.nochoosed_color));
                        ckbtn_task.setBackground(getResources().getDrawable(R.drawable.choosed_color));
                        break;
                    case R.id.fm_task_ckbtn_done:
                        mRecyclerView.setVisibility(View.VISIBLE);
                        task_tablelayout.setVisibility(View.GONE);
                        task_viewpager.setVisibility(View.GONE);
                        ckbtn_done.setBackground(getResources().getDrawable(R.drawable.choosed_color));
                        ckbtn_task.setBackground(getResources().getDrawable(R.drawable.nochoosed_color));
                        break;
                }
            }
        });
    }
    private class MyAdapter extends FragmentPagerAdapter {     //适配器
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);  //返回碎片集合的第几项
        }

        @Override
        public int getCount() {
            return fragments.size();    //返回碎片集合大小
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);    //返回标题的第几项
        }
    }
}
