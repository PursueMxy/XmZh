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
import android.widget.RelativeLayout;

import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private NoScrollListView noScrollListView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        noScrollListView = findViewById(R.id.order_detail_noScrollListView);
        findViewById(R.id.order_detail_rl_logistics).setOnClickListener(this);
        findViewById(R.id.order_detail_img_back).setOnClickListener(this);
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_detail_rl_logistics:
                Intent intent = new Intent(mContext, LogisticsDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.order_detail_img_back:
                finish();
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

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 3;
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
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_goods, null);
            return inflate;
        }
    }
}
