package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.winfo.photoselector.PhotoSelector;
import com.zhkj.syyj.R;

import java.io.File;
import java.util.zip.ZipFile;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PerSonalDataActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1024;
    private Context mContext;
    @InjectView(R.id.personal_data_img_head)
    ImageView img_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_sonal_data);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
    }
    @OnClick({R.id.personal_data_tv_user,R.id.personal_data_img_back,R.id.personal_data_img_edt_head,R.id.personal_date_rl_update_mobile})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.personal_data_tv_user:
                startActivity(new Intent(mContext,UpdateUserActivity.class));
                break;
            case R.id.personal_data_img_back:
                finish();
                break;
            case R.id.personal_data_img_edt_head:
                PhotoSelector.builder()
                        .setShowCamera(true)//显示拍照
                        .setSingle(true)//单选，裁剪都是单选
                        .setCrop(true)//是否裁剪
                        .setCropMode(PhotoSelector.CROP_CIRCLE)//设置裁剪模式 矩形还是圆形
                        .setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .setToolBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .setBottomBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .start(this,REQUEST_CODE);
                break;
            case R.id.personal_date_rl_update_mobile:
                startActivity(new Intent(mContext,UpdateMobileActivity.class));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==-1){
            switch (requestCode){
                case REQUEST_CODE:
                    //获取到裁剪后的图片的Uri进行处理
                    Uri resultUri = PhotoSelector.getCropImageUri(data);
                    Glide.with(this).load(resultUri).into(img_head);
                    Uri uri = data.getData();
                    String path = uri.getPath();
                    break;
                default:
                    break;
            }
        }
    }
}
