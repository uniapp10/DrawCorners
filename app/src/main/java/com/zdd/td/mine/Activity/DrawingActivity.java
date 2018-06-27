package com.zdd.td.mine.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;

public class DrawingActivity extends AppCompatActivity {

    public static void startActivity(Context context){
        context.startActivity(new Intent(context, DrawingActivity.class));
    }

    private TextView mTextMessage;

    private static final String TAG = "DrawingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

//        RadioGroup radioGroup =  (RadioGroup) findViewById(R.id.radioGroup);
//        RadioButton rb = (RadioButton) radioGroup.getChildAt(0);
//        rb.setChecked(true);
        RadioButton rb = findViewById(R.id.rb1);
        rb.setChecked(true);
    }

    public void onClick(View v){
        StartActivity.startActivity(this);
    }

}
