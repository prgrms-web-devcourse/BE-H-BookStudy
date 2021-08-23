package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;
import com.sezikim.bank.util.CSVParser;
import com.sezikim.bank.util.Parser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorTest {

    private final Parser parser = new CSVParser();

    @Test
    void getAmountDeposit() {
        String tr1 = "30-01-2017, -100, Deliveroo";
        String tr2 = "01-02-2017, 6000, Salary";
        String tr3 = "02-02-2017, 2000, Royalties";
        String tr4 = "02-02-2017, -4000, Rent";
        List<String> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);
        list.add(tr3);
        list.add(tr4);
        List<Transaction> transactionList = parser.parseLinesFrom(list);

        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionList);
        int amountDeposit = transactionProcessor.getAmountDeposit();

        assertEquals(amountDeposit, 8000);
    }

    @Test
    void getAmountWithdrawal() {
        String tr1 = "30-01-2017, -100, Deliveroo";
        String tr2 = "01-02-2017, 6000, Salary";
        String tr3 = "02-02-2017, 2000, Royalties";
        String tr4 = "02-02-2017, -4000, Rent";
        List<String> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);
        list.add(tr3);
        list.add(tr4);
        List<Transaction> transactionList = parser.parseLinesFrom(list);

        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionList);
        int amountWithdrawal = transactionProcessor.getAmountWithdrawal();

        assertEquals(amountWithdrawal, -4100);
    }

    @Test
    void getMonthlyTransactionCount() {
        String tr1 = "30-01-2017, -100, Deliveroo";
        String tr2 = "01-02-2017, 6000, Salary";
        String tr3 = "02-02-2017, 2000, Royalties";
        String tr4 = "02-02-2017, -4000, Rent";
        List<String> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);
        list.add(tr3);
        list.add(tr4);
        List<Transaction> transactionList = parser.parseLinesFrom(list);

        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionList);
        HashMap<Month, Integer> monthlyTransactionCount = transactionProcessor.getMonthlyTransactionCount();

        assertEquals(monthlyTransactionCount.get(Month.JANUARY), 1);
        assertEquals(monthlyTransactionCount.get(Month.FEBRUARY), 3);
        assertEquals(monthlyTransactionCount.get(Month.MARCH), 0);
    }

    @Test
    void getMostWithdrawalContent() {
        String tr1 = "30-01-2017, -100, Deliveroo";
        String tr2 = "01-02-2017, 6000, Salary";
        String tr3 = "02-02-2017, 2000, Royalties";
        String tr4 = "02-02-2017, -4000, Rent";
        List<String> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);
        list.add(tr3);
        list.add(tr4);
        List<Transaction> transactionList = parser.parseLinesFrom(list);

        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionList);
        String mostWithdrawalContent = transactionProcessor.getMostWithdrawalContent();

        assertEquals(mostWithdrawalContent, "Rent");
    }

    @Test
    void getMostWithdrawalList() {
        String tr1 = "30-01-2017, -100, Deliveroo";
        String tr2 = "01-02-2017, 6000, Salary";
        String tr3 = "02-02-2017, 2000, Royalties";
        String tr4 = "02-02-2017, -4000, Rent";
        List<String> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);
        list.add(tr3);
        list.add(tr4);
        List<Transaction> transactionList = parser.parseLinesFrom(list);

        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionList);
        List<Transaction> mostWithdrawalList = transactionProcessor.getMostWithdrawalList();

        assertEquals(mostWithdrawalList.get(0), parser.parseFrom(tr4));
        assertEquals(mostWithdrawalList.get(1), parser.parseFrom(tr1));
    }

    @Test
    void searchPeriodTransactionList() {
        String tr1 = "30-01-2017, -100, Deliveroo";
        String tr2 = "01-02-2017, 6000, Salary";
        String tr3 = "02-02-2017, 2000, Royalties";
        String tr4 = "02-02-2017, -4000, Rent";
        List<String> list = new ArrayList<>();
        list.add(tr1);
        list.add(tr2);
        list.add(tr3);
        list.add(tr4);
        List<Transaction> transactionList = parser.parseLinesFrom(list);

        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionList);
        LocalDate start = LocalDate.of(2017,1,20);
        LocalDate end = LocalDate.of(2017,2,1);
        List<Transaction> searchPeriodTransactionList = transactionProcessor.searchPeriodTransactionList(start, end);

        System.out.println(searchPeriodTransactionList);

        assertEquals(searchPeriodTransactionList.size(), 2);
    }
}