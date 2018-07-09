package com.zdd.td.mine.models;

/**
 * Created by zhudongdong on 2018/7/6.
 */

public class HomeNewsCalendarModel {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue_pre() {
        return value_pre;
    }

    public void setValue_pre(String value_pre) {
        this.value_pre = value_pre;
    }

    public String getValue_yuqi() {
        return value_yuqi;
    }

    public void setValue_yuqi(String value_yuqi) {
        this.value_yuqi = value_yuqi;
    }

    public String getValue_gongbu() {
        return value_gongbu;
    }

    public void setValue_gongbu(String value_gongbu) {
        this.value_gongbu = value_gongbu;
    }

    private String title;

    public HomeNewsCalendarModel(String time, String title, String value_pre, String value_yuqi, String value_gongbu) {
        this.time = time;
        this.title = title;
        this.value_pre = value_pre;
        this.value_yuqi = value_yuqi;
        this.value_gongbu = value_gongbu;
    }

    private String value_pre;
    private String value_yuqi;
    private String value_gongbu;
}
