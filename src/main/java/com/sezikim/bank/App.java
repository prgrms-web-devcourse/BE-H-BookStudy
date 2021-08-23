package com.sezikim.bank;

import com.sezikim.bank.util.CSVParser;
import com.sezikim.bank.util.Parser;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        TransactionAnalyzer transactionAnalyzer = new TransactionAnalyzer();
        Parser parser = new CSVParser();

        try {
            transactionAnalyzer.analyze(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
