package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.zhkj.syyj.R;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
      findViewById(R.id.order_detail_rl_logistics).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_detail_rl_logistics:
                Intent intent = new Intent(mContext, LogisticsDetailActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
