package com.zdd.td.mine.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;

import java.util.List;

import com.zdd.td.mine.Interface.HomeHqItemListener;
import com.zdd.td.mine.models.HomeHqModel;

/**
 * Created by zhudongdong on 2018/5/25.
 */

public class HomeHqAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{

    final int typeHq = 100;
    final int typeAdd = 200;

    private List<HomeHqModel> mList;
    HomeHqItemListener homeHqItemListener = null;

    public HomeHqAdapter(List<HomeHqModel> list1, HomeHqItemListener homeHqItemListener){
        mList = list1;
        this.homeHqItemListener = homeHqItemListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        HqViewHolder viewHolder = new HqViewHolder(view);

//        return viewHolder;

        if (viewType == typeHq){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_hq_recycleview_item, parent,false);
            return new HqViewHolder(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_hq_recycleview_add, parent,false);
            return new AddViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof HqViewHolder){
            HqViewHolder holder_hq = (HqViewHolder)holder;
            HomeHqModel hqModel = mList.get(position);
            holder_hq.tvName.setText(hqModel.getName());
            holder_hq.tvPrice.setText(hqModel.getPrice());
            holder_hq.tvCount.setText(hqModel.getCount());
            holder_hq.tvPercent.setText(hqModel.getPercent());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeHqItemListener.onItemClick(position, holder.itemView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position != mList.size()){
            return typeHq;
        }else {
            return typeAdd;
        }
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

    static class AddViewHolder extends RecyclerView.ViewHolder{

        public AddViewHolder(View itemView) {
            super(itemView);
        }
    }

}


