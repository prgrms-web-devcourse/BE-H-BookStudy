package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;
import com.sezikim.bank.view.TransactionPrinter;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionProcessor {
    private final List<Transaction> transactionList;
    private final TransactionPrinter transactionPrinter;

    public TransactionProcessor(List<Transaction> transactionList) {
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
     *
     * @return AmountDeposit
     */
    public int getAmountDeposit() {
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
     *
     * @return AmountWithdrawal
     */
    public int getAmountWithdrawal() {
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
     *
     * @return HashMap<Integer, Integer> TransactionCountMap
     */
    public HashMap<Month, Integer> getMonthlyTransactionCount() {
        HashMap<Month, Integer> transactionCountMap = new HashMap<>();
        for (Month month : Month.values()) {
            transactionCountMap.put(month, 0);
        }

        for (Transaction transaction : transactionList) {
            Month curMonth = transaction.getTransactionDate().getMonth();
            transactionCountMap.replace(curMonth, transactionCountMap.get(curMonth) + 1);
        }

        return transactionCountMap;
    }

    /**
     * 특정 달의 입출금 횟수를 구하는 메소드
     *
     * @param month
     * @return count
     */
    public int getSpecificMonthCount(Month month) {
        int count = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.getTransactionDate().getMonth().equals(month))
                count++;
        }

        return count;
    }

    /**
     * 가장 많이 소비한 항목을 구하는 메소드
     *
     * @return MostWithdrawalContent
     */
    public String getMostWithdrawalContent() {
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
     *
     * @return MostWithdrawalList
     */
    public List<Transaction> getMostWithdrawalList() {
        List<Transaction> transactionSortList = new ArrayList<>(transactionList);

        return transactionSortList.stream()
                .filter(transaction -> transaction.getTransactionValue() < 0)
                .sorted(Comparator.comparingInt(Transaction::getTransactionValue))
                .limit(10)
                .collect(Collectors.toList());
    }

    /**
     * 특정 달 검색
     *
     * @param start
     * @param end
     * @return
     */
    public List<Transaction> searchPeriodTransactionList(LocalDate start, LocalDate end) {
        List<Transaction> periodTransactionList = new ArrayList<>(transactionList);

        Iterator<Transaction> iterator = periodTransactionList.iterator();
        while (iterator.hasNext()) {
            Transaction cur = iterator.next();
            // Month >= 관련 수정!
            if (!((cur.getTransactionDate().isEqual(start) || cur.getTransactionDate().isEqual(end)) || cur.getTransactionDate().isAfter(start) && cur.getTransactionDate().isBefore(end)))
                iterator.remove();
        }

        return periodTransactionList;
    }
}
