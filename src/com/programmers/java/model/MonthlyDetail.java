package com.programmers.java.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MonthlyDetail {
    private static final DateTimeFormatter DATE_FORMMATER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final int deposit;
    private final int spending;

    public MonthlyDetail(int deposit, int spending) {
        this.deposit = deposit;
        this.spending = spending;
    }

    public static MonthlyDetail getMonthlyDetail(int month, List<MoneyDetail> depositDetails) {
        int monthlyDeposit = 0;
        int monthlySpending = 0;

        for (var depositDetail : depositDetails) {
            LocalDate localDate = LocalDate.parse(depositDetail.getDate(), DATE_FORMMATER);

            if (localDate.getMonthValue() == month) {
                long money = depositDetail.getMoney();
                if (money > 0) {
                    monthlyDeposit += 1;
                } else {
                    monthlySpending += 1;
                }
            }
        }

        return new MonthlyDetail(monthlyDeposit, monthlySpending);
    }

    @Override
    public String toString() {
        return "MonthlyDetail{" +
                "deposit=" + deposit +
                ", spending=" + spending +
                '}';
    }
}
