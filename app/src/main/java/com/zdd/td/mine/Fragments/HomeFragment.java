package com.zdd.td.mine.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.R;

import java.util.ArrayList;
import java.util.List;

import com.zdd.td.mine.Activity.HomeNewsActivity;
import com.zdd.td.mine.Activity.HomeNewsServiceActivity;
import com.zdd.td.mine.Activity.HomeNewsWebActivity;
import com.zdd.td.mine.Adapter.HomeAnalysisAdapter;
import com.zdd.td.mine.Interface.HomeBottomRecyclerViewListener;
import com.zdd.td.mine.Interface.HomeHqZiXuanListener;
import com.zdd.td.mine.customViews.CycleViewPager;
import com.zdd.td.mine.customViews.HomeHqView;
import com.zdd.td.mine.customViews.Info;
import com.zdd.td.mine.models.HomeAnalysisModel;

/**
 * Created by zhudongdong on 2018/5/8.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{

    List<Info> mList = new ArrayList<>();
    CycleViewPager mCycleViewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container,false);
        initData();
        initView(v);
        return v;
    }

    private void initData() {
        mList.add(new Info("标题1", "http://img2.3lian.com/2014/c7/25/d/40.jpg"));
        mList.add(new Info("标题2", "http://img2.3lian.com/2014/c7/25/d/41.jpg"));
        mList.add(new Info("标题3", "http://imgsrc.baidu.com/forum/pic/item/b64543a98226cffc8872e00cb9014a90f603ea30.jpg"));
        mList.add(new Info("标题4", "http://imgsrc.baidu.com/forum/pic/item/261bee0a19d8bc3e6db92913828ba61eaad345d4.jpg"));
    }

    private void initView(View view) {

        mCycleViewPager = view.findViewById(R.id.cycle_view);
        assert  mCycleViewPager != null;
        mCycleViewPager.setIndicators(R.mipmap.ad_select, R.mipmap.ad_unselect);
        mCycleViewPager.setDelay(2000);
        mCycleViewPager.setData(mList, mImageCycleViewListener);

        RecyclerView recyclerView = view.findViewById(R.id.recycleView_bottom);
        HomeAnalysisModel analysisModel = new HomeAnalysisModel("http://img2.3lian.com/2014/c7/25/d/40.jpg","帅",
                "4 月 10 5:10","股市大涨1000点");
        HomeAnalysisModel analysisModel1 = new HomeAnalysisModel("http://img2.3lian.com/2014/c7/25/d/40.jpg","帅",
                "4 月 10 5:10","股市大涨1000点");
        HomeAnalysisModel analysisModel2 = new HomeAnalysisModel("http://img2.3lian.com/2014/c7/25/d/40.jpg","帅",
                "4 月 10 5:10","股市大涨1000点");
        List list = new ArrayList<HomeAnalysisModel>();
        list.add(analysisModel);
        list.add(analysisModel1);
        list.add(analysisModel2);

        HomeAnalysisAdapter homeAnalysisAdapter = new HomeAnalysisAdapter(view.getContext(), list, new HomeBottomRecyclerViewListener() {
            @Override
            public void onClick(HomeAnalysisModel model, int index) {
                HomeNewsWebActivity.startActivity(getContext(), model);
            }
        });
        //TODO为什么加 Manager ?
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeAnalysisAdapter);
        initListener(view);
    }

    public void addZiXuanListener(HomeHqZiXuanListener listener){
        hqZiXuanListener = listener;
    }

    private HomeHqZiXuanListener hqZiXuanListener;

    private void initListener(View v) {
        HomeHqView hqView = v.findViewById(R.id.home_hq_view);
        hqView.addZiXuanListener(new HomeHqZiXuanListener() {
            @Override
            public void onClick() {
                if (hqZiXuanListener!=null){
                    hqZiXuanListener.onClick();
                }
            }
        });

        TextView tv_news = v.findViewById(R.id.tv_news);
        TextView tv_calendar = v.findViewById(R.id.tv_calendar);
        TextView tv_analysis = v.findViewById(R.id.tv_analysis);
        TextView tv_service = v.findViewById(R.id.tv_service);
        tv_news.setOnClickListener(this);
        tv_calendar.setOnClickListener(this);
        tv_analysis.setOnClickListener(this);
        tv_service.setOnClickListener(this);
    }

    private CycleViewPager.ImageCycleViewListener mImageCycleViewListener = new CycleViewPager.ImageCycleViewListener() {
        @Override
        public void onImageClick(Info info, int postion, View ImageView) {
            if (mCycleViewPager.isCycle()){
                postion = postion - 1;
            }
            Toast.makeText(getContext(), info.getTitle() , Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        int vID = v.getId();
        switch (vID){
            case R.id.tv_news:
                HomeNewsActivity.start(getContext(),0);
                break;
            case R.id.tv_calendar:
                HomeNewsActivity.start(getContext(),1);
                break;
            case R.id.tv_analysis:
                HomeNewsActivity.start(getContext(),2);
                break;
            case R.id.tv_service:
                HomeNewsServiceActivity.start(getContext());
                break;
        }
    }
}
