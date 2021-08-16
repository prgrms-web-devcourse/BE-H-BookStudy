package com.programmers.java;

import com.programmers.java.io.MonthlyDetail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoneyAnalyzer {
    private List<List<String>> depositDetails;

    public MoneyAnalyzer(List<List<String>> depositDetails) {
        this.depositDetails = depositDetails;
    }

    public int getAllIncome(){
        int allIncome = 0;
        for (List oneDetail : depositDetails){
            int anIncome = Integer.parseInt((String) oneDetail.get(1));
            if(anIncome > 0){
                allIncome += anIncome;
            }
        }
        return allIncome;
    }

    public int getAllSpending(){
        int allSpending = 0;

        for (List oneDetail : depositDetails){
            int anSpending = Integer.parseInt((String) oneDetail.get(1));

            if(anSpending < 0){
                allSpending += anSpending;
            }
        }
        return allSpending;
    }

    public List<String> getTopTenSpending() {
        List<String> topTenSpending = new ArrayList<String>();
        sortBySpendingDesc();

        int i = 0;
        while(true){
            if(topTenSpending.size() == 10){
                break;
            }
            if(Integer.parseInt(depositDetails.get(i).get(1)) > 0){
                break;
            }

            topTenSpending.add(depositDetails.get(i).get(1));
            i++;
        }

        return topTenSpending;
    }

    public String getTopSpending(){
        sortBySpendingDesc();
        return depositDetails.get(0).get(1);
    }

    public void sortBySpendingDesc(){
        depositDetails.sort(Comparator.comparing(i -> Integer.parseInt(i.get(1))));
    }

    public MonthlyDetail getMonthlyDetail(int month){
        return MonthlyDetail.getMonthlyDetail(month, depositDetails);
    }
}
