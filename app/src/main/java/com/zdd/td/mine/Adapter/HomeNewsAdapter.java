package com.zdd.td.mine.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import com.zdd.td.mine.models.HomeNewsModel;

/**
 * Created by zhudongdong on 2018/5/29.
 */

public class HomeNewsAdapter extends ArrayAdapter<HomeNewsModel> {
    private int resourceID;

    public HomeNewsAdapter(@NonNull Context context, int resource, @NonNull List<HomeNewsModel> objects) {
        super(context, resource, objects);
        this.resourceID = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resourceID, parent, false);
        TextView tv_title = view.findViewById(R.id.home_news_title);
        TextView tv_subTitle = view.findViewById(R.id.home_news_time);
        ImageView iv = view.findViewById(R.id.home_news_image);
        HomeNewsModel homeNewsModel = getItem(position);
        tv_title.setText(homeNewsModel.getTitle());
        tv_subTitle.setText(homeNewsModel.getTime());
        Picasso.with(parent.getContext()).load(homeNewsModel.getUrl()).into(iv);
//        try{
//            URL thumb_u = new URL(homeNewsModel.getUrl());
//            Drawable thumb_d = Drawable.createFromStream(thumb_u.openStream(), "src");
//            iv.setImageDrawable(thumb_d);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Uri uri = Uri.parse(homeNewsModel.getUrl());
//        iv.setImageURI(Uri.parse(homeNewsModel.getUrl()));

        return view;
    }
}
