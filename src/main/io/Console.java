package com.programmers.java.io;

import com.programmers.java.MoneyAnalyzer;

public class Console implements Input, Output{

    @Override
    public void printFileError() {
        System.out.println("파일을 읽을 수 없습니다.");
    }

    @Override
    public void printAllIncome(MoneyAnalyzer moneyAnalyzer) {
        System.out.println(moneyAnalyzer.getAllIncome());
    }

    @Override
    public void printAllSpending(MoneyAnalyzer moneyAnalyzer) {
        System.out.println(moneyAnalyzer.getAllSpending());
    }

    @Override
    public void printTopTenSpending(MoneyAnalyzer moneyAnalyzer) {
        System.out.println(moneyAnalyzer.getTopTenSpending());
    }

    @Override
    public void printTopSpending(MoneyAnalyzer moneyAnalyzer) {
        System.out.println(moneyAnalyzer.getTopSpending());
    }

    @Override
    public void printMonthlyDetail(MoneyAnalyzer moneyAnalyzer, int month) {
        System.out.println(moneyAnalyzer.getMonthlyDetail(month));
    }

    public void printAllRequirements(MoneyAnalyzer moneyAnalyzer, int month){
        printAllIncome(moneyAnalyzer);
        printAllSpending(moneyAnalyzer);
        printTopTenSpending(moneyAnalyzer);
        printTopSpending(moneyAnalyzer);
        printMonthlyDetail(moneyAnalyzer, month);
    }
}
