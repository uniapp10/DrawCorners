package com.zdd.td.mine.models;

import android.widget.TextView;

/**
 * Created by zhudongdong on 2018/7/5.
 */

public class HomeNewsKuaiXunModel  {
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String time;

    public HomeNewsKuaiXunModel(String time, String content) {
        this.time = time;
        this.content = content;
    }

    private String content;
}
