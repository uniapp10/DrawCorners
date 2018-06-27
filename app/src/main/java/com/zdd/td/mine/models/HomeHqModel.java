package com.zdd.td.mine.models;

/**
 * Created by zhudongdong on 2018/5/25.
 */

public class HomeHqModel {

    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    private String count;
    private String percent;

    public HomeHqModel(String name, String price, String count, String percent) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.percent = percent;
    }
}
