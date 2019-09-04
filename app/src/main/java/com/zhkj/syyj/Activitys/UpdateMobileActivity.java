package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhkj.syyj.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class UpdateMobileActivity extends AppCompatActivity {

    @InjectView(R.id.update_mobile_tv_new)
    TextView tv_new;
    @InjectView(R.id.update_mobile_tv_primary)
    TextView tv_primary;
    @InjectView(R.id.update_mobile_ll_new)
    LinearLayout ll_new;
    @InjectView(R.id.update_mobile_ll_primary)
    LinearLayout ll_primary;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mobile);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
    }
     @OnClick({R.id.update_mobile_btn_next,R.id.update_mobile_btn_confirm})
     public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.update_mobile_btn_next:
                tv_primary.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_new.setBackgroundResource(R.drawable.myorder_choosed_color);
                ll_primary.setVisibility(View.GONE);
                ll_new.setVisibility(View.VISIBLE);
                break;
            case R.id.update_mobile_btn_confirm:
                finish();
                break;
        }
     }
}
