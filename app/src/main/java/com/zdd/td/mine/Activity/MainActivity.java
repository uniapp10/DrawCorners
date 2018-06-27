package com.zdd.td.mine.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;

public class MainActivity extends AppCompatActivity implements OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_center = (TextView)findViewById(R.id.tv_center);
        tv_center.setOnClickListener(this);
    }

    private static final String TAG = "MainActivity";

    public void onClick(View v){
        DrawingActivity.startActivity(this);
    }
}
