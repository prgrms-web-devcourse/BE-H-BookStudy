package com.realsoftware.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BankTransaction {
    @JsonFormat(pattern = "dd-MM-yyyy")
    private final LocalDate date;
    private final long money;
    private final String location;

    public BankTransaction(LocalDate date, long money, String location) {
        this.date = date;
        this.money = money;
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getMoney() {
        return money;
    }

    public String getLocation() {
        return location;
    }
}
