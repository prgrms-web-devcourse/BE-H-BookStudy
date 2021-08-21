package com.sezikim.bank;

import com.sezikim.bank.model.Transaction;
import com.sezikim.bank.util.Parser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TransactionAnalyzer {
    private static final String CSV_FILE_PATH = "src/main/resources/data.txt";

    public void analyze(Parser parser) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(CSV_FILE_PATH));
        List<Transaction> transactionList = parser.parseLinesFrom(lines);
        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionList);
        transactionProcessor.printAnalysis();
    }
}
