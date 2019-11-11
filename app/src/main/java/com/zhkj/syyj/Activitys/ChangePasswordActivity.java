package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zhkj.syyj.R;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.change_psw_tv_complete).setOnClickListener(this);
        findViewById(R.id.change_psw_img_back).setOnClickListener(this);
        EditText edt_oldPass = findViewById(R.id.change_psw_edt_oldPass);
        EditText edt_password= findViewById(R.id.change_psw_edt_password);
        EditText edt_affirm_password = findViewById(R.id.change_psw_edt_affirm_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_psw_tv_complete:
                break;
            case R.id.change_psw_img_back:
                finish();
                break;
        }
    }
}
