package com.zdd.td.mine.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.R;

import com.zdd.td.mine.Activity.AccountDetailActivity;

/**
 * Created by zhudongdong on 2018/5/8.
 */

public class MineFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container, false);
        initListener(view);
        return view;
    }

    private void initListener(View view) {
        view.setOnClickListener(this);
        RelativeLayout rel_01 = view.findViewById(R.id.mine_loginIn);
        rel_01.setOnClickListener(this);
        RelativeLayout rel_02 = view.findViewById(R.id.mine_pwdManager);
        rel_02.setOnClickListener(this);
        RelativeLayout rel_03 = view.findViewById(R.id.mine_helpCenterLayout);
        rel_03.setOnClickListener(this);
        RelativeLayout rel_00 = view.findViewById(R.id.mine_waiterLayout);
        rel_00.setOnClickListener(this);
        RelativeLayout rel_04 = view.findViewById(R.id.mine_backLayout);
        rel_04.setOnClickListener(this);
        RelativeLayout rel_05 = view.findViewById(R.id.mine_tuisongLayout);
        rel_05.setOnClickListener(this);
        RelativeLayout rel_06 = view.findViewById(R.id.mine_aboutLayout);
        rel_06.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.mine_loginIn:
                AccountDetailActivity.startActivity(getContext());
                break;
            case R.id.mine_pwdManager:
                Toast.makeText(getContext(),"mine_pwdManager", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_helpCenterLayout:
                Toast.makeText(getContext(),"mine_helpCenterLayout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_waiterLayout:
                Toast.makeText(getContext(),"mine_waiterLayout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_backLayout:
                Toast.makeText(getContext(),"mine_backLayout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_tuisongLayout:
                Toast.makeText(getContext(),"mine_tuisongLayout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_aboutLayout:
                Toast.makeText(getContext(),"mine_aboutLayout", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
