package com.programmers.java.model;

import java.util.List;

public class MoneyDetail {
    private String date;
    private long money;
    private String location;

    public MoneyDetail(String date, long money, String location) {
        this.date = date;
        this.money = money;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public long getMoney() {
        return money;
    }

    public String getLocation() {
        return location;
    }
}
