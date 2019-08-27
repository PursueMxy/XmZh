package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.zhkj.syyj.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton img_password;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        img_password = findViewById(R.id.login_img_password);
        img_password.setOnClickListener(this);
        findViewById(R.id.login_tv_no_password).setOnClickListener(this);
        findViewById(R.id.login_btn_login).setOnClickListener(this);
        findViewById(R.id.login_btn_enroll).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_img_password:
               if (img_password.isSelected()){
                 img_password.setSelected(false);
               }else {
                   img_password.setSelected(true);
               }
                break;
            case R.id.login_tv_no_password:
                startActivity(new Intent(mContext,ReSettingActivity.class));
                break;
            case R.id.login_btn_enroll:
                startActivity(new Intent(mContext,EnrollActivity.class));
                break;
            case R.id.login_btn_login:
                startActivity(new Intent(mContext,HomeActivity.class));
                break;
                default:
                    break;
        }
    }
}
