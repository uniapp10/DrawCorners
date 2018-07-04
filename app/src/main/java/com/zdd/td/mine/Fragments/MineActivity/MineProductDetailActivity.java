package com.zdd.td.mine.Fragments.MineActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.R;
import com.zdd.td.mine.Activity.StartActivity;
import com.zdd.td.mine.customViews.TitleView;
import com.zdd.td.mine.models.HomeHqModel;

/**
 * Created by zhudongdong on 2018/7/3.
 */

public class MineProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

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

        initListener();
    }

    private void initListener() {
        TextView tv_zixuan = findViewById(R.id.tv_zixuan);
        TextView tv_tixing = findViewById(R.id.tv_tixing);
        TextView tv_maikong = findViewById(R.id.tv_maikong);
        TextView tv_maiduo = findViewById(R.id.tv_maiduo);
        TextView tv_kuaijie = findViewById(R.id.tv_kuaijie);
        tv_zixuan.setOnClickListener(this);
        tv_tixing.setOnClickListener(this);
        tv_maikong.setOnClickListener(this);
        tv_maiduo.setOnClickListener(this);
        tv_kuaijie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId){
            case R.id.tv_zixuan:
                Toast.makeText(this, "自选", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_tixing:
                Toast.makeText(this, "提醒", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_maikong:
                Toast.makeText(this, "买多", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_maiduo:
                Toast.makeText(this, "卖空", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_kuaijie:
                Toast.makeText(this, "快捷", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}
