package com.zdd.td.mine.models;

/**
 * Created by zhudongdong on 2018/5/29.
 */

public class HomeAnalysisModel {

    private String iconUrl;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    private String name;
    private String time;
    private String content;


    public HomeAnalysisModel(String iconUrl, String name, String time, String content) {
        this.iconUrl = iconUrl;
        this.name = name;
        this.time = time;
        this.content = content;
    }

}
