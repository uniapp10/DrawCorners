package com.zdd.td.mine.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;
import com.zdd.td.mine.models.HomeAnalysisModel;

/**
 * Created by zhudongdong on 2018/7/9.
 */

public class HomeNewsWebActivity extends AppCompatActivity {
    TextView mtv_progress;
    public static void startActivity(Context mcontext, HomeAnalysisModel model){
        Intent intent = new Intent(mcontext, HomeNewsWebActivity.class);
        intent.putExtra("model", model);
        mcontext.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_news_web_activity);
        HomeAnalysisModel model = (HomeAnalysisModel) getIntent().getSerializableExtra("model");
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl(model.getContentUrl());
        mtv_progress = findViewById(R.id.tv_progress);
        configureWebView(webView);
    }

    private void configureWebView(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                String progress = newProgress + "%";
                mtv_progress.setText(progress);
                if (newProgress < 100){

                }else if (newProgress == 100){
                    mtv_progress.setVisibility(View.GONE);
                }
            }
        });
    }
}
