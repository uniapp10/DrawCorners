package com.zdd.td.mine.customViews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;

import com.zdd.td.mine.Adapter.HomeNewsRecyclerViewAdapter;
import com.zdd.td.mine.models.HomeNewsModel;

/**
 * Created by zhudongdong on 2018/5/28.
 */

public class HomeNewsView extends LinearLayout {

    public HomeNewsView(Context context) {
        this(context, null);
    }

    public HomeNewsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView(context);
    }

    private void initView(Context context) {
//        ListView listView = new ListView(context);
//        LinearLayout.LayoutParams layoutParams = (LayoutParams)listView.getLayoutParams();
////        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
////        layoutParams.width = LayoutParams.MATCH_PARENT;
//        addView(listView);
//        HomeNewsAdapter newsAdapter = new HomeNewsAdapter(context, R.layout.home_news_item, newsList);
//        listView.setAdapter(newsAdapter);
        ArrayList newsList = new ArrayList();
        HomeNewsModel model = new HomeNewsModel("早评","05-29 10:30", "http://www.fengup.com/uploads/allimg/170330/2_170330173950_1.jpg");
        HomeNewsModel model1 = new HomeNewsModel("中评","05-29 1:30", "http://www.fengup.com/uploads/allimg/170330/2_170330173950_1.jpg");
        HomeNewsModel model2 = new HomeNewsModel("早评","05-29 10:30", "http://www.fengup.com/uploads/allimg/170330/2_170330173950_1.jpg");
        newsList.add(model);
        newsList.add(model1);
        newsList.add(model2);
        RecyclerView recyclerView = new RecyclerView(context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        HomeNewsRecyclerViewAdapter homeNewsRecyclerViewAdapter = new HomeNewsRecyclerViewAdapter(context, newsList);
        recyclerView.setAdapter(homeNewsRecyclerViewAdapter);
        addView(recyclerView);
    }
}
