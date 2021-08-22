package main.model;

import main.model.BankTransaction;
import main.model.MonthlyDetail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;
    
    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public long getAllIncome(){
        long allIncome = 0;
        for (var detail : bankTransactions){
            long money = detail.getMoney();

            if(money > 0){
                allIncome += money;
            }
        }
        return allIncome;
    }

    public long getAllSpending(){
        long allSpending = 0;

        for (var detail : bankTransactions){
            long money = detail.getMoney();

            if(money < 0){
                allSpending += money;
            }
        }
        return allSpending;
    }

    public List<Long> getTopTenSpending() {
        List<Long> topTenSpending = new ArrayList<>();
        List<BankTransaction> sortBySpendingDesc = sortBySpendingDesc();

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

    private List<BankTransaction> sortBySpendingDesc(){
        return bankTransactions.stream().sorted(Comparator.comparing(i -> i.getMoney()))
                .collect(Collectors.toList());
    }

    public MonthlyDetail getMonthlyDetail(int month){
        return MonthlyDetail.getMonthlyDetail(month, bankTransactions);
    }
}
