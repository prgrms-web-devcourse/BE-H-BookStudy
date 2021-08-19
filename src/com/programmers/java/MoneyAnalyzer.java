package com.programmers.java;

import com.programmers.java.model.MoneyDetail;
import com.programmers.java.model.MonthlyDetail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MoneyAnalyzer {
    private List<MoneyDetail> transactionDetails;

    public MoneyAnalyzer(List<MoneyDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public long getAllIncome(){
        long allIncome = 0;
        for (var detail : transactionDetails){
            long money = detail.getMoney();

            if(money > 0){
                allIncome += money;
            }
        }
        return allIncome;
    }

    public long getAllSpending(){
        long allSpending = 0;

        for (var detail : transactionDetails){
            long money = detail.getMoney();

            if(money < 0){
                allSpending += money;
            }
        }
        return allSpending;
    }

    public List<Long> getTopTenSpending() {
        List<Long> topTenSpending = new ArrayList<>();
        List<MoneyDetail> sortBySpendingDesc = sortBySpendingDesc();

        int i = 0;
        while(true){
            if(topTenSpending.size() == 10){
                break;
            }
            if(sortBySpendingDesc.get(i).getMoney() > 0){
                break;
            }

            topTenSpending.add(sortBySpendingDesc.get(i).getMoney());
            i++;
        }

        return topTenSpending;
    }

    public long getTopSpending(){
        return sortBySpendingDesc().get(0).getMoney();
    }

    private List<MoneyDetail> sortBySpendingDesc(){
        return transactionDetails.stream().sorted(Comparator.comparing(i -> i.getMoney()))
                .collect(Collectors.toList());
    }

    public MonthlyDetail getMonthlyDetail(int month){
        return MonthlyDetail.getMonthlyDetail(month, transactionDetails);
    }
}
