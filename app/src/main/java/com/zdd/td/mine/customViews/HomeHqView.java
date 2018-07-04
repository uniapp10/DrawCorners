package com.zdd.td.mine.customViews;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.R;

import java.util.ArrayList;

import com.zdd.td.mine.Adapter.HomeHqAdapter;
import com.zdd.td.mine.Fragments.MineActivity.MineProductDetailActivity;
import com.zdd.td.mine.Interface.HomeHqItemListener;
import com.zdd.td.mine.Interface.HomeHqZiXuanListener;
import com.zdd.td.mine.models.HomeHqModel;

/**
 * Created by zhudongdong on 2018/5/25.
 */

public class HomeHqView extends RelativeLayout implements HomeHqItemListener {

    private HomeHqZiXuanListener zixuanListener;

    private RecyclerView mRecycleView;
    private HomeHqAdapter homeHqAdapter;
    private ArrayList<HomeHqModel> listHq = null;

    public HomeHqView(Context context) {
        this(context, null);
    }

    public HomeHqView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();

    }

    private void initView() {
        addView(LayoutInflater.from(getContext()).inflate(R.layout.home_hq, this, false));

        mRecycleView = findViewById(R.id.home_hq_rv);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(lm);

        final ArrayList list = new ArrayList();
        listHq = list;
        HomeHqModel hqModel1 = new HomeHqModel("黄金延期", "111", "11","11");
        HomeHqModel hqModel2 = new HomeHqModel("迷你黄金延期", "222", "11","11");
        HomeHqModel hqModel3 = new HomeHqModel("白银延期", "333", "11","11");

        for (int i = 0; i < 3; i++) {
            list.add(hqModel1);
            list.add(hqModel2);
            list.add(hqModel3);
        }

        homeHqAdapter = new HomeHqAdapter(list, this);
        mRecycleView.setAdapter(homeHqAdapter);
    }


    @Override
    public void onItemClick(int pos, View v) {
        if (pos < listHq.size()){
            HomeHqModel hqModel1 = listHq.get(pos);
//            Toast.makeText(getContext(), hqModel1.getName(), Toast.LENGTH_SHORT).show();
            MineProductDetailActivity.start(getContext(), hqModel1);
        }else {
            this.zixuanListener.onClick();
        }
    }

    public void addZiXuanListener(HomeHqZiXuanListener listener) {
        this.zixuanListener = listener;
    }
}
