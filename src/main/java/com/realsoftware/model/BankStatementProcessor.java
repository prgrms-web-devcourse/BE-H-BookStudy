package com.realsoftware.model;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public long getAllIncome() {
        long allIncome = 0;
        for (var detail : bankTransactions) {
            long money = detail.getMoney();

            if (money > 0) {
                allIncome += money;
            }
        }
        return allIncome;
    }

    public long getAllSpending() {
        long allSpending = 0;

        for (var detail : bankTransactions) {
            long money = detail.getMoney();

            if (money < 0) {
                allSpending += money;
            }
        }
        return allSpending;
    }

    public List<BankTransaction> getTopTenSpending() {
        List<BankTransaction> topTenSpending = new ArrayList<>();
        List<BankTransaction> sortBySpendingDesc = sortBySpendingDesc();

        int i = 0;
        while (true) {
            if (topTenSpending.size() == 10) {
                break;
            }
            if (sortBySpendingDesc.get(i).getMoney() > 0) {
                break;
            }

            topTenSpending.add(sortBySpendingDesc.get(i));
            i++;
        }

        return topTenSpending;
    }

    public long getTopSpending() {
        return sortBySpendingDesc().get(0).getMoney();
    }

    private List<BankTransaction> sortBySpendingDesc() {
        return bankTransactions.stream().sorted(Comparator.comparing(i -> i.getMoney()))
                .collect(Collectors.toList());
    }

    public MonthlyDetail getMonthlyDetail(Month month) {
        int monthlyDeposit = 0;
        int monthlySpending = 0;
        for (var bankTransaction : bankTransactions) {
            LocalDate localDate = bankTransaction.getDate();
            if (localDate.getMonth() == month) {
                long money = bankTransaction.getMoney();
                if (money > 0) {
                    monthlyDeposit += 1;
                } else {
                    monthlySpending += 1;
                }
            }
        }
        return new MonthlyDetail(monthlyDeposit, monthlySpending);
    }

    public List<BankTransaction> searchByDateRange(LocalDate startDate, LocalDate endDate){
        if(startDate.compareTo(endDate) >= 0){
            throw new IllegalArgumentException("startDate는 endDate 보다 작아야합니다.");
        }

        List<BankTransaction> result = new ArrayList<>();
        for (var bankTransaction: bankTransactions){
            LocalDate currentDate = bankTransaction.getDate();
            if(!(currentDate.isBefore(startDate) || currentDate.isAfter(endDate))){
                result.add(bankTransaction);
            }
        }

        return result;
    }
}

