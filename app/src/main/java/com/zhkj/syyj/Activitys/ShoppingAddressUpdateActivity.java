package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhkj.syyj.Region.Config;
import com.zhkj.syyj.Region.PopupU;

public class ShoppingAddressUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private TextView tv_city;
    private int mType;
    private String selectedProvince;
    private String selectedCity;
    private String selectedArea;
    private EditText edt_zipcode;
    private EditText edt_deladdress;
    private EditText edt_mobile;
    private EditText edt_consignee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_address_update);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.shopping_address_update_img_back).setOnClickListener(this);
        tv_city = findViewById(R.id.shopping_address_up_tv_city);
        tv_city.setOnClickListener(this);
        findViewById(R.id.shopping_address_update_btn_confirm).setOnClickListener(this);
        edt_consignee = findViewById(R.id.shopping_address_update_edt_consignee);
        edt_mobile = findViewById(R.id.shopping_address_update_edt_mobile);
        edt_deladdress = findViewById(R.id.shopping_address_update_edt_deladdress);
        edt_zipcode = findViewById(R.id.shopping_address_update_edt_zipcode);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shopping_address_update_img_back:
                finish();
                break;
            case R.id.shopping_address_up_tv_city:
                checkType();

                PopupU.showRegionView(ShoppingAddressUpdateActivity.this, mType, selectedProvince, selectedCity, selectedArea, new PopupU.OnRegionListener() {
                    @Override
                    public void onRegionListener(String province, String city, String area) {
                        // 选择完回调结果赋值给当前
                        selectedProvince = province;
                        selectedCity = city;
                        selectedArea = area;

                        tv_city.setText(selectedProvince + " " + selectedCity + " " + selectedArea);

                    }
                });
                break;
            case R.id.shopping_address_update_btn_confirm:
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
