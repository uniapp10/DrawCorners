package com.zdd.td.mine.customViews;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;
import com.squareup.picasso.Picasso;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhudongdong on 2018/5/10.
 */

public class CycleViewPager extends FrameLayout implements ViewPager.OnPageChangeListener {

    private Context mContext;
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout_indicator;
    private TextView mTitleView;
    private Handler handler;

    private int WHEEL = 100;
    private int WHEEL_WAIT = 101;

    private List<View> mViews = new ArrayList<>();

    private boolean isCycle = true;
    private boolean isWheel = true;
    private int delay = 2000;
    private int mCurrentPosition = 0;
    private long releaseTime = 0;

    private boolean isScrolling;

    private int mIndicatorSelected;
    private int mIndicatorUnselected;

    private List<Info> infos;
    private ImageCycleViewListener mImageCycleViewListener;

    private ImageView[] mIndicators;

    private LinearLayout mIndicatorLayout;
    private ViewPagerAdapter mAdapter;

    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mContext != null && isWheel){
                long now = System.currentTimeMillis();
                if (now - releaseTime > delay - 500){
                    handler.sendEmptyMessage(WHEEL);
                }else {
                    handler.sendEmptyMessage(WHEEL_WAIT);
                }
            }
        }
    };

    public CycleViewPager(@NonNull Context context) {
        this(context, null);
    }

    public CycleViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CycleViewPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.banner_cycleview, this, true);

        mViewPager = findViewById(R.id.cycle_view_pager);
        mLinearLayout_indicator = findViewById(R.id.cycle_indicator);
        mTitleView = findViewById(R.id.cycle_title);
        mIndicatorLayout = findViewById(R.id.cycle_indicator);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (msg.what == WHEEL && mViews.size() > 0){
                    if (!isScrolling){
                        int position = (mCurrentPosition + 1) % mViews.size();
                        mViewPager.setCurrentItem(position, true);
                    }
                    releaseTime = System.currentTimeMillis();
                    handler.removeCallbacks(runnable);
                    handler.postDelayed(runnable,delay);
                }

                if (msg.what == WHEEL_WAIT && mViews.size() > 0){
                    handler.removeCallbacks(runnable);
                }
            }
        };
    }

    public void setIndicators(int select, int unselect){
        mIndicatorSelected = select;
        mIndicatorUnselected = unselect;
    }

    public void setData(List<Info> list, ImageCycleViewListener listener){
        setData(list, listener, 0);
    }

    public void setData(List<Info> list, ImageCycleViewListener listener, int showPosition) {
        if (list == null || list.size() == 0){
            this.setVisibility(View.GONE);
            return;
        }
        mViews.clear();
        infos=list;

        if (isCycle){
            mViews.add(getImageView(mContext, infos.get(infos.size() - 1).getUrl()));
            for(int i = 0; i < infos.size(); i++){
                mViews.add(getImageView(mContext, infos.get(i).getUrl()));
            }
            mViews.add(getImageView(mContext, infos.get(0).getUrl()));
        }else {
            for(int i = 0; i < infos.size(); i++){
                mViews.add(getImageView(mContext, infos.get(i).getUrl()));
            }
        }

        if (mViews==null || mViews.size() == 0){
            this.setVisibility(View.GONE);
            return;
        }
        mImageCycleViewListener = listener;
        int ivSize = mViews.size();
        mIndicators = new ImageView[ivSize];
        if (isCycle) mIndicators = new ImageView[ivSize - 2];
        mIndicatorLayout.removeAllViews();
        for (int i = 0; i < mIndicators.length; i++){
            mIndicators[i]= new ImageView(mContext);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            mIndicators[i].setLayoutParams(lp);
            mIndicatorLayout.addView(mIndicators[i]);
        }

        mAdapter = new ViewPagerAdapter();

        setIndicator(0);

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setAdapter(mAdapter);
        if (showPosition < 0 || showPosition >= mViews.size())
            showPosition = 0;
        if (isCycle)showPosition = showPosition + 1;
        mViewPager.setCurrentItem(showPosition);
        setWheel(true);
    }

    public void setWheel(boolean isWheel){
        this.isWheel = isWheel;
        isCycle = true;
        if (isWheel) handler.postDelayed(runnable, delay);
    }

    private static final String TAG = "CycleViewPager";

    private void setIndicator(int selectedPosition){
        setText(mTitleView, infos.get(selectedPosition).getTitle());
        try {
            for (int i = 0; i < mIndicators.length; i++){
                mIndicators[i].setBackgroundResource(mIndicatorSelected);
            }
            if (mIndicators.length > selectedPosition){
                mIndicators[selectedPosition].setBackgroundResource(mIndicatorSelected);
            }
        }catch (Exception e){
            Log.i(TAG, "setIndicator:指示器路径错误 ");
        }
    }

    public static void setText(TextView textView, String text){
        if (text != null && textView!= null) textView.setText(text);
    }

    private View getImageView(Context context, String url){
        RelativeLayout rl = new RelativeLayout(context);
        //添加一个ImageView，并加载图片
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);;
        //使用Picasso来加载图片
        Picasso.with(context).load(url).into(imageView);
        //在Imageview前添加一个半透明的黑色背景，防止文字和图片混在一起
        ImageView backGround = new ImageView(context);
        backGround.setLayoutParams(layoutParams);
        backGround.setBackgroundResource(R.color.cycle_image_bg);
        rl.addView(imageView);
        rl.addView(backGround);
        return rl;
    }

//    public  View getImageViewM(Context context, String url) {
//
//    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int max = mViews.size() - 1;
        int positon = position;
        mCurrentPosition = position;
        if (isCycle){
            if (positon == 0){
                mCurrentPosition = max - 1;
            }else if (position == max){
                mCurrentPosition = 1;
            }
            position = mCurrentPosition - 1;
        }
        setIndicator(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 1){
            isScrolling = true;
            return;
        }else if (state == 0){
            releaseTime = System.currentTimeMillis();
            mViewPager.setCurrentItem(mCurrentPosition, false);
        }
    }

    public void setDelay(int delay){
        this.delay = delay;
    }

    public void setCycle(boolean isCycle){
        this.isCycle = isCycle;
    }

    public boolean isCycle() {
        return isCycle;
    }


    public static interface ImageCycleViewListener {
        public void onImageClick(Info info, int postion, View ImageView);
    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = mViews.get(position);
            if (mImageCycleViewListener != null){
                v.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mImageCycleViewListener.onImageClick(infos.get(mCurrentPosition - 1),
                                mCurrentPosition, v);
                    }
                });
            }
            container.addView(v);
            return v;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
