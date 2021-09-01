package com.realsoftware.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class BankTransaction {
    private final LocalDate date;
    private final long money;
    private final String location;

    public BankTransaction(
        @JsonProperty("date") LocalDate date,
        @JsonProperty("money") long money,
        @JsonProperty("location") String location) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankTransaction that = (BankTransaction) o;

        if (money != that.money) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (int) (money ^ (money >>> 32));
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
