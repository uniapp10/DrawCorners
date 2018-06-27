package com.zdd.td.mine.customViews;

/**
 * Created by zhudongdong on 2018/5/17.
 */

public class Info {

    private String url;

    private String title;

    public Info(String title, String url) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
