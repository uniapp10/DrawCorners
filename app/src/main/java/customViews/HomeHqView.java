package customViews;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.zhudongdong.drawcorners.R;

import java.util.ArrayList;

import Adapter.HomeHqAdapter;
import models.HomeHqModel;

/**
 * Created by zhudongdong on 2018/5/25.
 */

public class HomeHqView extends RelativeLayout {

    private RecyclerView mRecycleView;
    private HomeHqAdapter homeHqAdapter;

    public HomeHqView(Context context) {
        this(context, null);
    }

    public HomeHqView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();

    }

    private void initView() {
        addView(LayoutInflater.from(getContext()).inflate(R.layout.home_hq, this, false));

        mRecycleView = findViewById(R.id.home_hq_rv);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(lm);

        ArrayList list = new ArrayList();
        HomeHqModel hqModel1 = new HomeHqModel("黄金延期", "111", "11","11");
        HomeHqModel hqModel2 = new HomeHqModel("迷你黄金延期", "222", "11","11");
        HomeHqModel hqModel3 = new HomeHqModel("白银延期", "333", "11","11");

        for (int i = 0; i < 3; i++) {
            list.add(hqModel1);
            list.add(hqModel2);
            list.add(hqModel3);
        }

        homeHqAdapter = new HomeHqAdapter(list);
        mRecycleView.setAdapter(homeHqAdapter);
    }


}
