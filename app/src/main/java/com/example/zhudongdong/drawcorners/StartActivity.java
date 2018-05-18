package com.example.zhudongdong.drawcorners;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Fragments.HomeFragment;
import Fragments.MineFragment;
import Fragments.PriceFragment;
import Fragments.ServiceFragment;
import Fragments.TradeFragment;

public class StartActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    protected int index = 0;
    protected Fragment oldFragment = null;

    public static void startActivity(Context context){
        Intent intent = new Intent(context, StartActivity.class);
        context.startActivity(intent);
    }

    List<Fragment> fragments = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        RadioGroup rg = findViewById(R.id.rgbs);
        RadioButton rb_home = findViewById(R.id.tab_home);
        rb_home.setChecked(true);

        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new PriceFragment());
        fragments.add(new TradeFragment());
        fragments.add(new ServiceFragment());
        fragments.add(new MineFragment());
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_top, fragments.get(0)).commitAllowingStateLoss();

        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (checkedId == R.id.tab_home){
            index = 0;
        }else if(checkedId == R.id.tab_price){
            index = 1;
        }else if(checkedId == R.id.tab_trade){
            index = 2;
        }else if(checkedId == R.id.tab_service){
            index = 3;
        }else if(checkedId == R.id.tab_mine){
            index = 4;
        }

        Fragment fragment = fragments.get(index);
        if (fragment.isAdded() && (!fragment.isHidden())){
            this.getSupportFragmentManager().beginTransaction().hide(oldFragment).commitAllowingStateLoss();
            return;
        }else if (fragment.isAdded() && fragment.isHidden()){
            this.getSupportFragmentManager().beginTransaction().show(oldFragment).commitAllowingStateLoss();
            return;
        }
        oldFragment = fragments.get(index);
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_top, oldFragment).commitAllowingStateLoss();
    }
}
