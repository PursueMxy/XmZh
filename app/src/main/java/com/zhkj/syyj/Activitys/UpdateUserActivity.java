package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.winfo.photoselector.PhotoSelector;
import com.zhkj.syyj.CustView.Wheel.ScreenInfo;
import com.zhkj.syyj.CustView.Wheel.WheelMain;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Region.Config;
import com.zhkj.syyj.Region.PopupU;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.zip.ZipFile;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class UpdateUserActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1024;
    @InjectView(R.id.update_user_img_head)
     ImageView img_head;
    @InjectView(R.id.up_user_radioGroup)
    RadioGroup radioGroup;
    @InjectView(R.id.up_user_radioBtn_man)
    RadioButton radiobtn_man;
    @InjectView(R.id.up_user_radioBtn_girl)
    RadioButton radiobtn_girl;
    @InjectView(R.id.up_user_edt_userId)
    EditText edt_userId;
    @InjectView(R.id.up_user_edt_userName)
    EditText edt_userName;
    @InjectView(R.id.up_user_tv_address)
    TextView tv_address;
    @InjectView(R.id.up_user_edt_vocation)
    EditText edt_vocation;
    @InjectView(R.id.up_user_edt_wechatNumber)
    EditText edt_wechatNumber;
    @InjectView(R.id.up_user_tv_birthday)
    TextView tv_birthday;

    private Context mContext;
    private ArrayList<String> images=new ArrayList<>();
    private View timepickerview;
    private int mType;
    private String selectedProvince;
    private String selectedCity;
    private String selectedArea;
    private String token;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
        InitUI();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
    }

    private void InitUI() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==radiobtn_man.getId()){
                    System.out.println("选中了female!");
                }else if (checkedId==radiobtn_girl.getId()){
                    System.out.println("选中了male!");
                }
            }
        });
    }

    @OnClick({R.id.update_user_img_head,R.id.update_user_img_back,R.id.up_user_tv_birthday,R.id.up_user_tv_address,R.id.update_user_tv_confirm})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.update_user_img_head:
                //单选后剪裁 裁剪的话都是针对一张图片所以要设置setSingle(true)
                PhotoSelector.builder()
                        .setShowCamera(true)//显示拍照
                        .setSingle(true)//单选，裁剪都是单选
                        .setCrop(true)//是否裁剪
                        .setCropMode(PhotoSelector.CROP_RECTANG)//设置裁剪模式 矩形还是圆形
                        .setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .setToolBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .setBottomBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .start(this,REQUEST_CODE);
                break;
             case  R.id.update_user_img_back:
                 finish();
             break;
            case R.id.up_user_tv_birthday:
                timepickerview = LayoutInflater.from(mContext).inflate(R.layout.timepicker, null);
                final WheelMain wheelMain = new WheelMain(timepickerview,false);
                wheelMain.setSTART_YEAR(1900);
                ScreenInfo screenInfo = new ScreenInfo(UpdateUserActivity.this);
                wheelMain.screenheight = screenInfo.getHeight();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month= calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                wheelMain.setEND_YEAR(year);
                wheelMain.initDateTimePicker(year, month, day,0,0);
                AlertDialog.Builder dialog = new AlertDialog.Builder(UpdateUserActivity.this)
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
                                tv_birthday.setText(time);
                                Log.e("当前时间",time);

                            }
                        });
                dialog.show();
                break;
            case R.id.up_user_tv_address:
                checkType();
                PopupU.showRegionView(UpdateUserActivity.this, mType, selectedProvince, selectedCity, selectedArea, new PopupU.OnRegionListener() {
                    @Override
                    public void onRegionListener(String province, String city, String area) {
                        // 选择完回调结果赋值给当前
                        selectedProvince = province;
                        selectedCity = city;
                        selectedArea = area;

                        tv_address.setText(selectedProvince + " " + selectedCity + " " + selectedArea);

                    }
                });
                break;
            case R.id.update_user_tv_confirm:
                String userId= edt_userId.getText().toString();
                String userName= edt_userName.getText().toString();
                String vocation = edt_vocation.getText().toString();
                String wechatNumber = edt_wechatNumber.getText().toString();
                break;
                default:
                    break;
        }
    }

    private void checkType() {
        if (TextUtils.isEmpty(selectedProvince) && TextUtils.isEmpty(selectedCity) && TextUtils.isEmpty(selectedArea)) {
            mType = Config.TYPE_ADD;
        } else {
            mType = Config.TYPE_EDIT;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==-1){
            switch (requestCode){
                case REQUEST_CODE:
                    //获取到裁剪后的图片的Uri进行处理
                    Uri resultUri = PhotoSelector.getCropImageUri(data);
                    Glide.with(this).load(resultUri).into(img_head);
                    break;
                    default:
                        break;
            }
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
