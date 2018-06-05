package Fragments;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
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
        View v = inflater.inflate(R.layout.price_fragment, container, false);

        mviewPager = v.findViewById(R.id.viewPager);
        bmpW = 30;
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) container.getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = screenW / 2 - bmpW;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);

        imageView = v.findViewById(R.id.cursor);
        imageView.setImageMatrix(matrix);
        mviewPager.setOnPageChangeListener(new MyOnPageChangeListener());


//        PagerTabStrip pagerTabStrip = v.findViewById(R.id.pagertab);
//        pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.txtBlack));
//        pagerTabStrip.setDrawFullUnderline(true);
//        pagerTabStrip.setBackgroundColor(getResources().getColor(R.color.txtBlue));
//        pagerTabStrip.setTextSpacing(50);

        LayoutInflater lf = getLayoutInflater().from(container.getContext());
        View v1 = lf.inflate(R.layout.hq_custom, null);
        View v2 = lf.inflate(R.layout.hq_shanghai, null);

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
