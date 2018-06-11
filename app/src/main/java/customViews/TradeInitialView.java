package customViews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhudongdong.drawcorners.R;

/**
 * Created by zhudongdong on 2018/6/11.
 */

public class TradeInitialView extends LinearLayout implements View.OnClickListener {
    public TradeInitialView(Context context) {
        this(context, null);
    }

    public TradeInitialView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.trade_initial_view, this,false);
        addView(v);
        TextView tv_kaihu = v.findViewById(R.id.tv_kaihu);
        TextView tv_binding= v.findViewById(R.id.tv_binding);
        tv_kaihu.setOnClickListener(this);
        tv_binding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId){
            case R.id.tv_kaihu:{
                Toast.makeText(getContext(), "点击开户", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.tv_binding:{
                Toast.makeText(getContext(), "点击绑定", Toast.LENGTH_SHORT).show();
            }
            break;
            default:
                break;
        }
    }
}
