package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;

import butterknife.InjectView;

public class InformationChoiceDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private TextView tv_time;
    private TextView tv_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_choice_detail);
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.information_choice_detail_img_back).setOnClickListener(this);
        tv_title = findViewById(R.id.information_choice_detail_tv_title);
        tv_time = findViewById(R.id.information_choice_detail_tv_time);
        tv_connect = findViewById(R.id.information_choice_detail_tv_connect);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.information_choice_detail_img_back:
                finish();
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
}
