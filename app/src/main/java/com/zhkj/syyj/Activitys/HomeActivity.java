package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.chaychan.library.BottomBarLayout;
import com.zhkj.syyj.CustView.MyViewPager;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.Fragments.HomeFragment;
import com.zhkj.syyj.Fragments.MinFragment;
import com.zhkj.syyj.Fragments.ShopCartFragment;
import com.zhkj.syyj.Fragments.ShopFragment;
import com.zhkj.syyj.Fragments.TaskFragment;
import com.zhkj.syyj.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Context mContext;
    private MyViewPager mVpContent;
    private BottomBarLayout home_bottombarly;
    private int currentItems=0;
    private List<Fragment> mFragmentList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        try {
            currentItems = Integer.parseInt(intent.getStringExtra("currentItems"));
        }catch (Exception e){
            currentItems=0;
        }
        AddFragment();
        IintUI();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 跳转首页或者其他操作
        try {
            currentItems = Integer.parseInt(intent.getStringExtra("currentItems"));
        }catch (Exception e){
            currentItems=0;
        }
        home_bottombarly.setCurrentItem(currentItems);
    }

    private void AddFragment() {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        homeFragment.setArguments(bundle);
        mFragmentList.add(homeFragment);
        ShopFragment shopFragment = new ShopFragment();
        Bundle bundle1 = new Bundle();
        shopFragment.setArguments(bundle1);
        mFragmentList.add(shopFragment);
        TaskFragment taskFragment=new TaskFragment();
        Bundle bundle2 = new Bundle();
        taskFragment.setArguments(bundle2);
        mFragmentList.add(taskFragment);
        ShopCartFragment shopCartFragment=new ShopCartFragment();
        Bundle bundle3 = new Bundle();
        shopCartFragment.setArguments(bundle3);
        mFragmentList.add(shopCartFragment);
        MinFragment minFragment=new MinFragment();
        Bundle bundle4 = new Bundle();
        minFragment.setArguments(bundle4);
        mFragmentList.add(minFragment);
    }

     public void SetCurrentItem(int items){
         home_bottombarly.setCurrentItem(items);
     }

    private void IintUI() {
        mVpContent = findViewById(R.id.vp_content);
        home_bottombarly = findViewById(R.id.home_bottombarly);
        home_bottombarly.setSmoothScroll(true);
        mVpContent.setAdapter(new MyAdapter(getSupportFragmentManager()));
        home_bottombarly.setViewPager(mVpContent);
        home_bottombarly.setCurrentItem(currentItems);

    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
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
