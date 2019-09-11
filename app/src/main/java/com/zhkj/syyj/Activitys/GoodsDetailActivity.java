package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;

import java.io.File;
import java.util.zip.ZipFile;

public class GoodsDetailActivity extends AppCompatActivity implements View.OnClickListener {


    private MyAdapter myAdapter;
    private NoScrollListView noScrollListView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.goods_detail_img_back).setOnClickListener(this);
        findViewById(R.id.goods_detail_tv_forward).setOnClickListener(this);
        myAdapter = new MyAdapter();
        noScrollListView = findViewById(R.id.goods_detail_noScrollListView);
        noScrollListView.setAdapter(myAdapter);
        findViewById(R.id.goods_detail_tv_view_all_appraise).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goods_detail_img_back:
                finish();
                break;
            case R.id.goods_detail_tv_view_all_appraise:
                startActivity(new Intent(mContext,AppraiseActivity.class));
                break;
            case R.id.goods_detail_tv_forward:
                startActivity(new Intent(mContext,ForwardActivity.class));
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

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_integral_detail_img, null);
            return inflate;
        }
    }
}
