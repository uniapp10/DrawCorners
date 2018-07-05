package com.zdd.td.mine.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;
import com.zdd.td.mine.models.HomeNewsKuaiXunModel;

import java.util.List;

/**
 * Created by zhudongdong on 2018/7/5.
 */

public class HomeNewsKuaiXunAdapter extends ArrayAdapter <HomeNewsKuaiXunModel> {

    private int resourceID;
    public HomeNewsKuaiXunAdapter(@NonNull Context context, int resource, @NonNull List<HomeNewsKuaiXunModel> objects) {
        super(context, resource, objects);
        this.resourceID = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resourceID, parent, false);

        TextView tv_time = view.findViewById(R.id.tv_time);
        TextView tv_content = view.findViewById(R.id.tv_content);
        HomeNewsKuaiXunModel kuaiXunModel = getItem(position);
        tv_time.setText(kuaiXunModel.getTime());
        tv_content.setText(kuaiXunModel.getContent());

        return view;
    }

}
