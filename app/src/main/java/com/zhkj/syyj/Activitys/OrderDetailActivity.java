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
import android.widget.TextView;

import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private NoScrollListView noScrollListView;
    private MyAdapter myAdapter;
    private TextView tv_confirmTime;
    private TextView tv_coupon;
    private TextView tv_expressTime;
    private TextView tv_freight;
    private TextView tv_logistics;
    private TextView tv_orderNumber;
    private TextView tv_payType;
    private TextView tv_type;

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
        findViewById(R.id.order_detail_btn_immediate_payment).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_checkExpress).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_backOrder).setOnClickListener(this);
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
        tv_confirmTime = findViewById(R.id.order_detail_tv_confirmTime);
        tv_coupon = findViewById(R.id.order_detail_tv_coupon);
        tv_expressTime = findViewById(R.id.order_detail_tv_expressTime);
        tv_freight = findViewById(R.id.order_detail_tv_freight);
        tv_logistics = findViewById(R.id.order_detail_tv_logistics);
        tv_orderNumber = findViewById(R.id.order_detail_tv_orderNumber);
        tv_payType = findViewById(R.id.order_detail_tv_payType);
        tv_type = findViewById(R.id.order_detail_tv_type);


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
            case R.id.order_detail_btn_checkExpress:
                break;
            case R.id.order_detail_btn_backOrder:
                break;
            case R.id.order_detail_btn_immediate_payment:
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
