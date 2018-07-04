package com.zdd.td.mine.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.R;

import java.util.ArrayList;

import com.zdd.td.mine.Adapter.PriceAdapter;
import com.zdd.td.mine.Interface.HomeHqZiXuanListener;
import com.zdd.td.mine.Interface.PriceItemOnClickListener;
import com.zdd.td.mine.customViews.HomeHqView;
import com.zdd.td.mine.models.PriceProductModel;

/**
 * Created by zhudongdong on 2018/5/8.
 */

public class PriceFragment extends Fragment {
    ViewPager mviewPager;

    private ImageView imageView;
    private int offset = 0;
    private int currIndex = 0;
    private int bmpW;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.price_fragment, container, false);

        mviewPager = v.findViewById(R.id.viewPager);
        bmpW = 30;
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) container.getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = screenW / 2 - bmpW;
//        Matrix matrix = new Matrix();
//        matrix.postTranslate(60, 30);

        imageView = v.findViewById(R.id.cursor);
//        imageView.setImageMatrix(matrix);

//        imageView.setTranslationX(offset/2);


        mviewPager.setOnPageChangeListener(new MyOnPageChangeListener());


//        PagerTabStrip pagerTabStrip = v.findViewById(R.id.pagertab);
//        pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.txtBlack));
//        pagerTabStrip.setDrawFullUnderline(true);
//        pagerTabStrip.setBackgroundColor(getResources().getColor(R.color.txtBlue));
//        pagerTabStrip.setTextSpacing(50);

        LayoutInflater lf = getLayoutInflater().from(container.getContext());
        View v1 = lf.inflate(R.layout.hq_custom, null);
        View v2 = lf.inflate(R.layout.hq_shanghai, null);
        RecyclerView rv1 = v1.findViewById(R.id.recycleView);
        RecyclerView rv2 = v2.findViewById(R.id.recycleView);
//        RecyclerView rv1 = v1.findViewById(R.id.recycleView);
//        v1.setBackgroundColor(R.drawable.red_bg);
//        v2.setBackgroundColor(R.drawable.title_bg);

        final ArrayList<PriceProductModel> arrayList = new ArrayList<>();
        PriceProductModel priceProductModel = new PriceProductModel("黄金延期",
                "Au(T+D)","100.0","+8.00%");
        PriceProductModel priceProductModel1 = new PriceProductModel("迷你黄金延期",
                "mAu(T+D)","80.0","+8.00%");
        PriceProductModel priceProductModel2 = new PriceProductModel("黄金延期",
                "Ag(T+D)","50","+6.00%");
        arrayList.add(priceProductModel);
        arrayList.add(priceProductModel1);
        arrayList.add(priceProductModel2);
        PriceItemOnClickListener itemOnClickListener = new PriceItemOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PriceProductModel priceProductModel =  arrayList.get(position);
                Toast.makeText(v.getContext(),"选择了" + priceProductModel.getName(), Toast.LENGTH_SHORT).show();
            }
        };

        PriceAdapter priceAdapter = new PriceAdapter(v.getContext(),arrayList, itemOnClickListener);
        LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext());
        rv1.setLayoutManager(layoutManager);
        rv1.setAdapter(priceAdapter);

        PriceAdapter priceAdapter2 = new PriceAdapter(v.getContext(),arrayList, itemOnClickListener);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(v.getContext());
        rv2.setAdapter(priceAdapter2);
        rv2.setLayoutManager(layoutManager2);
        final ArrayList<View> viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);

//        final ArrayList<String> titleList = new ArrayList<String>();
//        titleList.add("自选");
//        titleList.add("上交所");

        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

//            @Override
//            public CharSequence getPageTitle(int position) {
//                return titleList.get(position);
//            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };

        mviewPager.setAdapter(pagerAdapter);
        mviewPager.setCurrentItem(0);
        TextView tv1 = v.findViewById(R.id.tv_custom);
        TextView tv2 = v.findViewById(R.id.tv_shangjiao);

        tv1.setOnClickListener(new MyOnClickListener(0));
        tv2.setOnClickListener(new MyOnClickListener(1));

        return v;
    }

    private class MyOnClickListener implements View.OnClickListener{
        private int index;

        public MyOnClickListener(int i){
            index = i;
        }
        @Override
        public void onClick(View v) {
            mviewPager.setCurrentItem(index);
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset + bmpW;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Animation animation = new TranslateAnimation(one*currIndex, one*position + offset/2,0,0);
            currIndex = position;
            animation.setFillAfter(true);
            animation.setDuration(300);
            imageView.startAnimation(animation);
            Toast.makeText(getContext(), "选择" + mviewPager.getCurrentItem() + "页面", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
