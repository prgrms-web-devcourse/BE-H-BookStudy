package com.realsoftware.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MonthlyDetail {
    private final int income;
    private final int spending;

    public MonthlyDetail(int income, int spending) {
        this.income = income;
        this.spending = spending;
    }

    @Override
    public String toString() {
        return "MonthlyDetail{" +
                "income=" + income +
                ", spending=" + spending +
                '}';
    }
}
