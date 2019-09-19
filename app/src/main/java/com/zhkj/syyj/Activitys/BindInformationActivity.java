package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.winfo.photoselector.PhotoSelector;
import com.zhkj.syyj.R;

public class BindInformationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_mobile;
    private EditText edt_verification_code;
    private EditText edt_password;
    private EditText edt_define_password;
    private ImageView img_add;
    private ImageView img_detail;
    private static final int REQUEST_CODE = 2001;
    private EditText edt_invite_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_information);
        InitUI();
    }

    private void InitUI() {
        edt_mobile = findViewById(R.id.bind_information_edt_mobile);
        edt_verification_code = findViewById(R.id.bind_information_edt_verification_code);
         findViewById(R.id.bind_information_tv_send_verification_code).setOnClickListener(this);
        edt_password = findViewById(R.id.bind_information_edt_password);
        edt_define_password = findViewById(R.id.bind_information_edt_define_password);
        edt_invite_code = findViewById(R.id.bind_information_edt_invite_code);
        img_add = findViewById(R.id.bind_information_img_add);
        img_detail = findViewById(R.id.bind_information_img_detail);
        img_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bind_information_tv_send_verification_code:
                break;
            case R.id.bind_information_img_add:
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
                default:
                    break;
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
                    Glide.with(this).load(resultUri).into(img_add);
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
