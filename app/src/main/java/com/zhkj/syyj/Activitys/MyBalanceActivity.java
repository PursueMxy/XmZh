package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_balance);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
        btn_recharge.setOnClickListener(this);
        btn_cash_out.setOnClickListener(this);
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
}
