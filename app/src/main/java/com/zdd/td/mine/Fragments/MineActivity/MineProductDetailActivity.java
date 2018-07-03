package com.zdd.td.mine.Fragments.MineActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.zhudongdong.drawcorners.R;
import com.zdd.td.mine.Activity.StartActivity;
import com.zdd.td.mine.customViews.TitleView;
import com.zdd.td.mine.models.HomeHqModel;

/**
 * Created by zhudongdong on 2018/7/3.
 */

public class MineProductDetailActivity extends AppCompatActivity {

    private HomeHqModel hqModel1;
    public static void start(Context context, HomeHqModel hqModel1){
        Intent intent = new Intent(context, MineProductDetailActivity.class);
        intent.putExtra("name", hqModel1.getName());
        intent.putExtra("hqModel", hqModel1);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mine_product_detail_activity);
        this.hqModel1 = (HomeHqModel)getIntent().getSerializableExtra("hqModel");
        TitleView titleView = findViewById(R.id.mine_detail_titleView);
        titleView.setTitleName(this.hqModel1.getName());
        titleView.mLeftBackTextTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
