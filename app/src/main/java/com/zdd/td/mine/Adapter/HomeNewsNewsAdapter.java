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
import com.zdd.td.mine.models.HomeNewsCalendarModel;
import com.zdd.td.mine.models.HomeNewsNewsModel;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by zhudongdong on 2018/7/6.
 */

public class HomeNewsNewsAdapter extends RecyclerView.Adapter <HomeNewsNewsAdapter.HomeNewsNewsAdapterHolder> {

    private List<HomeNewsNewsModel> list;
    private Context mcontext;

    public HomeNewsNewsAdapter(List<HomeNewsNewsModel> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @Override
    public HomeNewsNewsAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(mcontext).inflate(R.layout.home_news_news_item, parent, false);
       HomeNewsNewsAdapterHolder holder = new HomeNewsNewsAdapterHolder(view);
       return holder;
    }

    @Override
    public void onBindViewHolder(HomeNewsNewsAdapterHolder holder, int position) {
        HomeNewsNewsModel model = list.get(position);
        holder.tv_time.setText(model.getTime());
        holder.tv_title.setText(model.getTitle());
        Picasso.with(mcontext).load(model.getIconUrl()).into(holder.iv_icon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class HomeNewsNewsAdapterHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        TextView tv_time;
        ImageView iv_icon;
        public HomeNewsNewsAdapterHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_icon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
