package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhkj.syyj.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerSonalDataActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_sonal_data);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
    }
    @OnClick({R.id.personal_data_tv_user})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.personal_data_tv_user:
                startActivity(new Intent(mContext,UpdateUserActivity.class));
                break;
                default:
                    break;
        }
    }
}
