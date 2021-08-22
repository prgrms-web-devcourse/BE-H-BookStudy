package com.programmers.java.io;

import com.programmers.java.MoneyAnalyzer;

public interface Output {
    void printFileError();
    void printAllIncome(MoneyAnalyzer moneyAnalyzer);
    void printAllSpending(MoneyAnalyzer moneyAnalyzer);
    void printTopTenSpending(MoneyAnalyzer moneyAnalyzer);
    void printTopSpending(MoneyAnalyzer moneyAnalyzer);
    void printMonthlyDetail(MoneyAnalyzer moneyAnalyzer, int month);

}
