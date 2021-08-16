package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.sezikim.bank.model.Transaction.TRANSACTION_FORMAT;

public class TransactionAnalyzer {
    public static final String MONTHLY_TRANSACTION_COUNT_FORMAT = "%d월: %d회";
    private List<Transaction> transactionList;

    public TransactionAnalyzer(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public void printAmountBankStatement() {
        System.out.println("총입금액: " + getAmountDeposit());
        System.out.println("총출금액: " + getAmountWithdrawal());
        System.out.println("자산 변화: " + (getAmountDeposit() - getAmountWithdrawal()));
        System.out.println();
    }

    public void printMonthlyBankStatement() {
        HashMap<Integer, Integer> transactionCountMap = getMonthlyTransactionCount();

        System.out.println("월별 입출금 횟수");
        for (int i = 1; i <= 12; ++i) {
            if (transactionCountMap.containsKey(i)) {
                System.out.println(String.format(MONTHLY_TRANSACTION_COUNT_FORMAT, i, transactionCountMap.get(i)));
                continue;
            }

            System.out.println(String.format(MONTHLY_TRANSACTION_COUNT_FORMAT, i, 0));
        }

        System.out.println();
    }

    public void printMostWithdrawalList() {
        System.out.println("지출 상위 10건");
        System.out.println(String.format(TRANSACTION_FORMAT, "거래 일자", "거래 대금", "거래 항목"));
        List<Transaction> mostWithdrawalTransactionList = getMostWithdrawalList();
        for (Transaction transaction : mostWithdrawalTransactionList) {
            System.out.println(transaction);
        }

        System.out.println();
    }

    public void printMostWithdrawalCategory() {
        System.out.println("지출 최고 항목");
        System.out.println(getMostWithdrawalCategory());
        System.out.println();
    }

    private int getAmountDeposit() {
        int amountDeposit = 0;

        for (Transaction transaction : transactionList) {
            int curTransactionValue = transaction.getTransactionValue();
            if (curTransactionValue > 0)
                amountDeposit += curTransactionValue;
        }

        return amountDeposit;
    }

    private int getAmountWithdrawal() {
        int amountWithdrawal = 0;

        for (Transaction transaction : transactionList) {
            int curTransactionValue = transaction.getTransactionValue();
            if (curTransactionValue < 0)
                amountWithdrawal += curTransactionValue;
        }

        return amountWithdrawal;
    }

    private HashMap<Integer, Integer> getMonthlyTransactionCount() {
        HashMap<Integer, Integer> transactionCountMap = new HashMap<>();

        for (Transaction transaction : transactionList) {
            int curMonthValue = transaction.getTransactionDate().getMonthValue();
            if (!transactionCountMap.containsKey(curMonthValue)) {
                transactionCountMap.put(curMonthValue, 1);
                continue;
            }

            transactionCountMap.replace(curMonthValue, transactionCountMap.get(curMonthValue) + 1);
        }

        return transactionCountMap;
    }

    private String getMostWithdrawalCategory() {
        String mostWithdrawalCategory = "";
        int min = Integer.MAX_VALUE;
        for (Transaction transaction : transactionList) {
            if (min > transaction.getTransactionValue()) {
                min = transaction.getTransactionValue();
                mostWithdrawalCategory = transaction.getTransactionCategory();
            }
        }

        return mostWithdrawalCategory;
    }

    private List<Transaction> getMostWithdrawalList() {
        List<Transaction> transactionSortList = new ArrayList<>();
        transactionSortList.addAll(transactionList);

        return transactionSortList.stream()
                .filter(transaction -> transaction.getTransactionValue() < 0)
                .sorted((trasaction1, trasaction2) -> trasaction1.getTransactionValue() - trasaction2.getTransactionValue())
                .limit(10)
                .collect(Collectors.toList());
    }

}
