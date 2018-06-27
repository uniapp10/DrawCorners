package com.zdd.td.mine.models;

/**
 * Created by zhudongdong on 2018/5/29.
 */

public class HomeNewsModel {

    public HomeNewsModel(String title, String time, String url) {
        this.title = title;
        this.time = time;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String title;
    private String time;
    private String url;
}
