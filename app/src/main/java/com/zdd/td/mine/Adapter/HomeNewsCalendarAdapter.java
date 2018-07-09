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
import com.zdd.td.mine.models.HomeNewsCalendarModel;

import java.util.List;

/**
 * Created by zhudongdong on 2018/7/6.
 */

public class HomeNewsCalendarAdapter extends ArrayAdapter<HomeNewsCalendarModel> {
    private final int resourceID;
    public HomeNewsCalendarAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceID = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(resourceID, parent, false);

        TextView tv_time = v.findViewById(R.id.tv_time);
        TextView tv_content = v.findViewById(R.id.tv_content);
        TextView tv_value_pre = v.findViewById(R.id.tv_value_pre);
        TextView tv_value_yuqi = v.findViewById(R.id.tv_value_yuqi);
        TextView tv_value_gongbu = v.findViewById(R.id.tv_value_gongbu);

        HomeNewsCalendarModel model = getItem(position);
        tv_time.setText(model.getTime());
        tv_content.setText(model.getTitle());
        tv_value_pre.setText(model.getValue_pre());
        tv_value_yuqi.setText(model.getValue_yuqi());
        tv_value_gongbu.setText(model.getValue_gongbu());
        return v;
    }
}
