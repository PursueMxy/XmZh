package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.zhkj.syyj.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MyBalanceActivity extends AppCompatActivity implements View.OnClickListener {
    @InjectView(R.id.my_balance_btn_recharge)
    Button btn_recharge;
    @InjectView(R.id.my_balance_btn_cash_out)
    Button btn_cash_out;
    private Context mContext;
    private ListView balance_list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_balance);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
        btn_recharge.setOnClickListener(this);
        btn_cash_out.setOnClickListener(this);
        InitUI();
    }

    private void InitUI() {
        balance_list = findViewById(R.id.my_balance_list);
        myAdapter = new MyAdapter();
        balance_list.setAdapter(myAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_balance_btn_recharge:
                startActivity(new Intent(mContext,RechargeActivity.class));
                break;
            case R.id.my_balance_btn_cash_out:
                startActivity(new Intent(mContext,CashOutActivity.class));
                break;
                default:
                    break;
        }
    }

    public class MyAdapter extends BaseAdapter{
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
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_balance, null);
            return inflate ;
        }
    }
}
