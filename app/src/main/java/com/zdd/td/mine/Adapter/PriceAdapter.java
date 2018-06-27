package com.zdd.td.mine.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;

import java.util.ArrayList;

import com.zdd.td.mine.Interface.PriceItemOnClickListener;
import com.zdd.td.mine.models.PriceProductModel;

/**
 * Created by zhudongdong on 2018/6/6.
 */

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.PriceViewHolder> implements View.OnClickListener {


    private final Context mContext;
    private final ArrayList<PriceProductModel> mList;
    private PriceItemOnClickListener priceItemOnClickListener;

    public PriceAdapter(Context context, ArrayList<PriceProductModel> list,PriceItemOnClickListener priceItemOnClickListener){
        this.mContext = context;
        this.mList = list;
        this.priceItemOnClickListener = priceItemOnClickListener;
    }

    @Override
    public PriceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.price_product_item, null);
        PriceViewHolder priceViewHolder = new PriceViewHolder(view);
        view.setOnClickListener(this);
        return priceViewHolder;
    }

    @Override
    public void onBindViewHolder(PriceViewHolder holder, int position) {
        PriceProductModel model = mList.get(position);
//        String htmlString = String.format("<a color='';size='16sp'>%s</a><a color='';size='10sp'>%s</a>",
//                model.getName(), model.getSubName());
//        holder.tv_productName.setText(Html.fromHtml(htmlString));
        holder.tv_productName.setText(model.getName() + model.getSubName());
        holder.tv_productPrice.setText(model.getPrice());
        holder.tv_productPercent.setText(model.getPercent());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        priceItemOnClickListener.onItemClick(v, (int)v.getTag());
    }


    static class PriceViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_productName;
        public TextView tv_productPrice;
        public TextView tv_productPercent;

        public PriceViewHolder(View itemView) {
            super(itemView);
            tv_productName = itemView.findViewById(R.id.tv_productName);
            tv_productPrice = itemView.findViewById(R.id.tv_productPrice);
            tv_productPercent = itemView.findViewById(R.id.tv_productPercent);
        }
    }

}
