package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;
import com.sezikim.bank.util.CSVFileReader;

import java.io.*;
import java.util.List;

public class App {

    private static final String CSV_FILE_PATH = "src/main/resources/data.txt";

    public static void main(String[] args) {

        try {
            List<Transaction> transactionList = new CSVFileReader(CSV_FILE_PATH).readCSVFile();
            TransactionAnalyzer transactionAnalyzer = new TransactionAnalyzer(transactionList);
            transactionAnalyzer.printAnalysis();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
