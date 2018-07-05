package com.zdd.td.mine.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by zhudongdong on 2018/5/8.
 */

public class ServiceFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private int imgW;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_fragment, container, false);

        initView(view);
        return view;
    }

    private void initView(final View view) {
        TextView tv_jiepan = view.findViewById(R.id.service_tv_jiepan);
        TextView tv_zhibo = view.findViewById(R.id.service_tv_zhibo);
        TextView tv_liaotian = view.findViewById(R.id.service_tv_liaotian);
        ImageView iv_cursor = view.findViewById(R.id.service_iv_cursor);
        imgW = 30;

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        float px_image = imgW * (dm.xdpi/160);
        float offsetX = (screenW / 3 - px_image)/2 - px_image/2;
        iv_cursor.setTranslationX(offsetX * 160 / dm.xdpi);

        ViewPager vp = view.findViewById(R.id.service_vp);

        View v1 = LayoutInflater.from(getContext()).inflate(R.layout.service_jiepan, null);
        View v2 = LayoutInflater.from(getContext()).inflate(R.layout.service_zhibo, null);
        View v3 = LayoutInflater.from(getContext()).inflate(R.layout.service_liaotian, null);

        final ArrayList<View> views = new ArrayList<>();
        views.add(v1);
        views.add(v2);
        views.add(v3);
        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {

                Log.d(TAG, "isViewFromObject: ");
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                Log.d(TAG, "destroyItem: ");
                container.removeView(views.get(position));
            }

            @Override
            public int getItemPosition(Object object) {
                Log.d(TAG, "getItemPosition: ");
                return super.getItemPosition(object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Log.d(TAG, "instantiateItem: ");
                View v = views.get(position);
                container.addView(v);
                return v;
            }
        };
        vp.setAdapter(pagerAdapter);
        vp.addOnPageChangeListener(this);
    }

    //TODO OnPageChangeListener
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d(TAG, "onPageScrolled: " + position + "  " + positionOffset + " " + positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "onPageSelected: " + position );
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d(TAG, "onPageScrollStateChanged: " + state );
    }
}
