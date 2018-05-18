package modules;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import models.HomeInfo;

/**
 * Created by zhudongdong on 2018/5/9.
 */

public class HomeBannerModule extends LinearLayout implements IModuleHome {

    public HomeBannerModule(Context context) {
        this(context, null);
    }

    public HomeBannerModule(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void setHomeInfo(HomeInfo homeInfo) {

    }
}
