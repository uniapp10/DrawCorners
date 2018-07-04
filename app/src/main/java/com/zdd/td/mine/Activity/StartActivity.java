package com.zdd.td.mine.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import com.example.zhudongdong.drawcorners.R;
import com.zdd.td.mine.Fragments.HomeFragment;
import com.zdd.td.mine.Fragments.MineFragment;
import com.zdd.td.mine.Fragments.PriceFragment;
import com.zdd.td.mine.Fragments.ServiceFragment;
import com.zdd.td.mine.Fragments.TradeFragment;
import com.zdd.td.mine.Interface.HomeHqZiXuanListener;

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


        final RadioGroup rg = findViewById(R.id.rgbs);
        RadioButton rb_home = findViewById(R.id.tab_home);
        rb_home.setChecked(true);

        fragments = new ArrayList<Fragment>();
        final HomeFragment homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        homeFragment.addZiXuanListener(new HomeHqZiXuanListener() {
            @Override
            public void onClick() {
                rg.check(R.id.tab_price);
            }
        });
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
        if (fragment == oldFragment){
            return;
        }

        oldFragment = fragment;
        if (fragment.isAdded()){
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment1 = fragments.get(i);
                if (fragment1 != fragment){
                    this.getSupportFragmentManager().beginTransaction().hide(fragment1).commitAllowingStateLoss();
                }
            }
            this.getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
        }else {
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment1 = fragments.get(i);
                if (fragment1 != fragment){
                    this.getSupportFragmentManager().beginTransaction().hide(fragment1).commitAllowingStateLoss();
                }
            }
            this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_top, fragment).commitAllowingStateLoss();
            this.getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
        }
    }
}
