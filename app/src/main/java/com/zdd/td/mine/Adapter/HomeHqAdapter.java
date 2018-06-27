package com.zdd.td.mine.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;

import java.util.List;

import com.zdd.td.mine.models.HomeHqModel;

/**
 * Created by zhudongdong on 2018/5/25.
 */

public class HomeHqAdapter extends RecyclerView.Adapter <HomeHqAdapter.HqViewHolder>{

    private List<HomeHqModel> mList;

    public HomeHqAdapter(List<HomeHqModel> list){
        mList = list;
    }
    @Override
    public HomeHqAdapter.HqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_hq_recycleview_item, parent,false);
        HqViewHolder viewHolder = new HqViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeHqAdapter.HqViewHolder holder, int position) {

        HomeHqModel hqModel = mList.get(position);
        holder.tvName.setText(hqModel.getName());
        holder.tvPrice.setText(hqModel.getPrice());
        holder.tvCount.setText(hqModel.getCount());
        holder.tvPercent.setText(hqModel.getPercent());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    static class HqViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvPrice;
        TextView tvCount;
        TextView tvPercent;

        public HqViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvPercent = itemView.findViewById(R.id.tv_percent);
            tvCount = itemView.findViewById(R.id.tv_count);
        }
    }

}


