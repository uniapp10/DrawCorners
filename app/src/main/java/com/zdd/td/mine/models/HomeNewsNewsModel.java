package com.zdd.td.mine.models;

/**
 * Created by zhudongdong on 2018/7/6.
 */

public class HomeNewsNewsModel {
    private String iconUrl;
    private String title;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public HomeNewsNewsModel(String iconUrl, String title, String time) {
        this.iconUrl = iconUrl;
        this.title = title;
        this.time = time;
    }
}
