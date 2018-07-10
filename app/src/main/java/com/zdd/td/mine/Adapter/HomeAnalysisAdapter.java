package com.zdd.td.mine.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import com.zdd.td.mine.Interface.HomeBottomRecyclerViewListener;
import com.zdd.td.mine.models.HomeAnalysisModel;

/**
 * Created by zhudongdong on 2018/5/29.
 */

public class HomeAnalysisAdapter extends RecyclerView.Adapter <HomeAnalysisAdapter.HomeViewHolder>{

    private List<HomeAnalysisModel> homeAnalysisModelList;
    private Context context;
    private HomeBottomRecyclerViewListener mlistener;
    public HomeAnalysisAdapter(Context context , List<HomeAnalysisModel> homeAnalysisModelList, HomeBottomRecyclerViewListener listener){
        this.context = context;
        this.homeAnalysisModelList = homeAnalysisModelList;
        mlistener = listener;
    }
    @Override
    public HomeAnalysisAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(this.context).inflate(R.layout.home_analysis_item, parent, false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(view);
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, final int position) {
        final HomeAnalysisModel homeAnalysisModel = homeAnalysisModelList.get(position);

        Picasso.with(this.context).load(homeAnalysisModel.getIconUrl()).into(holder.circleImageView);
        holder.tv_name.setText(homeAnalysisModel.getName());
        holder.tv_time.setText(homeAnalysisModel.getTime());
        holder.tv_content.setText(homeAnalysisModel.getContent());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onClick(homeAnalysisModel, position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return homeAnalysisModelList.size();
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder{

        CircleImageView circleImageView;
        TextView tv_name;
        TextView tv_time;
        TextView tv_content;

        public HomeViewHolder(View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.home_analysis_icon);
            tv_name = itemView.findViewById(R.id.home_analysis_name);
            tv_time = itemView.findViewById(R.id.home_analysis_time);
            tv_content = itemView.findViewById(R.id.home_analysis_content);
        }
    }
}
