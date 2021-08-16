package com.programmers.java.io;

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

    public static MonthlyDetail getMonthlyDetail(int month, List<List<String>> depositDetails) {
        int monthlyDeposit = 0;
        int monthlySpending = 0;
        for (List<String> oneDepositDetail : depositDetails) {
            LocalDate localDate = LocalDate.parse(oneDepositDetail.get(0), DATE_FORMMATER);
            if (localDate.getMonthValue() == month) {
                int detail = Integer.parseInt(oneDepositDetail.get(1));
                if (detail > 0) {
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
