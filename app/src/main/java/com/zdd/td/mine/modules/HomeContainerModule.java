package com.zdd.td.mine.modules;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhudongdong on 2018/5/8.
 */

public class HomeContainerModule extends LinearLayout {

    private LayoutInflater inflater;
    public List<IModuleHome> moduleHomesList = null;
    public HomeContainerModule(Context context) {
        super(context);
    }

    public HomeContainerModule(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        inflater = LayoutInflater.from(getContext());

        moduleHomesList = new ArrayList<>();

    }

}
