package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.MainActivity;
import com.example.zhudongdong.drawcorners.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Adapter.HomeAnalysisAdapter;
import customViews.CycleViewPager;
import customViews.Info;
import models.HomeAnalysisModel;

/**
 * Created by zhudongdong on 2018/5/8.
 */

public class HomeFragment extends Fragment {

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

        HomeAnalysisAdapter homeAnalysisAdapter = new HomeAnalysisAdapter(view.getContext(), list);
        //TODO为什么加 Manager ?
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeAnalysisAdapter);
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
}
