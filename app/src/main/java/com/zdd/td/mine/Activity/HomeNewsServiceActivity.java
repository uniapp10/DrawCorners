package com.zdd.td.mine.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhudongdong.drawcorners.R;
import com.zdd.td.mine.customViews.TitleView;

/**
 * Created by zhudongdong on 2018/7/9.
 */

public class HomeNewsServiceActivity extends AppCompatActivity {

    public static void start(Context context){
        Intent intent = new Intent(context, HomeNewsServiceActivity.class);
        context.startActivity(intent);

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_news_service_activity);

        TitleView titleView = findViewById(R.id.home_news_service_titleview);
        titleView.mLeftBackImageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
