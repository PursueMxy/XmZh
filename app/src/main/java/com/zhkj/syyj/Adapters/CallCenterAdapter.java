package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhkj.syyj.R;

import java.util.List;

public class CallCenterAdapter extends RecyclerView.Adapter<CallCenterAdapter.MyViewHolder> {
    private Context context;
    private View view;
    private List<String> ages;

    public CallCenterAdapter(Context context, List<String> message){
        this.context = context;
        ages=message;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.list_call_center,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       if (position%2==0){
           holder.rl_left.setVisibility(View.VISIBLE);
           holder.rl_right.setVisibility(View.GONE);
       }else {
           holder.rl_left.setVisibility(View.GONE);
           holder.rl_right.setVisibility(View.VISIBLE);
       }
    }

    @Override
    public int getItemCount() {
        return ages.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private final RelativeLayout rl_left;
        private final RelativeLayout rl_right;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rl_left = itemView.findViewById(R.id.list_callcenter_left);
            rl_right = itemView.findViewById(R.id.list_callcenter_right);
        }
    }
}
