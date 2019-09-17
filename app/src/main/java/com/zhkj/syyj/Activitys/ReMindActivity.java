package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.CustView.Wheel.ScreenInfo;
import com.zhkj.syyj.CustView.Wheel.WheelMain;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;

import java.text.ParseException;
import java.util.Calendar;

public class ReMindActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_date;
    private Context mContext;
    private View timepickerview;
    private TextView tv_time;
    private TextView tv_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_mind);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.remind_img_back).setOnClickListener(this);
        tv_date = findViewById(R.id.re_mind_tv_date);
        tv_date.setOnClickListener(this);
        tv_time = findViewById(R.id.re_mind_tv_time);
        tv_time.setOnClickListener(this);
        tv_connect = findViewById(R.id.re_mind_tv_connect);
        findViewById(R.id.re_mind_btn_define).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.remind_img_back:
                finish();
                break;
            case R.id.re_mind_tv_date:
                timepickerview = LayoutInflater.from(mContext).inflate(R.layout.timepicker, null);
                final WheelMain wheelMain = new WheelMain(timepickerview,false);
                ScreenInfo screenInfo = new ScreenInfo(ReMindActivity.this);
                wheelMain.screenheight = screenInfo.getHeight();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                wheelMain.initDateTimePicker(year, month, day,0,0);
                AlertDialog.Builder dialog = new AlertDialog.Builder(ReMindActivity.this)
                        .setTitle("请选择日期")
                        .setView(timepickerview)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String time = wheelMain.getDate();
                                tv_date.setText(time);
                                Log.e("当前时间",time);

                            }
                        });
                dialog.show();
                break;
            case R.id.re_mind_tv_time:
                timepickerview = LayoutInflater.from(mContext).inflate(R.layout.timepicker, null);
                final WheelMain wheelMain1 = new WheelMain(timepickerview,true);
                ScreenInfo screenInfo1 = new ScreenInfo(ReMindActivity.this);
                wheelMain1.screenheight = screenInfo1.getHeight();
                Calendar calendar1 = Calendar.getInstance();
                int year1 = calendar1.get(Calendar.YEAR);
                int month1= calendar1.get(Calendar.MONTH);
                int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
                int hour= calendar1.get(Calendar.HOUR_OF_DAY);
                int minute = calendar1.get(Calendar.MINUTE);
                wheelMain1.initDateTimePicker(year1, month1, day1,hour,minute,0);
                AlertDialog.Builder dialog1 = new AlertDialog.Builder(ReMindActivity.this)
                        .setTitle("请选择日期")
                        .setView(timepickerview)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String time = wheelMain1.getTime();
                                tv_time.setText(time);
                                Log.e("当前时间",time);

                            }
                        });
                dialog1.show();
                break;
            case R.id.re_mind_btn_define:
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
