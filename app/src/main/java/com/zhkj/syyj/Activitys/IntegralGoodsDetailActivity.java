package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.GridAdapter;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class IntegralGoodsDetailActivity extends AppCompatActivity {

  @InjectView(R.id.integral_detail_goods_noScrollListView)
    NoScrollListView noScrollListView;
    private Context mContext;
    private MyAdapter myAdapter;
    private GridView gridView;
    private ArrayList<Map<String, Object>> dataList;
    public int SelectNum=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_goods_detail);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
        InitUI();
    }

    private void InitUI() {
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
    }


    @OnClick({R.id.integral_detail_goods_img_back,R.id.integral_btn_redeem_now})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.integral_detail_goods_img_back:
                finish();
                break;
            case R.id.integral_btn_redeem_now:
                RedeemNowDialog();
                break;
            default:
                break;
        }
    }

    //立即兑换弹出窗
    public void  RedeemNowDialog(){
        final BottomDialog bottomDialog = new BottomDialog(this, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_integral_detail, null);
       final TextView tv_select_num = inflate.findViewById(R.id.db_integral_dtl_tv_select_num);
       final TextView tv_selectedNum = inflate.findViewById(R.id.db_integral_dtl_tv_selectedNum);
        inflate.findViewById(R.id.db_integral_dtl_btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                startActivity(new Intent(mContext,PlaceOrderIntegralActivity.class));
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_img_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_tv_lesson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (SelectNum>1){
                SelectNum=--SelectNum;
                tv_select_num.setText(SelectNum+"");
                tv_selectedNum.setText("已选10ml"+SelectNum);
            }else {
                ToastUtils.showToast(mContext,"换购数量不能小于1");
            }
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectNum=++SelectNum;
                tv_select_num.setText(SelectNum+"");
                tv_selectedNum.setText("已选10ml,"+SelectNum);
            }
        });
        dataList = new ArrayList<Map<String, Object>>();
        String name[]={"10ml","20ml","30ml","40ml","50ml","60ml","70ml"};
        for (int i = 0; i <name.length; i++) {
            Map<String, Object> map=new HashMap<>();
            map.put("text",name[i]);
            dataList.add(map);
        }
        GridAdapter gridAdapter = new GridAdapter(mContext, dataList);
        gridView = inflate.findViewById(R.id.db_integral_dtl_gridView);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String text =(String) dataList.get(position).get("text");
                tv_selectedNum.setText("已选"+text+","+SelectNum);
            }
        });
        bottomDialog.setContentView(inflate);
        bottomDialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_integral_detail_img, null);
            return inflate;
        }
    }
}
