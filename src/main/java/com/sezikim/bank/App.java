package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;
import com.sezikim.bank.util.CSVFileReader;

import java.io.*;
import java.util.List;

public class App {
    private static final String filePath = "src/main/resources/data.txt";

    public static void main(String[] args) {

        try {
            List<Transaction> transactionList = new CSVFileReader(filePath).readCSVFile();
            TransactionAnalyzer transactionAnalyzer = new TransactionAnalyzer(transactionList);
            transactionAnalyzer.printAmountBankStatement();
            transactionAnalyzer.printMonthlyBankStatement();
            transactionAnalyzer.printMostWithdrawalList();
            transactionAnalyzer.printMostWithdrawalCategory();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
