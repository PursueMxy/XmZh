package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.zhkj.syyj.R;

public class LogisticsDetailActivity extends AppCompatActivity {

    private ListView list_view;
    private Context mContext;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_detail);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        list_view = findViewById(R.id.logistics_detail_list);
        myAdapter = new MyAdapter();
        list_view.setAdapter(myAdapter);
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
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_logistics_detail, null);
            return inflate;
        }
    }
}
