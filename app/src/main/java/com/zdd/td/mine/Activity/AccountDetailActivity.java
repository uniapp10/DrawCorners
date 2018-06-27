package com.zdd.td.mine.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.R;

/**
 * Created by zhudongdong on 2018/6/27.
 */

public class AccountDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static void startActivity(Context context){
        context.startActivity(new Intent(context, AccountDetailActivity.class));
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mine_accountmanager);
        initListener();
    }

    private void initListener() {
        RelativeLayout rv1 = findViewById(R.id.iconView);
        RelativeLayout rv2 = findViewById(R.id.shortName);
        RelativeLayout rv3 = findViewById(R.id.changePwd);
        Button btn_logout = findViewById(R.id.btn_logOut);

        rv1.setOnClickListener(this);
        rv2.setOnClickListener(this);
        rv3.setOnClickListener(this);
        btn_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iconView:
                Toast.makeText(this,"iconView", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shortName:
                Toast.makeText(this,"shortName", Toast.LENGTH_SHORT).show();
                break;
            case R.id.changePwd:
                Toast.makeText(this,"changePwd", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_logOut:
                Toast.makeText(this,"btn_logOut", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
