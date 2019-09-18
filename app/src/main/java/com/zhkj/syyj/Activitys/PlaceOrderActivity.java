package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private NoScrollListView noScrollListView;
    private MyAdapter myAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.place_order_img_back).setOnClickListener(this);
        noScrollListView = findViewById(R.id.place_order_noScrollListView);
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.place_order_img_back:
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
