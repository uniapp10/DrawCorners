package com.zdd.td.mine.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.zhudongdong.drawcorners.R;
import com.zdd.td.mine.Adapter.HomeNewsKuaiXunAdapter;
import com.zdd.td.mine.models.HomeNewsKuaiXunModel;

import java.util.ArrayList;

/**
 * Created by zhudongdong on 2018/7/4.
 */

public class HomeNewsActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "HomeNewsActivity";
    private ImageView iv_cursor;

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeNewsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_news);
        ImageView iv_back = findViewById(R.id.iv_back_arrow);
        iv_back.setOnClickListener(this);

        ImageView iv_cursor = findViewById(R.id.home_news_iv_cursor);
        this.iv_cursor = iv_cursor;
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;

        int leftMargin = dip2px(this, 45);

        float tv_width = (screenW - leftMargin) / 3.0f;
        float cursorWidth = (float)dip2px(this, 30);
        float offsetX = (tv_width - cursorWidth) * 0.5f;
        iv_cursor.setTranslationX(cursorWidth + offsetX);


        View v1 = LayoutInflater.from(this).inflate(R.layout.home_news_kuaixun, null);
        ListView listView = v1.findViewById(R.id.home_new_kuanxun_listview);

        ArrayList list = new ArrayList();
        HomeNewsKuaiXunModel model1 = new HomeNewsKuaiXunModel("18:30:39", "2018-1-29李小东 第二贴交易系统买入开仓整理二。根据历史交易系统买入开仓整理二。根据历史数据统计，此类形态的出现，保守者可顺势买入");
        list.add(model1);
        list.add(model1);
        list.add(model1);
        HomeNewsKuaiXunAdapter newsKuaiXunAdapter = new HomeNewsKuaiXunAdapter(this, R.layout.home_news_kuanxun_item, list);
        listView.setAdapter(newsKuaiXunAdapter);

        View v2 = LayoutInflater.from(this).inflate(R.layout.home_news_calendar, null);
        View v3 = LayoutInflater.from(this).inflate(R.layout.home_news_news, null);

        final ArrayList<View> views = new ArrayList<>();
        views.add(v1);
        views.add(v2);
        views.add(v3);
        ViewPager vp = findViewById(R.id.home_news_vp);
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return  view == object;
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v = views.get(position);
                container.addView(v);
                return v;
            }
        });
        vp.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int vID = v.getId();
        switch (vID) {
            case R.id.iv_back_arrow:
                finish();
                break;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        int leftMargin = dip2px(this, 45);
        float tv_width = (screenW - leftMargin) / 3.0f;
        float cursorWidth = (float)dip2px(this, 30);
        float offsetX = (tv_width - cursorWidth) * 0.5f;
        iv_cursor.setTranslationX(cursorWidth + offsetX + position * tv_width);

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

