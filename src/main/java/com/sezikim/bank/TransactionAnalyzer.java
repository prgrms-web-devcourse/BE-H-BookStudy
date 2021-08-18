package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;
import com.sezikim.bank.view.TransactionPrinter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionAnalyzer {
    private List<Transaction> transactionList;
    private TransactionPrinter transactionPrinter;

    public TransactionAnalyzer(List<Transaction> transactionList) {
        this.transactionList = transactionList;
        this.transactionPrinter = new TransactionPrinter();
    }

    public void printAnalysis() {
        transactionPrinter.printAmountBankStatement(getAmountDeposit(), getAmountWithdrawal());
        transactionPrinter.printMonthlyBankStatement(getMonthlyTransactionCount());
        transactionPrinter.printMostWithdrawalList(getMostWithdrawalList());
        transactionPrinter.printMostWithdrawalContent(getMostWithdrawalContent());
    }

    /**
     * 총 입금 금액을 구하는 메소드
     * @return AmountDeposit
     */
    private int getAmountDeposit() {
        int amountDeposit = 0;

        for (Transaction transaction : transactionList) {
            int curTransactionValue = transaction.getTransactionValue();
            if (curTransactionValue > 0)
                amountDeposit += curTransactionValue;
        }

        return amountDeposit;
    }

    /**
     * 총 출금 금액을 구하는 메소드
     * @return AmountWithdrawal
     */
    private int getAmountWithdrawal() {
        int amountWithdrawal = 0;

        for (Transaction transaction : transactionList) {
            int curTransactionValue = transaction.getTransactionValue();
            if (curTransactionValue < 0)
                amountWithdrawal += curTransactionValue;
        }

        return amountWithdrawal;
    }

    /**
     * 월별 사용자 입출금 횟수를 구하는 메소드
     * @return HashMap<Integer, Integer> TransactionCountMap
     */
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

    /**
     * 가장 많이 소비한 항목을 구하는 메소드
     * @return MostWithdrawalContent
     */
    private String getMostWithdrawalContent() {
        String mostWithdrawalContent = "";
        int min = Integer.MAX_VALUE;
        for (Transaction transaction : transactionList) {
            if (min > transaction.getTransactionValue()) {
                min = transaction.getTransactionValue();
                mostWithdrawalContent = transaction.getTransactionContent();
            }
        }

        return mostWithdrawalContent;
    }

    /**
     * 지출이 가장 높은 상위 10건의 출금내역을 구하는 메소드
     * @return MostWithdrawalList
     */
    private List<Transaction> getMostWithdrawalList() {
        List<Transaction> transactionSortList = new ArrayList<>();
        transactionSortList.addAll(transactionList);

        return transactionSortList.stream()
                .filter(transaction -> transaction.getTransactionValue() < 0)
                .sorted(Comparator.comparingInt(Transaction::getTransactionValue))
                .limit(10)
                .collect(Collectors.toList());
    }

}
