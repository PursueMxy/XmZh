package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.GridAdapter;
import com.zhkj.syyj.Beans.GoodsDetailBean;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.GoodsDetailContract;
import com.zhkj.syyj.presenter.GoodsDetailPresenter;

import org.json.JSONException;
import org.json.JSONObject;
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipFile;

public class GoodsDetailActivity extends AppCompatActivity implements View.OnClickListener, GoodsDetailContract.View {


    private MyAdapter myAdapter;
    private NoScrollListView noScrollListView;
    private Context mContext;
    public int SelectNum=1;
    private ArrayList<Map<String, Object>> dataList=new ArrayList<>();
    private GridView gridView;
    private ImageView img_appraise;
    private TextView tv_appraise_name;
    private TextView tv_appraise_content;
    private TextView tv_copywriting;
    private TextView tv_goodsTitle;
    private TextView tv_goodsMoney;
    private TextView tv_goodsVolume;
    private String goods_id;
    private String uid;
    private String token;
    private HtmlTextView tv_goods_content;
    private TextView tv_share;
    private Button tv_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        goods_id = intent.getStringExtra("goods_id");
        mContext = getApplicationContext();
        InitUI();
        GoodsDetailPresenter goodsDetailPresenter = new GoodsDetailPresenter(this);
        goodsDetailPresenter.GetGoodsDetail(uid,token,goods_id);
    }

    private void InitUI() {
        tv_goods_content = findViewById(R.id.goods_detail_tv_goods_content);
        tv_forward = findViewById(R.id.goods_detail_tv_forward);
        tv_forward.setOnClickListener(this);
        findViewById(R.id.goods_detail_img_back).setOnClickListener(this);
        findViewById(R.id.goods_img_call_center).setOnClickListener(this);
        findViewById(R.id.goods_detail_img_home).setOnClickListener(this);
        myAdapter = new MyAdapter();
        noScrollListView = findViewById(R.id.goods_detail_noScrollListView);
        noScrollListView.setAdapter(myAdapter);
        findViewById(R.id.goods_detail_tv_view_all_appraise).setOnClickListener(this);
        findViewById(R.id.goods_detail_btn_buynow).setOnClickListener(this);
        img_appraise = findViewById(R.id.goods_detail_img_appraise);
        tv_appraise_name = findViewById(R.id.goods_detail_tv_appraise_name);
        tv_appraise_content = findViewById(R.id.goods_detail_tv_appraise_content);
        tv_copywriting = findViewById(R.id.goods_detail_tv_copywriting);
        tv_goodsTitle = findViewById(R.id.goods_detail_tv_goodsTitle);
        tv_goodsMoney = findViewById(R.id.goods_detail_tv_goodsMoney);
        tv_goodsVolume = findViewById(R.id.goods_detail_tv_goodsVolume);
        tv_share = findViewById(R.id.goods_detail_tv_share);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goods_detail_img_back:
                finish();
                break;
            case R.id.goods_detail_tv_view_all_appraise:
                startActivity(new Intent(mContext,AppraiseActivity.class));
                break;
            case R.id.goods_detail_tv_forward:
                startActivity(new Intent(mContext,ForwardActivity.class));
                break;
            case R.id.goods_detail_btn_buynow:
                RedeemNowDialog();
                break;
            case R.id.goods_img_call_center:
                startActivity(new Intent(mContext,CallCenterActivity.class));
                break;
            case R.id.goods_detail_img_home:
                Intent intent = new Intent(mContext, HomeActivity.class);
                intent.putExtra("currentItems","0");
                startActivity(intent);
                break;
                default:
                    break;
        }
    }

    //立即购买弹出窗
    public void  RedeemNowDialog(){
        final BottomDialog bottomDialog = new BottomDialog(this, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_integral_detail, null);
        final TextView tv_select_num = inflate.findViewById(R.id.db_integral_dtl_tv_select_num);
        final TextView tv_selectedNum = inflate.findViewById(R.id.db_integral_dtl_tv_selectedNum);
        inflate.findViewById(R.id.db_integral_dtl_btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                startActivity(new Intent(mContext,PlaceOrderActivity.class));
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
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void UpdateUI(int code, String msg, String data){
        parseJSONWithJSONObject(data);
    }

    private void parseJSONWithJSONObject(String jsonData){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonData);
            int is_share = jsonObject.getInt("is_share");
            String goods_content = jsonObject.getString("goods_content");
            String goods_name = jsonObject.getString("goods_name");
            String shop_price = jsonObject.getString("shop_price");
            String sales_sum= jsonObject.getString("sales_sum");
            tv_goods_content.setHtml(goods_content, new HtmlHttpImageGetter(tv_goods_content));
            tv_goodsTitle.setText(goods_name);
            tv_goodsMoney.setText(shop_price);
            tv_goodsVolume.setText(sales_sum);
            if (is_share==1){
                tv_share.setText("该商品支持转发卖货");
                tv_forward.setClickable(true);
                String share_content = jsonObject.getString("share_content");
                String goods_images = jsonObject.getString("goods_images");
                tv_copywriting.setText(share_content);
            }else {
                tv_share.setText("该商品不支持转发卖货");
                tv_forward.setClickable(false);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public class MyAdapter extends BaseAdapter {
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
