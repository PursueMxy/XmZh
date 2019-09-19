package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private NoScrollListView noScrollListView;
    private MyAdapter myAdapter;
    private Context mContext;
    private TextView tv_price;
    private TextView tv_freight;
    private TextView tv_coupon;
    private TextView viewById;
    private TextView tv_contacts;
    private TextView tv_address;
    private CheckBox cb_aliPay;
    private CheckBox cb_wechatPay;
    private CheckBox cb_balancePay;

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
        tv_address = findViewById(R.id.place_order_tv_address);
        tv_contacts = findViewById(R.id.place_order_tv_contacts);
        viewById = findViewById(R.id.place_order_tv_coupon);
        tv_coupon = findViewById(R.id.place_order_tv_freight);
        tv_freight = findViewById(R.id.place_order_tv_message);
        tv_price = findViewById(R.id.place_order_tv_price);
        cb_aliPay = findViewById(R.id.place_order_cb_aliPay);
        cb_wechatPay = findViewById(R.id.place_order_cb_wechatPay);
        cb_balancePay = findViewById(R.id.place_order_cb_balancePay);
        cb_aliPay.setOnClickListener(this);
        cb_balancePay.setOnClickListener(this);
        cb_wechatPay.setOnClickListener(this);
        findViewById(R.id.place_order_btn_immediate_payment).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.place_order_img_back:
                finish();
                break;
            case R.id.place_order_btn_immediate_payment:
                break;
            case R.id.place_order_cb_balancePay:
                if(cb_balancePay.isChecked()){
                 cb_balancePay.setChecked(true);
                 cb_aliPay.setChecked(false);
                 cb_wechatPay.setChecked(false);
                }else {
                    cb_balancePay.setChecked(false);
                    cb_aliPay.setChecked(true);
                    cb_wechatPay.setChecked(false);
                }
                break;
            case R.id.place_order_cb_aliPay:
                if(cb_aliPay.isChecked()){
                    cb_balancePay.setChecked(false);
                    cb_aliPay.setChecked(true);
                    cb_wechatPay.setChecked(false);
                }else {
                    cb_balancePay.setChecked(true);
                    cb_aliPay.setChecked(false);
                    cb_wechatPay.setChecked(false);
                }
                break;
            case R.id.place_order_cb_wechatPay:
                if(cb_wechatPay.isChecked()){
                    cb_balancePay.setChecked(false);
                    cb_aliPay.setChecked(false);
                    cb_wechatPay.setChecked(true);
                }else {
                    cb_balancePay.setChecked(true);
                    cb_aliPay.setChecked(false);
                    cb_wechatPay.setChecked(false);
                }
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
