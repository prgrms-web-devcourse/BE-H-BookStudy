package com.sezikim.bank.view;

import com.sezikim.bank.model.Transaction;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

import static com.sezikim.bank.model.Transaction.TRANSACTION_FORMAT;

public class TransactionPrinter {

    public void printAmountBankStatement(int amountDeposit, int amountWithdrawal) {
        System.out.println("총입금액: " + amountDeposit);
        System.out.println("총출금액: " + amountWithdrawal);
        System.out.println("자산 변화: " + (amountDeposit - amountWithdrawal));
        System.out.println();
    }

    public void printMonthlyBankStatement(HashMap<Month, Integer> transactionCountMap) {
        System.out.println("월별 입출금 횟수");

        for (Month month : Month.values()) {
            if (transactionCountMap.containsKey(month)) {
                System.out.println(month + " " + transactionCountMap.get(month));
                continue;
            }

            System.out.println(month + " " + 0);
        }

        System.out.println();
    }

    public void printMostWithdrawalList(List<Transaction> mostWithdrawalTransactionList) {
        System.out.println("지출 상위 10건");
        System.out.println(String.format(TRANSACTION_FORMAT, "거래 일자", "거래 대금", "거래 항목"));
        for (Transaction transaction : mostWithdrawalTransactionList) {
            System.out.println(transaction);
        }

        System.out.println();
    }

    public void printMostWithdrawalContent(String mostWithdrawalContent) {
        System.out.println("지출 최고 항목");
        System.out.println(mostWithdrawalContent);
        System.out.println();
    }
}
