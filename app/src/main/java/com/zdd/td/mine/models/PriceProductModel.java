package com.zdd.td.mine.models;

/**
 * Created by zhudongdong on 2018/6/6.
 */

public class PriceProductModel {
    private String name;
    private String subName;
    private String price;
    private String percent;

    public PriceProductModel(String name, String subName, String price, String percent) {
        this.name = name;
        this.subName = subName;
        this.price = price;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

}
