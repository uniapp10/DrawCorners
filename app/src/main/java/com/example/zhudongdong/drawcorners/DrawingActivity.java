package com.example.zhudongdong.drawcorners;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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

}