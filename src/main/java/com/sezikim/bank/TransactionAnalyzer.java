package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;
import com.sezikim.bank.view.TransactionPrinter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.sezikim.bank.model.Transaction.TRANSACTION_FORMAT;

public class TransactionAnalyzer {
    public static final String MONTHLY_TRANSACTION_COUNT_FORMAT = "%d월: %d회";

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
        transactionPrinter.printMostWithdrawalCategory(getMostWithdrawalCategory());
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
                .sorted(Comparator.comparingInt(Transaction::getTransactionValue))
                .limit(10)
                .collect(Collectors.toList());
    }

}
