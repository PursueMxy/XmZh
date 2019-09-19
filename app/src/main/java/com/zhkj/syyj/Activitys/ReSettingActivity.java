package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.zhkj.syyj.R;

public class ReSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_mobile;
    private EditText edt_password;
    private EditText edt_define_password;
    private EditText edt_verification_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_setting);
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.re_setting_btn_login).setOnClickListener(this);
        findViewById(R.id.re_setting_send_verification_code).setOnClickListener(this);
        edt_mobile = findViewById(R.id.re_setting_edt_mobile);
        edt_password = findViewById(R.id.re_setting_edt_password);
        edt_define_password = findViewById(R.id.re_setting_edt_define_password);
        edt_verification_code = findViewById(R.id.re_setting_edt_verification_code);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.re_setting_btn_login:
                finish();
                break;
            case R.id.re_setting_send_verification_code:
                break;
                default:
                    break;
        }
    }
}
