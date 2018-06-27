package com.zdd.td.mine.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import com.zdd.td.mine.models.HomeNewsModel;

/**
 * Created by zhudongdong on 2018/5/30.
 */

public class HomeNewsRecyclerViewAdapter extends RecyclerView.Adapter<HomeNewsRecyclerViewAdapter.HomeAnalysisHolder> {
    private List<HomeNewsModel> mList;
    private Context mContext;

    public HomeNewsRecyclerViewAdapter( Context context, List<HomeNewsModel> list){
        mList = list;
        mContext = context;
    }
    @Override
    public HomeAnalysisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_news_item, parent, false);
        HomeAnalysisHolder analysisHolder = new HomeAnalysisHolder(view);
        return analysisHolder;
    }

    @Override
    public void onBindViewHolder(HomeAnalysisHolder holder, int position) {

        HomeNewsModel homeNewsModel = mList.get(position);
        holder.tv_title.setText(homeNewsModel.getTitle());
        holder.tv_subTitle.setText(homeNewsModel.getTime());
        Picasso.with(mContext).load(homeNewsModel.getUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class HomeAnalysisHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        TextView tv_subTitle;
        ImageView iv;

        public HomeAnalysisHolder(View itemView){
            super(itemView);

            tv_title = itemView.findViewById(R.id.home_news_title);
            tv_subTitle = itemView.findViewById(R.id.home_news_time);
            iv = itemView.findViewById(R.id.home_news_image);
        }
    }

}
